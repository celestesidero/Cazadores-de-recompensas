package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.ennum.Especialidad;

public class CazadorRural extends Cazador {

	public CazadorRural(String nombre, Integer experiencia) {
		super(nombre, experiencia, Especialidad.ENTORNO_AGRESTRE);
	}

	@Override
	public Boolean cumpleCondicionEspecificaDeCaptura(Profugo profugo) {
		return profugo.getEsNervioso();
	}

	@Override
	public void intimidarProfugo(Profugo profugo) {
		profugo.setEsNervioso(true);
	}

}
