package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.ennum.Especialidad;

public class CazadorUrbano extends Cazador {
	 public CazadorUrbano(String nombre, Integer experiencia) {
	        super(nombre, experiencia, Especialidad.ENTORNO_CIVIL);
	    }
	 @Override
	  public Boolean cumpleCondicionEspecificaDeCaptura(Profugo profugo) {
		 return !profugo.getEsNervioso();
	  }
	 
	 @Override
	 public void intimidarProfugo(Profugo profugo) {
		 profugo.setEsNervioso(false);
	 }

}
