package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.ennum.Especialidad;

public class CazadorSigiloso extends Cazador {

	public CazadorSigiloso(String nombre, Integer experiencia) {
		super(nombre, experiencia, Especialidad.ENTORNO_DISCRETO);
	}

	@Override
	public Boolean cumpleCondicionEspecificaDeCaptura(Profugo profugo) {
		return profugo.getNivelHabilidad() < 50;
	}

	@Override
	public void intimidarProfugo(Profugo profugo) {
		profugo.setNivelHabilidad(profugo.getNivelHabilidad() - 5);
	}

}
