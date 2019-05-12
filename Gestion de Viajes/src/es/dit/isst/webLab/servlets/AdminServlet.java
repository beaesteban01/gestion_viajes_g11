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




@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//req.getSession().setAttribute( "supervisor_list", sdao.readAll() );
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		List<Empleado> empleados = edao.readAll();
		List<Empleado> supervisores = new ArrayList<>();
		if(empleados != null) {
			for(Empleado emp : empleados) {
				if(emp.isSupervisor() == true) {
					supervisores.add(emp);
				}
			}
		}
		req.getSession().setAttribute( "empleado_list", empleados );
		req.getSession().setAttribute( "supervisor_list", supervisores );

		getServletContext().getRequestDispatcher( "/AdminView.jsp" ).forward( req, resp );
	}
	
	
}
