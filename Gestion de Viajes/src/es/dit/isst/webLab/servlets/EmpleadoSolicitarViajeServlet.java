package es.dit.isst.webLab.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

@WebServlet({"/EmpleadoSolicitarViajeServlet"})
public class EmpleadoSolicitarViajeServlet extends HttpServlet {
	
	private String empleadoEmail;
	private Empleado empleado;
	private Empleado supervisor;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.empleadoEmail = req.getParameter("email");
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		this.empleado =  edao.read(this.empleadoEmail);
		this.supervisor = this.empleado.getSupervisor();
		

	
		getServletContext().getRequestDispatcher( "/empleadoSolicitarViaje.jsp" ).forward( req, resp );

	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmpleadoDAO edao = EmpleadoDAOImplementation.getInstance();
		
		String destino = req.getParameter("destino");
		String origen = req.getParameter("origen");
		Date fechaInicio = parseFecha(req.getParameter("fechaInicio")); 
		Date fechaFin = parseFecha(req.getParameter("fechaFin")); 
		String descripcion = req.getParameter("descripcion");
		int precio = Integer.parseInt(req.getParameter("precio")); 
		
		int id = (int)(Math.random()*10000);
		
		


		

		Viaje viaje = new Viaje();
		
		viaje.setId(id);
		viaje.setDestino(destino);
		viaje.setFechaFin(fechaFin);
		viaje.setFechaInicio(fechaInicio);
		viaje.setOrigen(origen);
		viaje.setDescripcion(descripcion);

		viaje.setPrecio(precio);
		viaje.setEmpleado(this.empleado);
		viaje.setEstado(2);

		ViajeDAO vdao = ViajeDAOImplementation.getInstance();
		vdao.create( viaje );
		
		
		edao.update(this.empleado);
		
		
		resp.sendRedirect( req.getContextPath() + "/EmpleadoViajesServlet?email="+this.empleadoEmail);
	}
	
	
	private static Date parseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
	
	
	

}



