package ar.edu.unlam.dominio;

public class Basico extends Usuario{

	
	public Basico(String nombre, String contrasenia) {
		super(nombre, contrasenia);
		// TODO Auto-generated constructor stub
	}

	public boolean validarContrasenia(Usuario usuario) throws Exception {
		String patron = "[a-z][A-Z][0-9]";
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
}
	
	//Los usuarios básicos deben tener contraseñas que contengan
	//al menos un número y una minúscula y una mayúscula.
	

