package com.softland.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.softland.example.model.Usuario;
import com.softland.example.service.IUsuarioBO;

@Service
public class IUsuarioBOImpl implements IUsuarioBO {

	public Usuario getUsuario(String login) {
		Usuario usuario = new Usuario("marquito", "Marco Hinojosa"); 
		return usuario;
	}

	public List<String> generarSugerencias(String login) {
		List<String> list = new ArrayList<String>();
		list.add("marquito2018");
		list.add("marquito23");
		list.add("marquitoX");
		return list;
	}

	@Override
	public Usuario altaUsuario(Usuario usuario) {
		// aqui guardamos usuario
		return usuario;
	}

}
