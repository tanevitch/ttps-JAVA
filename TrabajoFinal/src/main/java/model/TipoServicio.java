package model;

import java.util.ArrayList;
import java.util.List;

public class TipoServicio {
	private long id;
	private String nombre;
	
	private List<AspectoPuntuacion> aspectoAValorar= new ArrayList<AspectoPuntuacion>();

	
	public TipoServicio(String nombre, List<AspectoPuntuacion> aspectoAValorar) {
		this.nombre = nombre;
		this.aspectoAValorar = aspectoAValorar;
	}

	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AspectoPuntuacion> getAspectoAValorar() {
		return aspectoAValorar;
	}

	public void setAspectoAValorar(List<AspectoPuntuacion> aspectoAValorar) {
		this.aspectoAValorar = aspectoAValorar;
	}
	
	
	
}
