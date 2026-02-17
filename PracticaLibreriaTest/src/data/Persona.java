package data;

import java.time.LocalDate;

public abstract class Persona implements Comparable<Persona> {

	protected String nombre;
	protected String Apellido;
	protected Integer dni;
	protected LocalDate fdn;

	public Persona(String nombre, String apellido, Integer dni, LocalDate fdn) {
		this.nombre = nombre;
		Apellido = apellido;
		this.dni = dni;
		this.fdn = fdn;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public LocalDate getFdn() {
		return fdn;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public void setFdn(LocalDate fdn) {
		this.fdn = fdn;
	}

	@Override
	public String toString() {
		return " nombre=" + nombre + ", Apellido=" + Apellido + ", dni=" + dni + ", fdn=" + fdn + " ";
	}

	@Override
	public int compareTo(Persona o) {
		if (this.getDni().compareTo(o.getDni()) == 0) {
			return 0;
		}
		Integer comparacion = this.getNombre().compareToIgnoreCase(o.getNombre());
		if (comparacion == 0) {
			comparacion = this.getDni().compareTo(o.getDni());
		}

		return comparacion;
	}


}
