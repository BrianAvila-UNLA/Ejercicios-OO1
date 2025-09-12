package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Incaa {
	private List<Pelicula> catalogo;
	
	public List<Pelicula> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Pelicula> catalogo) {
		this.catalogo = catalogo;
	}

	public Incaa() {
		super();
		this.catalogo = new ArrayList<Pelicula>();
	}

	public Pelicula traerPelicula(String nombre) {
		Pelicula retornoPelicula = null;
		
		int i = 0;
		
		while (i < catalogo.size() && retornoPelicula == null) {
			if (catalogo.get(i).equals(nombre)) {
				retornoPelicula = catalogo.get(i);
			}
			i++;
		}
		return retornoPelicula;
	}
	
	public Pelicula traerPelicula(int idPelicula) {
		Pelicula retornoPelicula = null;
		
		int i = 0;
		
		while (i < catalogo.size() && retornoPelicula == null) {
			if (catalogo.get(i).getIdPelicula() == idPelicula) {
				retornoPelicula = catalogo.get(i);
			}
			i++;
		}
		return retornoPelicula;
	}
	
	public boolean agregarPelicula(String pelicula, Genero genero) throws Exception {
		if (traerPelicula(pelicula) != null) {
			throw new Exception("ERROR AL INGRESAR PELICULA: PELICULA YA EXISTENTE EN EL CATALOGO");
		}
		int id = 1;
		if (catalogo.size() > 0) {
			id = catalogo.get(catalogo.size() - 1).getIdPelicula() + 1;
		}
		return catalogo.add(new Pelicula(id, pelicula, genero));
	}
	
	public void modificarPelicula(int idPelicula, String pelicula) throws Exception{
		if (traerPelicula(idPelicula) == null) {
			throw new Exception("ERROR AL MODIFICAR PELICULA: LA PELICULA CON LA ID INDICADA NO EXISTE");
		}
		traerPelicula(idPelicula).setPelicula(pelicula);
	}
	
	public boolean eliminarPelicula(int idPelicula) throws Exception{
		if (traerPelicula(idPelicula) == null) {
			throw new Exception("ERROR AL MODIFICAR PELICULA: LA PELICULA CON LA ID INDICADA NO EXISTE");
		}
		System.out.println("PELICULA ELIMINADA CON EXITO.");
		return catalogo.remove(traerPelicula(idPelicula));
	}
	
	public List<Pelicula> traerPelicula(Genero genero) {
		List<Pelicula> peliculasFiltradas = new ArrayList<>();
		
		for (Pelicula p : catalogo) {
			if (p.getGenero().equals(genero)) {
				peliculasFiltradas.add(p);
				p.toString();
			}
		}
		
		return peliculasFiltradas;
	}
}
