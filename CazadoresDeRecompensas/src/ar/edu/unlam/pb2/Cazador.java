package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unlam.pb2.ennum.Especialidad;

public abstract class Cazador {
	private String nombre;
	private Integer cantidadDeExperiencia;
	private Set<Profugo> recuentoDeProfugosCapturados = new HashSet<>();
	private Especialidad especialidad;
	private Agencia agencia;

	public Cazador(String nombre, Integer experiencia, Especialidad especialidad) {
		this.nombre = nombre;
		this.verificarQueElIngresoDeExperienciaNoSeaNegativaNiNula(experiencia);
		this.especialidad = especialidad;
	}

	public void registrarseEnUnaAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public String getNombre() {
		return nombre;
	}

	public Boolean procesoDeCaptura(Zona zona) {
		Set<Profugo> profugosEnLaZona = zona.getProfugos();
		Set<Profugo> profugosCapturados = new HashSet<>();
		Set<Profugo> profugosIntimidados = new HashSet<>();
		boolean capturoAlMenosUno = false;

		for (Profugo profu : new HashSet<>(profugosEnLaZona)) {
			if (zona != null && this.cumpleCondicionGeneralDeCaptura(profu)
					&& this.cumpleCondicionEspecificaDeCaptura(profu)) {
				this.capturarProfugo(profu, profugosCapturados, zona);
				capturoAlMenosUno = true;
			} else {
				this.intimidarProfugo(profu);
				profugosIntimidados.add(profu);
			}
		}

		this.aumentarExperiencia(profugosIntimidados, profugosCapturados);

		return capturoAlMenosUno;
	}

	public Boolean cumpleCondicionGeneralDeCaptura(Profugo profugo) {
		return this.cantidadDeExperiencia > profugo.getNivelInocencia();
	}

	public void ejecutarIntimidacionTotal(Profugo profugo) {
		profugo.setNivelDeInocencia(profugo.getNivelInocencia() - 2);
		this.intimidarProfugo(profugo);
	}

	public abstract Boolean cumpleCondicionEspecificaDeCaptura(Profugo profugo);

	public abstract void intimidarProfugo(Profugo profugo);

	public String getEspecialidad() {
		return this.especialidad.getDescripcion();
	}

	public Integer getCantidadDeExperiencia() {
		return cantidadDeExperiencia;
	}

	private void capturarProfugo(Profugo profugo, Set<Profugo> capturados, Zona zona) {
		if (zona.profugoCapturado(profugo)) {
			recuentoDeProfugosCapturados.add(profugo);
			capturados.add(profugo);

			if (this.agencia != null) {
				this.agencia.registrarCaptura(profugo, this, zona);
			}
		}
	}

	private void aumentarExperiencia(Set<Profugo> intimidados, Set<Profugo> capturadosZona) {
		int minHabilidad = Integer.MAX_VALUE;
		if (intimidados.isEmpty()) {
			minHabilidad = 0;
		}

		for (Profugo profugo : intimidados) {
			Integer habilidad = profugo.getNivelHabilidad();
			if (habilidad < minHabilidad) {
				minHabilidad = habilidad;
			}
		}

		this.cantidadDeExperiencia += minHabilidad + (2 * capturadosZona.size());
	}

	private void verificarQueElIngresoDeExperienciaNoSeaNegativaNiNula(Integer experiencia) {
		if (experiencia == null || experiencia <= 0) {
			throw new IllegalArgumentException("El valor que se ingreso no es valido. Debe ser un numero positivo");
		} else {
			this.cantidadDeExperiencia = experiencia;
		}

	}

}
