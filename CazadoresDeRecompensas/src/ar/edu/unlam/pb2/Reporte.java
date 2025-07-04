package ar.edu.unlam.pb2;

public class Reporte {

	private Profugo profugo;
	private Cazador cazador;
	private Zona zona;

	public Reporte(Profugo profugo, Cazador cazador, Zona zona) {
		this.profugo = profugo;
		this.cazador = cazador;
		this.zona = zona;
	}

	public Profugo getProfugo() {
		return profugo;
	}

	public Cazador getCazador() {
		return cazador;
	}

}
