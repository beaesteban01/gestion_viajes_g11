package es.dit.isst.webLab.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.EmpleadoDAO;
import es.upm.dit.isst.webLab.dao.EmpleadoDAOImplementation;
import es.upm.dit.isst.webLab.dao.FacturaDAO;
import es.upm.dit.isst.webLab.dao.FacturaDAOImplementation;
import es.upm.dit.isst.webLab.dao.ViajeDAO;
import es.upm.dit.isst.webLab.dao.ViajeDAOImplementation;
import es.upm.dit.isst.webLab.model.Empleado;
import es.upm.dit.isst.webLab.model.Factura;
import es.upm.dit.isst.webLab.model.Viaje;

@WebServlet("/SupervisorDescargarFacturaServlet")
public class SupervisorDescargarFacturaServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idd = req.getParameter("id");
		int id = Integer.parseInt(idd);
		
		FacturaDAO fdao = FacturaDAOImplementation.getInstance();
		Factura factura = fdao.read(id);
		
		resp.setContentLength(factura.getFactura().length);
		resp.getOutputStream().write(factura.getFactura());
		
		

		
	}

}
