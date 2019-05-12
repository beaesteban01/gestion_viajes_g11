package es.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import es.upm.dit.isst.webLab.dao.EmpleadoDAO;
import es.upm.dit.isst.webLab.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.webLab.model.Empleado;



@WebServlet("/SupervisorServlet")
public class SupervisorServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String email = req.getParameter("email");
		EmpleadoDAO sdao = EmpleadoDAOImplementation.getInstance();
		Empleado supervisor = new Empleado();
		supervisor = sdao.read(email);
		req.getSession().setAttribute( "name", supervisor.getName() );
		req.getSession().setAttribute("email", supervisor.getEmail());
		req.getSession().setAttribute("dni", supervisor.getDni());
		req.getSession().setAttribute("empresa", supervisor.getEmpresa());
		req.getSession().setAttribute("departamento", supervisor.getDepartamento());
		req.getSession().setAttribute("cuenta", supervisor.getCuenta());
		
		getServletContext().getRequestDispatcher( "/SupervisorView.jsp" ).forward( req, resp );
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter( "name" );
		String email = req.getParameter( "email" );
		String cuenta = req.getParameter( "cuenta" );
		String departamento = req.getParameter( "departamento" );
		String dni = req.getParameter( "dni" );
		String empresa = req.getParameter("empresa");
		
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		Empleado supervisor = edao.read(email);
		supervisor.setName( name );
		supervisor.setEmail( email );
		supervisor.setCuenta(cuenta);
		supervisor.setDepartamento(departamento);
		supervisor.setDni(dni);
		supervisor.setEmpresa(empresa);
		
		edao.update(supervisor);
		
		resp.sendRedirect( req.getContextPath() + "/SupervisorServlet?email="+email);
		
		
		
	}
	
	
	
}