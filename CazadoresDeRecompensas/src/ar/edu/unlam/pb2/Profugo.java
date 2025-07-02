package ar.edu.unlam.pb2;

import java.util.Objects;

import ar.edu.unlam.pb2.ennum.Entrenamiento;

public class Profugo {
//	ATRIBUTOS
	private Integer nivelInocencia;
	private Integer nivelHabilidad;
	private Boolean esNervioso;
	private Entrenamiento tipo;
	
//  CONSTRUCTOR
	public Profugo(Integer nivelInocencia, Integer nivelHabilidad, Boolean esNervioso, Entrenamiento tipo) {
		setNivelInocencia(nivelInocencia);
		setNivelHabilidad(nivelHabilidad);
		this.esNervioso = esNervioso;
		this.tipo = tipo;
	}
	
//	METODOS PUBLICOS
	public void setNivelHabilidad(Integer nivelHabilidad) {
		if(nivelHabilidad == null)
			throw new NullPointerException("El nivel de habilidad no puede ser nulo");
		else if(!validarHabilidad(nivelHabilidad))
			throw new IllegalArgumentException("El nivel de habilidad debe estar entre 1 y 100");
		else if(validarHabilidad(nivelHabilidad))
			this.nivelHabilidad = nivelHabilidad;
	}

	public void setNivelInocencia(Integer nivelInocencia) {
		if(nivelInocencia == null)
			throw new NullPointerException("El nivel de inocencia no puede ser nulo");
		else if(!validarInocencia(nivelInocencia))
			throw new IllegalArgumentException("El nivel de inocencia debe estar entre 0 y 100");
		else if(validarInocencia(nivelInocencia))
			this.nivelInocencia = nivelInocencia;
	}
	
//	METODOS SOBRESCRITOS
	@Override
	public int hashCode() {
		return Objects.hash(esNervioso, nivelHabilidad, nivelInocencia, tipo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profugo other = (Profugo) obj;
		return Objects.equals(esNervioso, other.esNervioso) && Objects.equals(nivelHabilidad, other.nivelHabilidad)
				&& Objects.equals(nivelInocencia, other.nivelInocencia) && tipo == other.tipo;
	}
	
//	SETTER Y GETTER
	public void setEsNervioso(Boolean esNervioso) {
		this.esNervioso = esNervioso;
	}
	
	public Integer getNivelHabilidad() {
		return this.nivelHabilidad;
	}
	
	public Integer getNivelInocencia() {
		return nivelInocencia;
	}
	public Boolean getEsNervioso() {
		return esNervioso;
	}

	//	METODOS PRIVADOS
	private boolean validarHabilidad(Integer numero) {
		return numero >= 1 && numero <= 100;
	}
	
	private Boolean validarInocencia(Integer numero) {
		return (numero >= 0 && numero <= 100);
	}
	
	
	
}
