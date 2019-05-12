package es.upm.dit.isst.webLab.dao;

import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.webLab.model.Factura;

public class FacturaDAOImplementation implements FacturaDAO{
	
	private static FacturaDAOImplementation instancia = null;
	
	private FacturaDAOImplementation(){
		
	}
	
	public static FacturaDAOImplementation getInstance(){
		if(null == instancia){
			instancia = new FacturaDAOImplementation();
		}
		return instancia;
	}

	@Override
	public void create(Factura factura) {
		Session session = SessionFactoryService.get().openSession();
		try{
			session.beginTransaction();
			session.save(factura);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}		
	}

	@Override
	public Factura read(int id) {
		Session session = SessionFactoryService.get().openSession();
		Factura factura = null;
		try{
			session.beginTransaction();
			factura = session.load(Factura.class, id);
			session.getTransaction().commit();	
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		return factura;
	}

	@Override
	public void update(Factura factura) {
		Session session = SessionFactoryService.get().openSession();
		try{
			session.beginTransaction();
			session.saveOrUpdate(factura);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		
	}
	
	
	
	@Override
	public void delete(Factura factura) {
		Session session = SessionFactoryService.get().openSession();
		try{
			session.beginTransaction();
			session.delete(factura);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Factura> readAll() {
		Session session = SessionFactoryService.get().openSession();
		List<Factura> facturas = null;
		try{
			session.beginTransaction();
			facturas = session.createQuery("from Factura").list();
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		return facturas;
	}

	
	
}
