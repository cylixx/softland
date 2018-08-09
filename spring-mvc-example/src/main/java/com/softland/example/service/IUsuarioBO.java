package com.softland.example.service;

import java.util.List;

import com.softland.example.dto.Usuario;

public interface IUsuarioBO {

	public Usuario getUsuario(String login);
	public List<String> generarSugerencias(String login);
}
