package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;

public class Zona {
//	ATRIBUTOS
	private String nombre;
	private Set<Profugo> profugos;
	
//	CONSTRUCTOR
	public Zona(String nombre) {
		this.nombre = nombre;
		this.profugos = new HashSet<Profugo>();
	}
	
//	METODOS PUBLICOS
	public Boolean agregarProfugos(Profugo profugo) {
		return this.profugos.add(profugo);
	}
	
	public Boolean profugoCapturado(Profugo profugo) {
		Boolean capturado = false;
		for (Profugo profugo1 : profugos) {
			if(this.profugos.contains(profugo1) && profugo1.equals(profugo)) 
				capturado = this.profugos.remove(profugo);
		}
		return capturado;
	}

//	SETTER Y GETTER
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
