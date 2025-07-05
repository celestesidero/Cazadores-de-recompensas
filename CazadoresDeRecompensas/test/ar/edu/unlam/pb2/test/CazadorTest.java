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
		Profugo profugo = new Profugo("Pepito",30, 40, false);
		cazadorRural.ejecutarIntimidacionTotal(profugo);
		Integer valorEsperado = 28;
		Integer valorObtenido = profugo.getNivelInocencia();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queElCazadorSigilosoLogreIntimidarAlProfugoYPuedaReducirSuHabilidad() {
		Cazador cazadorSigiloso = new CazadorSigiloso("Fernando", 50);
		Profugo profugo = new Profugo("Carlo",30, 40, false);
		cazadorSigiloso.ejecutarIntimidacionTotal(profugo);
		Integer valorEsperado = 35;
		Integer valorObtenido = profugo.getNivelHabilidad();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queElCazadorUrbanoLogreIntimidarAlProfugoYPuedaHacerQueDejeDeSerNervioso() {
		Cazador cazadorUrbano = new CazadorUrbano("Raul", 50);
		Profugo profugo = new Profugo("Brayan",30, 40, true);
		cazadorUrbano.ejecutarIntimidacionTotal(profugo);
		Boolean valorEsperado = false;
		Boolean valorObtenido = profugo.getEsNervioso();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queElCazadorRuralLogreIntimidarAlProfugoYPuedaHacerQueEmpieceASerNervioso() {
		Cazador cazadorRural = new CazadorRural("Raul", 60);
		Profugo profugo = new Profugo("Pedro",30, 40, false);
		cazadorRural.ejecutarIntimidacionTotal(profugo);
		Boolean valorEsperado = true;
		Boolean valorObtenido = profugo.getEsNervioso();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queElCazadorSigilosoPuedaCapturarAUnProfugoCorrectamente() {
		Cazador cazadorSigiloso = new CazadorSigiloso("Casandra", 70);
		Profugo profugo = new Profugo("Juan",40, 40, false);
		Zona zona = new Zona("Ciudad");
		zona.agregarProfugos(profugo);

		boolean capturo = cazadorSigiloso.procesoDeCaptura(zona);

		assertTrue(capturo);
	}

	@Test
	public void queElCazadorSiHay3ProfugosPuedaCazarA2EIntimidarA1() {
		Cazador cazador = new CazadorSigiloso("Sombra", 70);

		Profugo profugo1 = new Profugo("Elias",40, 30, false); // Captura
		Profugo profugo2 = new Profugo("pepito",60, 40, false); // Captura
		Profugo profugo3 = new Profugo("pedro",80, 50, false); // No captura

		Zona zona = new Zona("Ciudad");
		zona.agregarProfugos(profugo1);
		zona.agregarProfugos(profugo2);
		zona.agregarProfugos(profugo3);

		boolean resultado = cazador.procesoDeCaptura(zona);

		assertEquals(1, zona.getProfugos().size()); // Queda 1 prófugo sin capturar
		assertTrue(resultado); // Capturó al menos uno (capturó 2)
	}

	@Test
	public void queSiElCazadorLograCapturarAUnProfugoSeLeAumenteLaExperiencia() {
		Cazador cazadorRural = new CazadorRural("Cesar", 90);
		Profugo profugo = new Profugo("pedro",50, 20, true);
		Zona zona = new Zona("Campo");
		zona.agregarProfugos(profugo);

		boolean capturado = cazadorRural.procesoDeCaptura(zona);

		assertTrue(capturado);
		assertTrue(cazadorRural.getCantidadDeExperiencia() > 90);
	}

	@Test
	public void queElCazadorNoCaptureSiNoCumpleCondicionEspecificaPeroSiLaCondicionGeneral() {
		Cazador cazadorUrbano = new CazadorUrbano("Santiago", 80);
		Profugo profugo = new Profugo("pedro",30, 40, true);
		Zona zona = new Zona("San justo");
		zona.agregarProfugos(profugo);
		boolean capturado = cazadorUrbano.procesoDeCaptura(zona);
		assertFalse(capturado);
	}

	@Test
	public void queElCazadorNoCaptureSiNoCumpleCondicionGeneralPeroSiLaCondicionEspecifica() {
		Cazador cazadorUrbano = new CazadorUrbano("Hernan", 10);
		Profugo profugo = new Profugo("pedro",30, 40, false);
		Zona zona = new Zona("Ramos mejia");
		zona.agregarProfugos(profugo);
		boolean capturado = cazadorUrbano.procesoDeCaptura(zona);
		assertFalse(capturado);
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

	@Test(expected = IllegalArgumentException.class)
	public void queLanceUnaExcepcionSiLaExperienciaQueSeIngresaAlCazadorEsNula() {
		new CazadorSigiloso("Roberto", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void queLanceUnaExcepcionSiLaExperienciaQueSeIngresaAlCazadorEsNegativa() {
		new CazadorSigiloso("Roberto", -1);
	}

}
