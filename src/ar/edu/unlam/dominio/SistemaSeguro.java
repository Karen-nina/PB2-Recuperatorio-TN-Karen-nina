package ar.edu.unlam.dominio;

import java.util.Set;
import java.util.TreeSet;
public class SistemaSeguro {

	private Set<Usuario> usuarios;

	public SistemaSeguro() {
		super();
		this.usuarios = new TreeSet<Usuario>();
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void agregarUsuario(Usuario usuario) throws Exception{
		if(usuario instanceof Basico) {
			usuario.validarContrasenia(usuario);
		}else {
			if(usuario instanceof Administrador) {
				usuario.validarContrasenia(usuario);
			}
		}usuarios.add(usuario);
		
	}
	public boolean loguearUsuario(Usuario usuario) throws Exception {
		if (usuario.loguearse(usuario.getNombre(),usuario.getContrasenia())) {
			return true;
		}throw new InvalidPasswordException("contraseña invalida");
	}

	public TreeSet<Usuario> obtenerUsuarioOrdenadosPorNombre() {
		TreeSet<Usuario> lista = new TreeSet<Usuario>(new OrdenPorNombre());
		for (Usuario usuario : lista) {
			lista.add(usuario);
				
			}return lista;
		}

	public void eliminarUsuario(Usuario usuario) {
		if(usuario instanceof Basico) {
			usuarios.remove(usuario);
		}
	}
	
		
	}
	