package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.pb2.Agencia;
import ar.edu.unlam.pb2.Cazador;
import ar.edu.unlam.pb2.CazadorUrbano;
import ar.edu.unlam.pb2.Profugo;
import ar.edu.unlam.pb2.Zona;

public class AgenciaTest {
	
	private Agencia agencia;
	private Cazador cazador;
	private Cazador cazador1 = new CazadorUrbano("Marcos", 30);
	private Cazador cazador2 = new CazadorUrbano("Miguel", 20);
	private Profugo profugo;
	private Profugo profugo1 = new Profugo("Brayan", 25, 10, false);
	private Profugo profugo2 = new Profugo("Brayan", 25, 20, false);
	private Zona zona;
	
	@Before
	public void instanciandoAgencia() {
		agencia = new Agencia();
	}
	
	@Before
	public void instanciandoZona() {
		zona = new Zona("Rural");
	}
	
	@Before
	public void instanciandoCazador() {
		cazador = new CazadorUrbano("Luis", 10);
	}
	
	@Before
	public void instanciandoProfugo() {
		profugo = new Profugo("Brayan", 25, 1, false);
	}
	
	@Test
	public void agregarCazadorALaAgencia() {
		assertTrue(agencia.agregarCazador("Luis", cazador));
	}
	
	@Test
	public void registrarUnaCaptura() {
		assertTrue(agencia.registrarCaptura(profugo, cazador, zona));
	}
	
	@Test
	public void obtenerUnaListaDeProfugosCapturados() {
		Set<Profugo> capturados = new HashSet<Profugo>();
		preparacion(capturados);
		assertEquals(capturados, agencia.obtenerTodosLosProfugosCapturados());
	}
	
	@Test
	public void obtenerAlProfugoCapturadoMasHabil() {
		agregaAlregistroCapturas();
		assertEquals(profugo2, agencia.obtenerProfugoMasHabilCapturado());
	}
	
	@Test
	public void obtenerAlCazadorConMasCapturasDeLaAgencia() {
		agregaCazadoresYSusRegistros();
		assertEquals(cazador2, agencia.obtenerCazadorConMasCapturas());
	}
	
	@Test
	public void obtenerAlCazadorConMasCapturasDeLaAgenciaConEmpate() {
		agregaCazadoresYSusRegistrosEmpate();
		assertEquals(cazador, agencia.obtenerCazadorConMasCapturas());
	}
	
	private void agregaCazadoresYSusRegistros() {
		agencia.agregarCazador("Luis", cazador);
		agencia.agregarCazador("Marcos", cazador1);
		agencia.agregarCazador("Miguel", cazador2);
		agencia.registrarCaptura(profugo, cazador, zona);
		agencia.registrarCaptura(profugo1, cazador2, zona);
		agencia.registrarCaptura(profugo2, cazador2, zona);
		agencia.registrarCaptura(profugo2, cazador2, zona);
		agencia.registrarCaptura(profugo2, cazador1, zona);
	}
	
	private void agregaCazadoresYSusRegistrosEmpate() {
		agencia.agregarCazador("Luis", cazador);
		agencia.agregarCazador("Marcos", cazador1);
		agencia.agregarCazador("Miguel", cazador2);
		agencia.registrarCaptura(profugo, cazador, zona);
		agencia.registrarCaptura(profugo1, cazador, zona);
		agencia.registrarCaptura(profugo2, cazador2, zona);
		agencia.registrarCaptura(profugo2, cazador2, zona);
		agencia.registrarCaptura(profugo2, cazador1, zona);
	}
	
	private void agregaAlregistroCapturas() {
		agencia.registrarCaptura(profugo, cazador, zona);
		agencia.registrarCaptura(profugo1, cazador, zona);
		agencia.registrarCaptura(profugo2, cazador, zona);
	}
	
	private void preparacion(Set<Profugo> capturados) {
		agregaAlregistroCapturas();
		capturados.add(profugo);
		capturados.add(profugo1);
		capturados.add(profugo2);
	}
}
