package es.dit.isst.webLab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ViajeDAO;
import es.upm.dit.isst.webLab.dao.ViajeDAOImplementation;
import es.upm.dit.isst.webLab.dao.EmpleadoDAO;
import es.upm.dit.isst.webLab.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.webLab.model.Empleado;
import es.upm.dit.isst.webLab.model.Viaje;

@WebServlet("/EmpleadoViajesServlet")

public class EmpleadoViajesServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
	
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		Empleado empleado = edao.read(email);
		
		List<Viaje> listaViajes = new ArrayList<Viaje>();
		listaViajes = empleado.getRequestedViajes();
		
		Date hoy = new Date();
		for(Viaje viaj : listaViajes) {
			if(viaj.getEstado() == 0) {
				if(hoy.compareTo(viaj.getFechaFin()) > 0) {
					// EstadoViaje=2 significa que el viaje ha finalizado
					viaj.setEstadoViaje(2);
				}else if(hoy.compareTo(viaj.getFechaInicio()) < 0) {
					// EstadoViaje=0 significa que el viaje no se ha iniciado
					viaj.setEstadoViaje(0);
				} else {
					// EstadoViaje=1 significa que el viaje está activo
					viaj.setEstadoViaje(1);
				}				
			} else {
				// El estado 3 de viaje significa que el viaje está en espera de ser aceptado/rechazado
				viaj.setEstadoViaje(3);
			}
			ViajeDAO vdao = ViajeDAOImplementation.getInstance();
			vdao.update(viaj);
			//System.out.println("Estado del viaje" + viaj.getEstado());
			System.out.println("Estado del viajee" + viaj.getEstadoViaje());
			
		}
		edao.update(empleado);
		
		
		
		req.getSession().setAttribute("viajes_list", empleado.getRequestedViajes());
		getServletContext().getRequestDispatcher( "/empleadoViajes.jsp" ).forward( req, resp );
	}

}
