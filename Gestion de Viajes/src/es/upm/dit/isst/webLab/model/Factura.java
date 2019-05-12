package es.upm.dit.isst.webLab.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Factura implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	//@ManyToOne(fetch = FetchType.EAGER, targetEntity = Viaje.class)
	@ManyToOne
	private Viaje viaje;
	private String lugar;
	private int precio;
	private String descripcion;
	private Date fecha;
	private int estado;
	private String rechazo;
	
	public String getRechazo() {
		return rechazo;
	}

	public void setRechazo(String rechazo) {
		this.rechazo = rechazo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	@Lob 
	private byte[] factura;
	
	


	public Factura() {
		
	}
	
	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return fecha;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setFactura(byte[] factura) {
		this.factura = factura;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public byte[] getFactura() {
		return factura;
	}
	public String getLugar() {
		return lugar;
	}
	public int getPrecio() {
		return precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	

}
