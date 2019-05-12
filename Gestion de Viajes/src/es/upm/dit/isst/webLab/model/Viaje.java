package es.upm.dit.isst.webLab.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Viaje implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	@Id
	private int id;

	@ManyToOne
	private Empleado empleado;
	private String destino;
	private String origen;
	private Date fechaInicio;
	private Date fechaFin;
	private int precio;
	private String descripcion;
	private int estado;
	private int estadoViaje;
	
	@OneToMany(mappedBy="viaje",fetch=FetchType.EAGER)
	private List<Factura> facturas;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setEstadoViaje(int estadoViaje) {
		this.estadoViaje = estadoViaje;
	}

	public int getEstadoViaje() {
		return estadoViaje;
	}

	public Viaje(){
		
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}



	public int getEstado() {
		return estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Empleado getEmpleado() {
		return empleado;
	}



	public String getDestino() {
		return destino;
	}



	public String getOrigen() {
		return origen;
	}



	public Date getFechaInicio() {
		return fechaInicio;
	}



	public Date getFechaFin() {
		return fechaFin;
	}



	public int getPrecio() {
		return precio;
	}



	public String getDescripcion() {
		return descripcion;
	}






	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}



	public void setDestino(String destino) {
		this.destino = destino;
	}



	public void setOrigen(String origen) {
		this.origen = origen;
	}



	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}



	public void setPrecio(int precio) {
		this.precio = precio;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	
	
}