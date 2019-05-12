package es.upm.dit.isst.webLab.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Empleado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	@Id
	private String email;
	private String password;
	private String name;
	@ManyToOne
	private Empleado supervisor;
	//1 supervisor para cada empleado
	
	private String dni;
	private String empresa;
	private String departamento;
	private String cuenta;
	@OneToMany(mappedBy="empleado",fetch=FetchType.EAGER)
	private List<Viaje> requestedViajes;
	
	private boolean isSupervisor;
	
	@OneToMany(mappedBy="supervisor",fetch=FetchType.LAZY)
	private List<Empleado> empleados;
	


	public List<Viaje> getRequestedViajes() {
		return requestedViajes;
	}


	public void setRequestedViajes(List<Viaje> requestedViajes) {
		this.requestedViajes = requestedViajes;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public String getName() {
		return name;
	}


	public Empleado getSupervisor() {
		return supervisor;
	}


	public String getDni() {
		return dni;
	}


	public String getEmpresa() {
		return empresa;
	}


	public String getDepartamento() {
		return departamento;
	}


	public String getCuenta() {
		return cuenta;
	}
	
	

	public void setEmail(String email) {
		this.email = email;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setSupervisor(Empleado supervisor) {
		this.supervisor = supervisor;
	}


	public void setSupervisor(boolean isSupervisor) {
		this.isSupervisor = isSupervisor;
	}


	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}


	public boolean isSupervisor() {
		return isSupervisor;
	}


	public List<Empleado> getEmpleados() {
		return empleados;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}


	public Empleado(){
		
	}

	
}