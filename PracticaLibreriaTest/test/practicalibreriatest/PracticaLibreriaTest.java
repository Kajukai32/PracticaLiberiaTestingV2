package practicalibreriatest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.Arguments;

import customexceptions.BorrarLibroException;
import customexceptions.RegistroLibroException;
import data.Autor;
import data.GLiterario;
import data.Libro;
import data.Persona;

class PracticaLibreriaTest {
	private Autor JLB;

	@BeforeEach
	void setUp() {
		JLB = new Autor("Jose Luis", "Borges", 1234, LocalDate.of(1960, 10, 9), GLiterario.DIDACTICO);

	}

	@Test
	void shouldCreateAutorTest() {
		// GIVEN
		Persona p = new Autor("Jose Luis", "Borges", 1234, LocalDate.of(1960, 10, 9), GLiterario.DIDACTICO);
		// WHEN
		String s = p.getApellido();

		// THEN
		assertEquals("Borges", s);

	}

	@ParameterizedTest
	@MethodSource("shouldCreateLibroTestArgumento")
	void shouldCreateLibroTest(Libro l, Double expected) {
		// GIVEN
		// WHEN
		// THEN
		assertEquals(expected, l.getPrecio(), 2.0);

	}

	private static Stream<Arguments> shouldCreateLibroTestArgumento() {

		return Stream.of(
				Arguments.of(new Libro("Rayuela", "EMECE", LocalDate.of(1996, 10, 05), "RAYUELA", 1500.0), 1500.0),
				Arguments.of(new Libro("It", "Plaza & Janés", LocalDate.of(1996, 10, 05), "IT", 1900.0), 1902.0),
				Arguments.of(new Libro("Diario de un zombi", "Delt books", LocalDate.of(1996, 10, 05), "RAYUELA", 1400.0), 1400.0),
				Arguments.of(new Libro("Rayuela", "EMECE", LocalDate.of(1996, 10, 05), "RAYUELA", 1800.0), 1800.0));
	}

	@Test
	void shouldntAddBookIfReapeatedTest() {

		// GIVEN
		Biblioteca b = new Biblioteca("Paquita");

		Libro l1 = new Libro("Rayuela", "EMECE", LocalDate.of(1996, 10, 05), "RAYUELA", 1500.0);
		Libro l2 = new Libro("IT", "Plaza janés", LocalDate.of(1990, 12, 15), "rayuela", 1700.0);

		Persona p1 = new Autor("Jose Luis", "Borges", 1234, LocalDate.of(1960, 10, 9), GLiterario.DIDACTICO);
		Persona p2 = new Autor("Stephen", "King", 1235, LocalDate.of(1966, 11, 01), GLiterario.NARRATIVO);

		// WHEN

		Executable e = () -> {
			b.registrarLibro(l1, p1);
			b.registrarLibro(l2, p2);
		};

		// THEN
		assertThrows(RegistroLibroException.class, e);
	}


	@Test
	void shoulAddSomeBooksBibbliotecaTest() throws RegistroLibroException {

		// GIVEN
		Biblioteca b = new Biblioteca("Paquita");
		Libro l1 = new Libro("Rayuela", "EMECE", LocalDate.of(1996, 10, 05), "RAYUELA", 1500.0);
		Libro l2 = new Libro("IT", "Plaza janés", LocalDate.of(1990, 12, 15), "IT", 1700.0);
		Persona p1 = new Autor("Jose Luis", "Borges", 1234, LocalDate.of(1960, 10, 9), GLiterario.DIDACTICO);
		Persona p2 = new Autor("Stephen", "King", 1235, LocalDate.of(1966, 11, 01), GLiterario.NARRATIVO);

		// WHEN
		b.registrarLibro(l1, p1);
		b.registrarLibro(l2, p2);
		ArrayList<Map.Entry<Libro, Persona>> actualList = b.getCatalogList();

		// THEN
		assertEquals(2, actualList.size());

	}

	@Test
	void shouldDeleteBookByIsbn() throws RegistroLibroException, BorrarLibroException {
		// GIVEN
		Biblioteca b = new Biblioteca("Paquita");
		Libro l1 = new Libro("Rayuela", "EMECE", LocalDate.of(1996, 10, 05), "RAYUELA", 1500.0);
		Libro l2 = new Libro("IT", "Plaza janés", LocalDate.of(1990, 12, 15), "IT", 1700.0);
		Persona p1 = new Autor("Jose Luis", "Borges", 1234, LocalDate.of(1960, 10, 9), GLiterario.DIDACTICO);
		Persona p2 = new Autor("Stephen", "King", 1235, LocalDate.of(1966, 11, 01), GLiterario.NARRATIVO);

		// WHEN

		b.registrarLibro(l1, p1);
		b.registrarLibro(l2, p2);
		b.borrarLibroByIsbn("IT");

		ArrayList<Map.Entry<Libro, Persona>> actualList = b.getCatalogList();
		// THEN

		assertEquals(1, actualList.size());

	}

	@Test
	void shouldDeleteBookByIsbnAndThrowExceptionIfIsbnIsntinTheList() throws RegistroLibroException {
		// GIVEN
		Biblioteca b = new Biblioteca("Paquita");
		Libro l1 = new Libro("Rayuela", "EMECE", LocalDate.of(1996, 10, 05), "RAYUELA", 1500.0);
		Libro l2 = new Libro("IT", "Plaza janés", LocalDate.of(1990, 12, 15), "IT", 1700.0);
		Persona p1 = new Autor("Jose Luis", "Borges", 1234, LocalDate.of(1960, 10, 9), GLiterario.DIDACTICO);
		Persona p2 = new Autor("Stephen", "King", 1235, LocalDate.of(1966, 11, 01), GLiterario.NARRATIVO);

		// WHEN
		Executable e = () -> {
			b.registrarLibro(l1, p1);
			b.registrarLibro(l2, p2);
			b.borrarLibroByIsbn("ITTTTTTTTTTTT");
		};

		assertThrows(BorrarLibroException.class, e);

	}






}












