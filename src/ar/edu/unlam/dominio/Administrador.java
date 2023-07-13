package ar.edu.unlam.dominio;

public class Administrador extends Usuario {

	public Administrador(String nombre, String contrasenia) {
		super(nombre, contrasenia);
		// TODO Auto-generated constructor stub
	}

	public boolean validarContrasenia(Usuario usuario) throws Exception {
		
		String patron = "^(?=.*[a-z][0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).+$";
		if(usuario.getContrasenia().matches(patron)) {
			return true;
		}throw new InvalidPasswordException("contraseña invalida");
		
	}
	@Override
	protected boolean loguearse(String nombre, String contrasenia) throws Exception {
		if (nombre.equals(getNombre())&& contrasenia.equals(getContrasenia())) {
			return true;
		}throw new InvalidPasswordException("contraseña invalida");
	
	}

	//Los usuarios administradores además de los requisitos de la contraseña de los usuarios básicos deben tener un carácter especial y no puede tener secuencia de más
	//de 3 caracteres seguidos (123 y abc es válido, pero 1234 o abcd no). 
}
