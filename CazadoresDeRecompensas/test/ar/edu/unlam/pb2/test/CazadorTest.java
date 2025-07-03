package ar.edu.unlam.pb2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ar.edu.unlam.pb2.CazadorRural;
import ar.edu.unlam.pb2.CazadorSigiloso;
import ar.edu.unlam.pb2.CazadorUrbano;

public class CazadorTest {

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
