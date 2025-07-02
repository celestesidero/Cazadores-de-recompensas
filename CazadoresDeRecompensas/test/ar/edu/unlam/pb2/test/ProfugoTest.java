package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.Profugo;
import ar.edu.unlam.pb2.ennum.Entrenamiento;

public class ProfugoTest {
	
	private Profugo profugo;
	private String mensajeEsperado;

	@Before
	public void inicializaProfugo() {
		profugo = new Profugo(5, 10, true, Entrenamiento.ARTES_MARCIALES);
	}
	
	
	@Test
	public void fueIntimidadoDisminuyeSuNivelDeInocencia() {
		
	}
	
	@Test
	public void lanzaUnaExceptionSiElNivelDeHabilidadEstaFueraDelRango() {
		try {
			profugo.setNivelHabilidad(0);
		} catch (IllegalArgumentException e) {
			mensajeEsperado = "El nivel de habilidad debe estar entre 1 y 100";
			assertEquals(mensajeEsperado, e.getMessage());
		}
	}
	
	@Test
	public void lanzaUnaExceptionSiElNivelDeHabilidadEsNull() {
		try {
			profugo.setNivelHabilidad(null);
		} catch (NullPointerException e) {
			mensajeEsperado = "El nivel de habilidad no puede ser nulo";
			assertEquals(mensajeEsperado, e.getMessage());
		}
	}
	
	@Test
	public void elNivelDeHabilidadEsAsignado() {
			profugo.setNivelHabilidad(20);
			assertEquals(Integer.valueOf(20), profugo.getNivelHabilidad());
	}
	
	@Test
	public void lanzaUnaExceptionSiElNivelDeInocenciaEstaFueraDelRango() {
		try {
			profugo.setNivelInocencia(-1);
		} catch (IllegalArgumentException e) {
			mensajeEsperado = "El nivel de inocencia debe estar entre 0 y 100";
			assertEquals(mensajeEsperado, e.getMessage());
		}
	}
	
	@Test
	public void lanzaUnaExceptionSiElNivelDeInocenciaEsNull() {
		try {
			profugo.setNivelInocencia(null);
		} catch (NullPointerException e) {
			mensajeEsperado = "El nivel de inocencia no puede ser nulo";
			assertEquals(mensajeEsperado, e.getMessage());
		}
	}
	
	@Test
	public void elNivelDeInocenciaEsAsignadoCuandoEstaDentroDelRango() {
			profugo.setNivelInocencia(10);
			assertEquals(Integer.valueOf(10), profugo.getNivelInocencia());
	}
	
}
