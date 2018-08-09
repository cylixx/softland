package com.softland.example.dto;

import java.util.List;

public class InfoLogin {
	private Boolean disponible;
	private List<String> sugerencias;
	
	public InfoLogin(Boolean disponible, List<String> sugerencias) {
		super();
		this.disponible = disponible;
		this.sugerencias = sugerencias;
	}
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	public List<String> getSugerencias() {
		return sugerencias;
	}
	public void setSugerencias(List<String> sugerencias) {
		this.sugerencias = sugerencias;
	}
	
}
