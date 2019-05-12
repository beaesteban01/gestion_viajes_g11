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

import es.upm.dit.isst.webLab.dao.ViajeDAO;
import es.upm.dit.isst.webLab.dao.ViajeDAOImplementation;
import es.upm.dit.isst.webLab.model.Empleado;
import es.upm.dit.isst.webLab.model.Viaje;

@WebServlet("/AdminListaViajesServlet")
public class AdminListaViajesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		ViajeDAO vdao = ViajeDAOImplementation.getInstance();
		
		List<Viaje> viajes = vdao.readAll();
		
		req.getSession().setAttribute("viajes_list", viajes);
		
		
		getServletContext().getRequestDispatcher( "/adminListaViajes.jsp" ).forward( req, resp );
	}
	
}
