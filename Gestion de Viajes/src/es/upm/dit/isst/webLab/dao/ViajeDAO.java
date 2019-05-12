package es.upm.dit.isst.webLab.dao;

import java.util.Collection;
import java.util.List;

import es.upm.dit.isst.webLab.model.Viaje;

public interface ViajeDAO {
	
	public void create(Viaje viaje);
	public Viaje read(int id);
	public void update(Viaje viaje);
	public void delete(Viaje viaje);
	public List<Viaje> readAll();
	

}
