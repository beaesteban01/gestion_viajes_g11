package es.dit.isst.webLab.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import es.upm.dit.isst.webLab.model.Viaje;
import es.upm.dit.isst.webLab.dao.ViajeDAO;
import es.upm.dit.isst.webLab.dao.ViajeDAOImplementation;

@WebServlet("/AdminDecisionServlet")
public class AdminDecisionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		int decision = Integer.parseInt(req.getParameter("decision"));
		
		ViajeDAO viajedao = ViajeDAOImplementation.getInstance();
		Viaje viaje = viajedao.read(id);
		
		try{
			if(decision == 1){ // Viaje aceptado
				Client client = ClientBuilder.newClient();
				
				Response response = client.target("http://gestion.viajes.admin/rest")
						.path("refund")
				        .request(MediaType.APPLICATION_JSON)
				        .post(Entity.entity(viaje, MediaType.APPLICATION_JSON));
				
				client.close();
				
				// Error enviando el viaje a la pasarela de reembolso
				if(response.getStatus()/100 != 2){
					getServletContext().getRequestDispatcher("/ViewName.jsp").forward(req, res);
				}else{ // Viaje enviado correctamente a la pasarela de reembolso
					viajedao.delete(viaje);
					getServletContext().getRequestDispatcher("/ViewName.jsp").forward(req, res);
				}
			}else{ // Viaje rechazado, se vuelve a estado anterior
				//viaje.set
			}
		}catch(Exception e){
			getServletContext().getRequestDispatcher("/viewName.jsp").forward(req, res);
		}
	}

}
