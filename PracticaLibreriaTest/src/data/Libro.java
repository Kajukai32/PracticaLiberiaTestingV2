package data;

import java.time.LocalDate;

public class Libro implements Comparable<Libro> {


	private String titulo;
	private String editorial;
	private LocalDate fdp;
	private String isbn;
	private Double precio;

	public Libro(String titulo, String editorial, LocalDate fdp, String isbn, Double precio) {
		this.titulo = titulo;
		this.editorial = editorial;
		this.fdp = fdp;
		this.isbn = isbn;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}


	public String getEditorial() {
		return editorial;
	}

	public LocalDate getFdp() {
		return fdp;
	}

	public String getIsbn() {
		return isbn;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public void setFdp(LocalDate fdp) {
		this.fdp = fdp;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "\nLibro [titulo=" + titulo + ", editorial=" + editorial + ", fdp=" + fdp + ", isbn=" + isbn
				+ ", precio=" + precio + "]";
	}

	@Override
	public int compareTo(Libro o) {

		int comparacion = this.getIsbn().compareToIgnoreCase(o.getIsbn());

		if (comparacion == 0) {
			return 0;
		}
		comparacion = this.getTitulo().compareToIgnoreCase(o.getTitulo());

		return comparacion;

	}




}
