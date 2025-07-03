package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.ennum.Especialidad;

public abstract class Cazador {
	private String nombre;
	private Integer cantidadDeExperiencia;
	private Especialidad especialidad;

	public Cazador(String nombre, Integer experiencia, Especialidad especialidad) {
		this.nombre = nombre;
		this.verificarQueElIngresoDeExperienciaNoSeaNegativaNiNula(experiencia);
		this.especialidad = especialidad;
	}

	public Boolean procesoDeCaptura(Profugo profugo) {
		return null;
	}

	public Boolean cumpleCondicionGeneralDeCaptura(Profugo profugo) {
		return this.cantidadDeExperiencia > profugo.getNivelInocencia();
	}

	public void ejecutarIntimidacionTotal(Profugo profugo) {
		profugo.setNivelInocencia(profugo.getNivelInocencia() - 2);
		this.intimidarProfugo(profugo);
	}

	public abstract Boolean cumpleCondicionEspecificaDeCaptura(Profugo profugo);

	public abstract void intimidarProfugo(Profugo profugo);

	private void aumentarExperiencia() {

	}

	private void verificarQueElIngresoDeExperienciaNoSeaNegativaNiNula(Integer experiencia) {
		if (experiencia == null || experiencia <= 0) {
			throw new IllegalArgumentException("El valor que se ingreso no es valido. Debe ser un numero positivo");
		} else {
			this.cantidadDeExperiencia = experiencia;
		}

	}

	public String getEspecialidad() {
		return this.especialidad.getDescripcion();
	}

}
