package es.upm.dit.isst.webLab.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.webLab.model.Empleado;

public class EmpleadoDAOImplementation implements EmpleadoDAO{
	
	private static EmpleadoDAOImplementation instancia = null;
	
	private EmpleadoDAOImplementation(){
		
	}
	
	public static EmpleadoDAOImplementation getInstance(){
		if(null == instancia){
			instancia = new EmpleadoDAOImplementation();
		}
		return instancia;
	}

	@Override
	public void create(Empleado empleado) {
		Session session = SessionFactoryService.get().openSession();
		try{
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}		
	}

	@Override
	public Empleado read(String email) {
		Session session = SessionFactoryService.get().openSession();
		Empleado empleado = null;
		try{
			session.beginTransaction();
			empleado = session.load(Empleado.class, email);
			session.getTransaction().commit();	
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		return empleado;
	}

	@Override
	public void update(Empleado empleado) {
		Session session = SessionFactoryService.get().openSession();
		try{
			session.beginTransaction();
			session.saveOrUpdate(empleado);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		
	}
	
	
	
	@Override
	public void delete(Empleado empleado) {
		Session session = SessionFactoryService.get().openSession();
		try{
			session.beginTransaction();
			session.delete(empleado);
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> readAll() {
		Session session = SessionFactoryService.get().openSession();
		List<Empleado> empleados = null;
		try{
			session.beginTransaction();
			empleados = session.createQuery("from Empleado").list();
			session.getTransaction().commit();
		}catch(Exception e){
			
		}finally{
			session.close();
		}	
		return empleados;
	}
	
	
	
}
