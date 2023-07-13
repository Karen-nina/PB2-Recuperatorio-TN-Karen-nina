package ar.edu.unlam.dominio;

import java.util.Comparator;

public class OrdenPorNombre implements Comparator<Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}

}
