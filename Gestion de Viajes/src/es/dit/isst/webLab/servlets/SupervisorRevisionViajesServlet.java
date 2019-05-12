package es.dit.isst.webLab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.EmpleadoDAO;
import es.upm.dit.isst.webLab.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.webLab.model.Empleado;
import es.upm.dit.isst.webLab.model.Viaje;

@WebServlet("/SupervisorRevisionViajesServlet")
public class SupervisorRevisionViajesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		EmpleadoDAO sdao = EmpleadoDAOImplementation.getInstance();
		Empleado supervisor = sdao.read(email);
		List<Empleado> listaEmpleados = supervisor.getEmpleados();
		List<Viaje> listaViajes = new ArrayList<Viaje>();
		for(Empleado emp : listaEmpleados) {
			listaViajes = emp.getRequestedViajes();
		}
		req.getSession().setAttribute( "viajes_list", listaViajes);
		
		getServletContext().getRequestDispatcher( "/supervisorRevisionViajes.jsp" ).forward( req, resp );
	}
	
}
