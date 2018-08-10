package com.softland.example.service;

import java.util.List;

import com.softland.example.model.Usuario;

public interface IUsuarioBO {

	public Usuario getUsuario(String login);
	public List<String> generarSugerencias(String login);
	public Usuario altaUsuario(Usuario usuario);
}
