package es.upm.dit.isst.webLab.dao;

import java.util.List;

import es.upm.dit.isst.webLab.model.Factura;

public interface FacturaDAO {

	public void create(Factura factura);
	public Factura read(int id);
	public void update(Factura factura);
	public void delete(Factura factura);
	public List<Factura> readAll();

}
