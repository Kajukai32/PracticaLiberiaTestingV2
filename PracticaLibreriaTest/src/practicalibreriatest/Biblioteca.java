package practicalibreriatest;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import customexceptions.BorrarLibroException;
import customexceptions.RegistroLibroException;
import data.Autor;
import data.Libro;
import data.Persona;

public class Biblioteca {

	private String nombre;
	private Map<Libro, Persona> catalogo;
	private Integer cantLibros = 0;

	public Biblioteca(String nombre) {
		this.nombre = nombre;
		this.catalogo = new TreeMap<Libro, Persona>();
	}

	public String getNombre() {
		return nombre;
	}

	public Map<Libro, Persona> getCatalogo() {
		return catalogo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCatalogo(Map<Libro, Persona> catalogo) {
		this.catalogo = catalogo;
	}

	public Integer getCantLibros() {
		return cantLibros;
	}

	public void registrarLibro(Libro l, Persona a) throws RegistroLibroException {

		if (catalogo.containsKey(l)) {

			throw new RegistroLibroException("Libro ya existente en el catalogo");
		} else {
			catalogo.put(l, a);
			this.cantLibros++;
		}
	}

	public ArrayList<Map.Entry<Libro, Persona>> getCatalogList() {

		ArrayList<Map.Entry<Libro, Persona>> lista = new ArrayList<Map.Entry<Libro, Persona>>();


		for (Map.Entry<Libro, Persona> entrada : catalogo.entrySet()) {
			lista.add(entrada);
		}

		return lista;
	}

	public void borrarLibroByIsbn(String isbnABorrar) throws BorrarLibroException {

		Libro l = null;

		for (Map.Entry<Libro, Persona> entrada : catalogo.entrySet()) {

			if (entrada.getKey().getIsbn().compareToIgnoreCase(isbnABorrar) == 0) {
				l = entrada.getKey();
				break;
			}
		}

		if (l == null) {
			throw new BorrarLibroException("el libro con ese isbn no existe en el catalogo");
		}
		catalogo.remove(l);
	}

}












