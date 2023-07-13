package ar.edu.unlam.test;
import ar.edu.unlam.dominio.SistemaSeguro;
import ar.edu.unlam.dominio.Usuario;
import ar.edu.unlam.dominio.UsuarioDuplicadoException;
import ar.edu.unlam.dominio.UsuarioInexistenteException;
import ar.edu.unlam.dominio.Basico;
import ar.edu.unlam.dominio.InvalidPasswordException;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class TestSistemaSeguro {

	@Test
	public void testQueSePuedaAgregarUsuarioBasico() throws Exception {
	String nombre = "Karen";
	String contrasenia = "123Cuadernillos";
		SistemaSeguro sistema = new SistemaSeguro();
		Usuario usuario = new Basico(nombre, contrasenia);
		sistema.agregarUsuario(usuario);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = sistema.getUsuarios().size();
		
		assertNotNull(sistema.getUsuarios());
		assertEquals(valorEsperado, valorObtenido);
	}
	@Test
	public void testQueSePuedaAgregarUsuarioAdministrador() throws Exception {
		String nombre = "Karen";
		String contrasenia = "123Cuadernillos?";
			SistemaSeguro sistema = new SistemaSeguro();
			Usuario usuario = new Basico(nombre, contrasenia);
			sistema.agregarUsuario(usuario);
		
			Integer valorEsperado = 1;
			Integer valorObtenido = sistema.getUsuarios().size();
			
			assertNotNull(sistema.getUsuarios());
			assertEquals(valorEsperado, valorObtenido);
			
		}
	
	@Test (expected = InvalidPasswordException.class)
	public void testQueNoSePuedaAgregarUsuarioConContraseñaInvalida() throws Exception {
		String nombre = "Karen";
		String contrasenia = "123Cuadernillos?";
			SistemaSeguro sistema = new SistemaSeguro();
			Usuario usuario = new Basico(nombre, contrasenia);
			sistema.agregarUsuario(usuario);
		
			Integer valorEsperado = 1;
			Integer valorObtenido = sistema.getUsuarios().size();
			

		
	}	
	@Test(expected = UsuarioDuplicadoException.class)
	public void testQueNoSePuedaAgregarUsuarioDuplicado() throws Exception {
		String nombre = "Karen";
		String contrasenia = "123Cuadernillos?";
			SistemaSeguro sistema = new SistemaSeguro();
			Usuario usuario = new Basico(nombre, contrasenia);
		
			sistema.agregarUsuario(usuario);
			sistema.agregarUsuario(usuario);
			
			
	}	
	@Test
	public void testQueSePuedaBloquearUsuario() throws Exception {
		String nombre = "Karen";
		String contrasenia = "123Cuadernillos?";
			SistemaSeguro sistema = new SistemaSeguro();
			Usuario usuario = new Basico(nombre, contrasenia);
		
			sistema.agregarUsuario(usuario);
			sistema.loguearUsuario(usuario);
			
			
			
		
	}		
	@Test
	public void testQueSePuedaEliminarrUsuario() throws Exception {
		SistemaSeguro sistema = new SistemaSeguro();
		String nombre = "Karen";
		String contrasenia = "123Cuadernillos";
		Usuario usuario = new Basico(nombre, contrasenia);
		sistema.agregarUsuario(usuario);
		String nombre2 = "melanie";
		String contrasenia2 = "123Cuadernillos";
		Usuario usuario2 = new Basico(nombre2, contrasenia2);
		sistema.agregarUsuario(usuario2);
		sistema.eliminarUsuario(usuario2);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = sistema.getUsuarios().size();
		assertEquals(valorEsperado, valorObtenido);
		
		
		
	}			
	@Test
	public void testQueSePuedaOrdenarUsuariosPorNombre() throws Exception {
		SistemaSeguro sistema = new SistemaSeguro();
		String nombre = "Karen";
		String contrasenia = "123Cuadernillos";
		Usuario usuario = new Basico(nombre, contrasenia);
		
		String nombre2 = "lucia";
		String contrasenia2 = "123Cuadernillos";
		Usuario usuario2 = new Basico(nombre2, contrasenia2);
		String nombre3 = "milos";
		String contrasenia3 = "123Cuadernillos";
		Usuario usuario3 = new Basico(nombre3, contrasenia3);
		
		sistema.agregarUsuario(usuario);
		sistema.agregarUsuario(usuario2);
		sistema.agregarUsuario(usuario3);
		
		TreeSet<Usuario> lista = sistema.obtenerUsuarioOrdenadosPorNombre();
		
		assertEquals(nombre, lista.first().getNombre());
		assertEquals(nombre3, lista.last().getNombre());
			
		
	}	
	@Test
	public void testQueSePuedaLoguearUsuario() throws Exception {
		String nombre = "Karen";
		String contrasenia = "123Cuadernillos?";
		SistemaSeguro sistema = new SistemaSeguro();
		Usuario usuario = new Basico(nombre, contrasenia);
		sistema.agregarUsuario(usuario);
		
		assertTrue(sistema.loguearUsuario(usuario));
		
		
	}
	
	@Test(expected = UsuarioInexistenteException.class)
	public void testQueNoSePuedaLoguearUsuarioInexistente() throws Exception {
		String nombre = "Karen";
		String contrasenia = "123Cuadernillos?";
		SistemaSeguro sistema = new SistemaSeguro();
		Usuario usuario = new Basico(nombre, contrasenia);
		
		String nombre2 = "Karen";
		String contrasenia2 = "123Cuadernillos?";
		
		Usuario usuario2 = new Basico(nombre2, contrasenia2);
		
		sistema.agregarUsuario(usuario);
		sistema.loguearUsuario(usuario2);
		
		
	}	
	@Test
	public void testQueNoSePuedaEliminarUsuarioAdministrador() {
		
	}	
	
	
}
