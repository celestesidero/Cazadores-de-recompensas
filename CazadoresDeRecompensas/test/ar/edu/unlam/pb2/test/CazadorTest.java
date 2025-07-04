package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;
import ar.edu.unlam.pb2.*;
import ar.edu.unlam.pb2.Profugo;
import ar.edu.unlam.pb2.ennum.*;

public class CazadorTest {
	
	@Test
	public void queUnCazadorLogreIntimidarAlProfugoYPuedaHacerBajarSuNivelDeInocenciaEn2Unidades() {
		Cazador cazadorRural = new CazadorRural("Pepe", 70);
		Profugo profugo = new Profugo(30, 40, false, Entrenamiento.ARTES_MARCIALES); 
		cazadorRural.ejecutarIntimidacionTotal(profugo);
		Integer valorEsperado = 28;
		Integer valorObtenido = profugo.getNivelInocencia();
		assertEquals(valorEsperado, valorObtenido); 
	}
	
	@Test
	public void queElCazadorSigilosoLogreIntimidarAlProfugoYPuedaReducirSuHabilidad() {
		Cazador cazadorSigiloso = new CazadorSigiloso("Fernando", 50);
		Profugo profugo = new Profugo(30, 40, false, Entrenamiento.ARTES_MARCIALES); 
		cazadorSigiloso.ejecutarIntimidacionTotal(profugo);
		Integer valorEsperado = 35;
		Integer valorObtenido = profugo.getNivelHabilidad();
		assertEquals(valorEsperado, valorObtenido); 
	}
	
	@Test
	public void queElCazadorUrbanoLogreIntimidarAlProfugoYPuedaHacerQueDejeDeSerNervioso() {
		Cazador cazadorUrbano = new CazadorUrbano("Raul", 50);
		Profugo profugo = new Profugo(30, 40, true, Entrenamiento.ELITE); 
		cazadorUrbano.ejecutarIntimidacionTotal(profugo);
		Boolean valorEsperado = false;
		Boolean valorObtenido = profugo.getEsNervioso();
		assertEquals(valorEsperado, valorObtenido); 
	}
	
	@Test
	public void queElCazadorRuralLogreIntimidarAlProfugoYPuedaHacerQueEmpieceASerNervioso() {
		Cazador cazadorRural = new CazadorRural("Raul", 60);
		Profugo profugo = new Profugo(30, 40, false, Entrenamiento.ELITE); 
		cazadorRural.ejecutarIntimidacionTotal(profugo);
		Boolean valorEsperado = true;
		Boolean valorObtenido = profugo.getEsNervioso();
		assertEquals(valorEsperado, valorObtenido); 
	}

	@Test
	public void queElCazadorUrbanoSeaEspecialistaEnEntornosCiviles() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Esteban", 12);
		String especialidadEsperada = "Entornos civiles";
		assertEquals(especialidadEsperada, cazadorUrbano.getEspecialidad());
	}

	@Test
	public void queElCazadorRuralSeaEspecialistaEnZonasAgrestes() {
		CazadorRural cazadorRural = new CazadorRural("Carlos", 1);
		String especialidadEsperada = "Zonas agrestes";
		assertEquals(especialidadEsperada, cazadorRural.getEspecialidad());
	}

	@Test
	public void queElCazadorSigilosoSeaEspecialistaEnCapturasDiscretas() {
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Roberto", 3);
		String especialidadEsperada = "Capturas discretas";
		assertEquals(especialidadEsperada, cazadorSigiloso.getEspecialidad());
	}

	@Test
	public void queLanceUnaExcepcionSiLaExperienciaQueSeIngresaAlCazadorEsNula() {
		try {
			new CazadorSigiloso("Roberto", null);
		} catch (IllegalArgumentException e) {
			String mensajeEsperado = "El valor que se ingreso no es valido. Debe ser un numero positivo";
			assertEquals(mensajeEsperado, e.getMessage());
		}
	}

	@Test
	public void queLanceUnaExcepcionSiLaExperienciaQueSeIngresaAlCazadorEsNegativa() {
		try {
			new CazadorSigiloso("Alberto", -1);
		} catch (IllegalArgumentException e) {
			String mensajeEsperado = "El valor que se ingreso no es valido. Debe ser un numero positivo";
			assertEquals(mensajeEsperado, e.getMessage());
		}
	}

}
