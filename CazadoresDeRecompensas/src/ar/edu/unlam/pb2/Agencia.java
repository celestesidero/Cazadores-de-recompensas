package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Agencia {

	private Map<String, Cazador> cazadores = new HashMap<>();
	private List<Reporte> reportes = new ArrayList<>();
	private final String nombre = "Agencia de seguridad especialistas en cazadores";

	public Boolean agregarCazador(String id, Cazador cazador) {
		return cazadores.put(id, cazador) == null ? true : false;
	}

	public Cazador buscarCazador(String id) {
		return cazadores.get(id);
	}

	public Boolean registrarCaptura(Profugo profugo, Cazador cazador, Zona zona) {
		return this.reportes.add(new Reporte(profugo, cazador, zona));
	}

	public Set<Profugo> obtenerTodosLosProfugosCapturados() {
		Set<Profugo> capturados = new HashSet<Profugo>();
		for (Reporte reporte : this.reportes)
			capturados.add(reporte.getProfugo());
		return capturados;
	}

	public Profugo obtenerProfugoMasHabilCapturado() {
		Profugo masHabil = null;
		for (Reporte reporte : this.reportes) {
			Profugo actual = reporte.getProfugo();
			if (masHabil == null || actual.getNivelHabilidad() > masHabil.getNivelHabilidad())
				masHabil = actual;
		}
		return masHabil;
	}

	public Cazador obtenerCazadorConMasCapturas() {
		Cazador cazadoresTop = null;
		int maxCapturas = 0;
		for (Map.Entry<Cazador, Integer> entry : contadorDeCapturas().entrySet()) {
			if (entry.getValue() > maxCapturas) {
				cazadoresTop = entry.getKey();
				maxCapturas = entry.getValue();
			} else if (entry.getValue() == maxCapturas && cazadoresTop != null) {
				if (entry.getKey().getNombre().compareTo(cazadoresTop.getNombre()) < 0) {
					cazadoresTop = entry.getKey();
				}
			}
		}
		return cazadoresTop;
	}

	private Map<Cazador, Integer> contadorDeCapturas() {
		Map<Cazador, Integer> contadorCapturas = new HashMap<>();

		for (Reporte reporte : reportes) {
			Cazador cazador = reporte.getCazador();
			contadorCapturas.put(cazador, contadorCapturas.getOrDefault(cazador, 0) + 1);
		}
		return contadorCapturas;
	}

}
