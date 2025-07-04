package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.Profugo;

public class ProfugoTest {
	
	private Profugo profugo;
	private String mensajeEsperado;

	@Before
	public void inicializaProfugo() {
		profugo = new Profugo("Brayan",5, 10, true);
	}
	
	@Test
	public void evolucionaEnArtesMarciales() {
		profugo.artesMarcialesAvanzadas();
		assertEquals(Integer.valueOf(20), profugo.getNivelHabilidad());
	}
	
	@Test
	public void evolucionaEnArtesMarcialesYSuperaLos100() {
		profugo.setNivelDeHabilidad(100);
		profugo.artesMarcialesAvanzadas();
		assertEquals(Integer.valueOf(100), profugo.getNivelHabilidad());
	}
	
	@Test
	public void evolucionaAEntrenamientoDeElite() {
		profugo.elite();
		assertEquals(false, profugo.getEsNervioso());
	}
	
	@Test
	public void evolucionaYObtenieneProteccionLegalCuandoSuNivelDeInocenciaEsMenorQue40() {
		profugo.proteccionLegal();
		assertEquals(Integer.valueOf(40), profugo.getNivelInocencia());
	}
	
	@Test
	public void evolucionaYObtenieneProteccionLegalCuandoSuNivelDeInocenciaEsMayorQue40() {
		profugo.setNivelDeInocencia(60);
		profugo.proteccionLegal();
		assertEquals(Integer.valueOf(60), profugo.getNivelInocencia());
	}
	
	@Test
	public void lanzaUnaExceptionSiElNivelDeHabilidadEstaFueraDelRango() {
		try {
			profugo.setNivelDeHabilidad(0);
		} catch (IllegalArgumentException e) {
			mensajeEsperado = "El nivel de habilidad debe estar entre 1 y 100";
			assertEquals(mensajeEsperado, e.getMessage());
		}
	}
	
	@Test
	public void lanzaUnaExceptionSiElNivelDeHabilidadEsNull() {
		try {
			profugo.setNivelDeHabilidad(null);
		} catch (NullPointerException e) {
			mensajeEsperado = "El nivel de habilidad no puede ser nulo";
			assertEquals(mensajeEsperado, e.getMessage());
		}
	}
	
	@Test
	public void elNivelDeHabilidadEsAsignado() {
			profugo.setNivelDeHabilidad(20);
			assertEquals(Integer.valueOf(20), profugo.getNivelHabilidad());
	}
	
	@Test
	public void lanzaUnaExceptionSiElNivelDeInocenciaEstaFueraDelRango() {
		try {
			profugo.setNivelDeInocencia(-7);
		} catch (IllegalArgumentException e) {
			mensajeEsperado = "El nivel de inocencia debe estar entre 0 y 100";
			assertEquals(mensajeEsperado, e.getMessage());
		}
	}
	
	@Test
	public void lanzaUnaExceptionSiElNivelDeInocenciaEsNull() {
		try {
			profugo.setNivelDeInocencia(null);
		} catch (NullPointerException e) {
			mensajeEsperado = "El nivel de inocencia no puede ser nulo";
			assertEquals(mensajeEsperado, e.getMessage());
		}
	}
	
	@Test
	public void elNivelDeInocenciaEsAsignadoCuandoEstaDentroDelRango() {
			profugo.setNivelDeInocencia(10);
			assertEquals(Integer.valueOf(10), profugo.getNivelInocencia());
	}
	
}
