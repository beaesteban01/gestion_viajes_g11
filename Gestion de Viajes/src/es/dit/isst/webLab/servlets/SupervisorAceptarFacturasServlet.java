package es.dit.isst.webLab.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import es.upm.dit.isst.webLab.model.Factura;
import es.upm.dit.isst.webLab.dao.FacturaDAOImplementation;
import es.upm.dit.isst.webLab.dao.FacturaDAO;

@WebServlet("/SupervisorAceptarFacturasServlet")

public class SupervisorAceptarFacturasServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		ViajeDAO vdao = ViajeDAOImplementation.getInstance();
		Viaje viaje = vdao.read(id);
		List<Factura> listaFacturas = viaje.getFacturas();
		List<Factura> facturasPendientes = new ArrayList<>();
		List<Factura> facturasAceptadas = new ArrayList<>();
		for(Factura fact : listaFacturas) {
			if(fact.getEstado() == 0) {
				facturasAceptadas.add(fact);
			}
			if(fact.getEstado() == 2) {
				facturasPendientes.add(fact);
			}
		}
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFin = formatoFecha.format(viaje.getFechaFin());
		String fechaInicio = formatoFecha.format(viaje.getFechaInicio());
		
		req.getSession().setAttribute("empleado", viaje.getEmpleado().getEmail());
		req.getSession().setAttribute("origen", viaje.getOrigen());
		req.getSession().setAttribute("destino", viaje.getDestino());
		req.getSession().setAttribute("fechaInicio", fechaInicio);
		req.getSession().setAttribute("fechaFin", fechaFin);
		req.getSession().setAttribute("facturas_list_pendientes", facturasPendientes);
		req.getSession().setAttribute("facturas_list_aceptadas", facturasAceptadas);

		
		getServletContext().getRequestDispatcher( "/supervisorAceptarFacturas.jsp" ).forward( req, resp );
		
	}
	// TODO: doPost del enviar su formulario realizado
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			String estado = req.getParameter("estado");
			String idd = req.getParameter("id");
			int id = Integer.parseInt(idd);
			String rechazo = req.getParameter("rechazo");
			
			FacturaDAO fdao = FacturaDAOImplementation.getInstance();
			Factura factura = fdao.read(id);
			
			if(estado.equals("true")) {
				factura.setEstado(0);
				System.out.println("Autorizado ?"+factura.getEstado());

			}else if(estado.equals("false")){
				factura.setEstado(1);
				factura.setRechazo(rechazo);
				System.out.println("Rechazado? " +factura.getEstado());

				
			}
			fdao.update(factura);
		
			resp.sendRedirect(req.getContextPath()+"/SupervisorAceptarFacturasServlet?id="+factura.getViaje().getId());

	
	}
	
	
	
}
