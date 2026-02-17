package data;

import java.time.LocalDate;

public class Autor extends Persona {

	private GLiterario gl;

	public Autor(String nombre, String apellido, Integer dni, LocalDate fdn, GLiterario gl) {
		super(nombre, apellido, dni, fdn);
		this.gl = gl;
	}

	public GLiterario getGl() {
		return gl;
	}

	public void setGl(GLiterario gl) {
		this.gl = gl;
	}

	@Override
	public String toString() {
	
		return "\nAutor-> " + super.toString() + ", Genero Literario" + this.getGl();
	}


}
