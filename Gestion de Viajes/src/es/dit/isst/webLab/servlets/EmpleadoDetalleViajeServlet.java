package es.dit.isst.webLab.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java .util.List;

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

@WebServlet({"/EmpleadoDetalleViajeServlet"})
public class EmpleadoDetalleViajeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int viajeID = Integer.parseInt(req.getParameter("id"));
		ViajeDAO vdao = ViajeDAOImplementation.getInstance();
		Viaje viaje = vdao.read(viajeID);
		
		
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		String fechaFin = formatoFecha.format(viaje.getFechaFin());
		String fechaInicio = formatoFecha.format(viaje.getFechaInicio());

		
		req.getSession().setAttribute("idViaje", viaje.getId());
		req.getSession().setAttribute("origen", viaje.getOrigen());
		req.getSession().setAttribute("destino", viaje.getDestino());
		req.getSession().setAttribute("fechaInicio", fechaInicio);
		req.getSession().setAttribute("fechaFin", fechaFin);
		req.getSession().setAttribute("facturas_list", viaje.getFacturas());
		
		
		System.out.println(viaje.getDestino());
		System.out.println(viaje.getOrigen());
		System.out.println(viaje.getFechaInicio());
		System.out.println(viaje.getFechaFin());
				
	
		getServletContext().getRequestDispatcher( "/empleadoDetalleViaje.jsp" ).forward( req, resp );

	
	}
	
	
	
	
}
