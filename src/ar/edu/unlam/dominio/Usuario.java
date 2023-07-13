package ar.edu.unlam.dominio;

import java.util.Objects;

public abstract class Usuario implements Comparable<Usuario>{

	private String nombre;
	private String contrasenia;
	

	public Usuario(String nombre, String contrasenia) {
		super();
		this.nombre = nombre;
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return nombre.compareTo(o.getNombre());
	}

	public abstract boolean validarContrasenia(Usuario usuario) throws Exception;

	protected abstract boolean loguearse(String nombre, String contrasenia) throws Exception;
	
	
	
}
