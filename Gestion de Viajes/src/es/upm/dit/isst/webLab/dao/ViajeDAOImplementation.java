package es.upm.dit.isst.webLab.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.webLab.model.Viaje;

public class ViajeDAOImplementation implements ViajeDAO{
	
	private static ViajeDAOImplementation instancia = null;
	
	private ViajeDAOImplementation(){
		
	}
	
	public static ViajeDAOImplementation getInstance(){
		if(null == instancia){
			instancia = new ViajeDAOImplementation();
		}
		return instancia;
	}

	@Override
	public void create(Viaje viaje) {
		Session session = SessionFactoryService.get().openSession();
		try{
			session.beginTransaction();
			session.save(viaje);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}		
	}

	@Override
	public Viaje read(int destino) {
		Session session = SessionFactoryService.get().openSession();
		Viaje viaje = null;
		try{
			session.beginTransaction();
			viaje = session.load(Viaje.class, destino);
			session.getTransaction().commit();	
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		return viaje;
	}

	@Override
	public void update(Viaje viaje) {
		Session session = SessionFactoryService.get().openSession();
		try{
			session.beginTransaction();
			session.saveOrUpdate(viaje);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		
	}
	
	
	
	@Override
	public void delete(Viaje viaje) {
		Session session = SessionFactoryService.get().openSession();
		try{
			session.beginTransaction();
			session.delete(viaje);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Viaje> readAll() {
		Session session = SessionFactoryService.get().openSession();
		List<Viaje> viajes = null;
		try{
			session.beginTransaction();
			viajes = session.createQuery("from Viaje").list();
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		return viajes;
	}
	
}
