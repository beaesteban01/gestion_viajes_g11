package es.dit.isst.webLab.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import es.upm.dit.isst.webLab.dao.FacturaDAO;
import es.upm.dit.isst.webLab.dao.FacturaDAOImplementation;
import es.upm.dit.isst.webLab.dao.ViajeDAO;
import es.upm.dit.isst.webLab.dao.ViajeDAOImplementation;
import es.upm.dit.isst.webLab.model.Factura;
import es.upm.dit.isst.webLab.model.Viaje;

@MultipartConfig
@WebServlet({"/EmpleadoSubirFacturaServlet"})
public class EmpleadoSubirFacturaServlet extends HttpServlet {
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		ViajeDAO vdao = ViajeDAOImplementation.getInstance();
		Viaje viaje = vdao.read(id);
		
		Part filePart = req.getPart("factura");
		InputStream fileContent = filePart.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[10240];
		for (int length = 0; (length = fileContent.read(buffer)) > 0;) output.write(buffer, 0, length);
		
		
		FacturaDAO fdao = FacturaDAOImplementation.getInstance();
		Factura factura = new Factura();
		
		String lugar = req.getParameter("lugar");
		int precio = Integer.parseInt(req.getParameter("precio"));
		String descripcion = req.getParameter("descripcion");
		Date fecha = parseFecha(req.getParameter("fecha")); 

		
		
		int idFactura = (int)(Math.random()*100000);
		
		factura.setId(idFactura);
		factura.setFactura(output.toByteArray());
		factura.setLugar(lugar);
		factura.setPrecio(precio);
		factura.setDescripcion(descripcion);
		factura.setFecha(fecha);
		factura.setViaje(viaje);
		factura.setEstado(2);
		
		fdao.create(factura);
		
		System.out.println("Viaje con factura: " + factura.getViaje().getDestino());

		vdao.update(viaje);
		System.out.println("Numero de facturas subidas: " + viaje.getFacturas().size());

		
		resp.sendRedirect(req.getContextPath()+"/EmpleadoDetalleViajeServlet?id="+viaje.getId());
	
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
