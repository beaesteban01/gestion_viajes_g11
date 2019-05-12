package es.dit.isst.webLab.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
import es.upm.dit.isst.webLab.model.Viaje;


@WebServlet("/SupervisorAutorizacionViajeServlet")
public class SupervisorAutorizacionViajeServlet  extends HttpServlet{
	
	private String email;
	private int id;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		this.id = Integer.parseInt(req.getParameter( "id" ));

		ViajeDAO vdao = ViajeDAOImplementation.getInstance();
		Viaje viaje = vdao.read(this.id);
		this.email = viaje.getEmpleado().getSupervisor().getEmail();
		
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFin = formatoFecha.format(viaje.getFechaFin());
		String fechaInicio = formatoFecha.format(viaje.getFechaInicio());
		
		req.getSession().setAttribute("origen", viaje.getOrigen());
		req.getSession().setAttribute("destino", viaje.getDestino());
		req.getSession().setAttribute("fechaInicio", fechaInicio);
		req.getSession().setAttribute("fechaFin", fechaFin);
		req.getSession().setAttribute("descripcion", viaje.getDescripcion());
		req.getSession().setAttribute("precio", viaje.getPrecio());
		req.getSession().setAttribute("empleado", viaje.getEmpleado().getName());
		
		req.getSession().setAttribute("email",viaje.getEmpleado().getSupervisor().getEmail());
		
		System.out.println(viaje.getDestino());
		System.out.println(viaje.getOrigen());
		System.out.println(fechaInicio);
		System.out.println(fechaFin);
		
		
		getServletContext().getRequestDispatcher( "/supervisorAutorizacionViaje.jsp" ).forward( req, resp );
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String autorizar = req.getParameter("autorizar");
		ViajeDAO vdao = ViajeDAOImplementation.getInstance();
		Viaje viaje = vdao.read(this.id);
		System.out.println(this.id);
	

		if(autorizar.equals("si")) {
			viaje.setEstado(0);
			System.out.println("Autorizado ");

		}else if(autorizar.equals("no")){
			viaje.setEstado(1);
		}
		
		
		
		vdao.update(viaje);
		resp.sendRedirect( req.getContextPath() + "/SupervisorRevisionViajesServlet?email=" + this.email );

	
	}
}
