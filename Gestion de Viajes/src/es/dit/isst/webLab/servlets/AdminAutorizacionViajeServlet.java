package es.dit.isst.webLab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.EmpleadoDAO;
import es.upm.dit.isst.webLab.dao.EmpleadoDAOImplementation;

import es.upm.dit.isst.webLab.dao.ViajeDAO;
import es.upm.dit.isst.webLab.dao.ViajeDAOImplementation;
import es.upm.dit.isst.webLab.model.Empleado;
import es.upm.dit.isst.webLab.model.Factura;

import es.upm.dit.isst.webLab.model.Viaje;


@WebServlet("/AdminAutorizacionViajeServlet")
public class AdminAutorizacionViajeServlet  extends HttpServlet{
	
	private String email;
	private int id;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		this.id = Integer.parseInt(req.getParameter( "id" ));

		ViajeDAO vdao = ViajeDAOImplementation.getInstance();
		Viaje viaje = vdao.read(this.id);
		List<Factura> facturas = viaje.getFacturas();
		this.email = viaje.getEmpleado().getSupervisor().getEmail();

		req.getSession().setAttribute("origen", viaje.getOrigen());
		req.getSession().setAttribute("destino", viaje.getDestino());
		req.getSession().setAttribute("fechaInicio", viaje.getFechaInicio());
		req.getSession().setAttribute("fechaFin", viaje.getFechaFin());
		req.getSession().setAttribute("descripcion", viaje.getDescripcion());
		req.getSession().setAttribute("precio", viaje.getPrecio());
		req.getSession().setAttribute("empleado", viaje.getEmpleado().getName());
		req.getSession().setAttribute("facturas_list", facturas);
		req.getSession().setAttribute("email",viaje.getEmpleado().getSupervisor().getEmail());
				
		getServletContext().getRequestDispatcher( "/adminAutorizacionViaje.jsp" ).forward( req, resp );
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String autorizar = req.getParameter("autorizar");
		ViajeDAO vdao = ViajeDAOImplementation.getInstance();
		Viaje viaje = vdao.read(this.id);

		if(autorizar.equals("si")) {
			viaje.setEstado(3);
			System.out.println("Autorizado ");

		}else if(autorizar.equals("no")){
			viaje.setEstado(4);
		}
		
		vdao.update(viaje);
		resp.sendRedirect( req.getContextPath() + "/AdminListaViajesServlet");

	
	}
}
