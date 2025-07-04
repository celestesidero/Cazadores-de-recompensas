package ar.edu.unlam.pb2;

import java.util.Objects;

public class Profugo implements Entrenamiento{
//	ATRIBUTOS
	private String nombre;
	private Integer nivelInocencia;
	private Integer nivelHabilidad;
	private Boolean esNervioso;

//  CONSTRUCTOR
	public Profugo(String nombre, Integer nivelInocencia, Integer nivelHabilidad, Boolean esNervioso) {
		this.nombre = nombre;
		setNivelDeInocencia(nivelInocencia);
		setNivelDeHabilidad(nivelHabilidad);
		this.esNervioso = esNervioso;
	}
	
//	METODOS PUBLICOS
	public Integer setNivelDeHabilidad(Integer nivelHabilidad) {
		if (nivelHabilidad == null)
			throw new NullPointerException("El nivel de habilidad no puede ser nulo");
		else if (!validarHabilidad(nivelHabilidad))
			throw new IllegalArgumentException("El nivel de habilidad debe estar entre 1 y 100");
		else if (validarHabilidad(nivelHabilidad))
			this.nivelHabilidad = nivelHabilidad;
		return this.nivelHabilidad;
	}
	
	public Integer setNivelDeInocencia(Integer nivelInocencia) {
		if (nivelInocencia == null)
			throw new NullPointerException("El nivel de inocencia no puede ser nulo");
		else if (!validarInocencia(nivelInocencia))
			throw new IllegalArgumentException("El nivel de inocencia debe estar entre 0 y 100");
		else if (validarInocencia(nivelInocencia))
			this.nivelInocencia = nivelInocencia;
		return this.nivelInocencia;
	}
	
//	METODOS SOBRESCRITOS
	@Override
	public void artesMarcialesAvanzadas() {
		setNivelDeHabilidad(Math.min(this.nivelHabilidad * 2, 100));
	}

	@Override
	public void elite() {
		this.esNervioso = false;
	}

	@Override
	public void proteccionLegal() {
		setNivelDeInocencia(this.nivelInocencia < 40 ? 40 : this.nivelInocencia);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(esNervioso, nivelHabilidad, nivelInocencia);
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
				&& Objects.equals(nivelInocencia, other.nivelInocencia);
	}

//	SETTER Y GETTER
	public Integer getNivelHabilidad() {
		return this.nivelHabilidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEsNervioso(Boolean esNervioso) {
		this.esNervioso = esNervioso;
	}

	public Integer getNivelInocencia() {
		return nivelInocencia;
	}

	public Boolean getEsNervioso() {
		return esNervioso;
	}

//  METODOS PRIVADOS
	private boolean validarHabilidad(Integer numero) {
		return numero >= 1 && numero <= 100;
	}

	private Boolean validarInocencia(Integer numero) {
		return (numero >= 0 && numero <= 100);
	}

}
