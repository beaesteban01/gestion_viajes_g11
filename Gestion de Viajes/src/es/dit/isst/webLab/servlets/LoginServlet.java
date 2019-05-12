package es.dit.isst.webLab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.authc.UsernamePasswordToken;

import es.upm.dit.isst.webLab.dao.EmpleadoDAO;
import es.upm.dit.isst.webLab.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.webLab.dao.FacturaDAO;
import es.upm.dit.isst.webLab.dao.FacturaDAOImplementation;
import es.upm.dit.isst.webLab.dao.ViajeDAOImplementation;
import es.upm.dit.isst.webLab.model.Empleado;
import es.upm.dit.isst.webLab.model.Factura;

@WebServlet({ "/LoginServlet", "/" })
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		List<Empleado> empleados =edao.readAll();
		FacturaDAO fdao = FacturaDAOImplementation.getInstance();
		List<Factura> facturas = fdao.readAll();
		getServletContext().getRequestDispatcher("/LoginView.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter( "email" );
		String pass = req.getParameter( "password" );
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		Empleado empleado = edao.read(email);
		Subject currentUser = SecurityUtils.getSubject();
		if ( !currentUser.isAuthenticated() ) {
			UsernamePasswordToken token = new UsernamePasswordToken( email, pass );
			try {
				currentUser.login( token );
				if ( currentUser.hasRole( "admin" ) ) {
					resp.sendRedirect( req.getContextPath() + "/AdminServlet" );
				}
				else if ( empleado.isSupervisor() == true ) {
					resp.sendRedirect( req.getContextPath() + "/SupervisorServlet?email="+currentUser.getPrincipal());
				}
				else if (empleado.isSupervisor() == false) {
					resp.sendRedirect( req.getContextPath() + "/EmpleadoServlet?email=" + currentUser.getPrincipal() );
				}
			} catch ( Exception e ) {
				resp.sendRedirect( req.getContextPath() + "/LoginServlet" );
			}
		} else
			resp.sendRedirect( req.getContextPath() + "/LoginServlet" );
	}
}


