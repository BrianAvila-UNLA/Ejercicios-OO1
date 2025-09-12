package test;

import modelo.Genero;
import modelo.Incaa;
import modelo.Pelicula;


public class TestListas {
	public static void main(String argv[]) {
		Incaa cine = new Incaa();
		Genero genero1 = new Genero(1, "Terror");
		Genero genero2 = new Genero(2, "Comedia");
		
		try {
			// + agregarPelicula (String pelicula) : boolean
			cine.agregarPelicula("El Zorro 1", genero1);
			//cine.agregarPelicula("El Zorro 1");
			cine.agregarPelicula("El Zorro 2", genero1);
			cine.agregarPelicula("Megamente", genero2);
			cine.agregarPelicula("Mi Villano Favorito 1", genero2);
			
			// + traerPelicula (int idPelicula) : Pelicula
			System.out.println((cine.traerPelicula(3)).toString());
			
			// + traerPelicula (String partePelicula) : List<Pelicula> //todas las películas que contengan en su título el string partePelicula
			System.out.println((cine.traerPelicula("El Zorro 1")).toString());
			
			// + modificarPelicula (int idPelicula, String pelicula)
			cine.modificarPelicula(3,  "Gordo Boludo 1");
			System.out.println((cine.traerPelicula(3)).toString());
			// cine.modificarPelicula(7,  "Gordo Boludo 1");
			
			// + eliminarPelicula (int idPelicula): boolean
			cine.eliminarPelicula(3);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(cine.traerPelicula(genero1));
	}
}
