package es.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import es.upm.dit.isst.webLab.dao.EmpleadoDAO;
import es.upm.dit.isst.webLab.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.webLab.dao.ViajeDAO;
import es.upm.dit.isst.webLab.dao.ViajeDAOImplementation;
import es.upm.dit.isst.webLab.model.Empleado;
import es.upm.dit.isst.webLab.model.Viaje;

@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String email = req.getParameter("email");

		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		Empleado empleado = new Empleado();
		empleado = edao.read(email);
		
		req.getSession().setAttribute( "name", empleado.getName() );
		req.getSession().setAttribute( "email", empleado.getEmail() );

		req.getSession().setAttribute("dni", empleado.getDni());
		req.getSession().setAttribute("empresa", empleado.getEmpresa());
		req.getSession().setAttribute("departamento", empleado.getDepartamento());
		req.getSession().setAttribute("cuenta", empleado.getCuenta());

		
		getServletContext().getRequestDispatcher( "/empleadoView.jsp" ).forward( req, resp );
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter( "email" );
		String name = req.getParameter( "name" );
		String empresa = req.getParameter( "empresa" );
		String departamento = req.getParameter( "departamento" );
		String dni = req.getParameter( "dni" );
		String cuenta = req.getParameter( "cuenta" );
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		Empleado empleado = edao.read(email);
		empleado.setName( name );
		empleado.setEmail( email );
		empleado.setDepartamento(departamento);
		empleado.setCuenta(cuenta);
		empleado.setDni(dni);
		empleado.setEmpresa(empresa);
		
		edao.update(empleado);
		
		System.out.println(email);
		
		resp.sendRedirect( req.getContextPath() + "/EmpleadoServlet?email=" + email );
					
		
	}
}
