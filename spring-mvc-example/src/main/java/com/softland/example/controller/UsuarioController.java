package com.softland.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softland.example.model.InfoLogin;
import com.softland.example.model.Usuario;
import com.softland.example.service.IUsuarioBO;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioBO usuarioBO;

	@RequestMapping("/usuario/disponible")
	public @ResponseBody InfoLogin loginDiponible(
			@RequestParam("login") String login) {

		InfoLogin infoLogin = null;

		if (usuarioBO.getUsuario(login) == null) { // usuario disponible
			infoLogin = new InfoLogin(true, null);

		} else { // usuario no disponible
			infoLogin = new InfoLogin(false, usuarioBO.generarSugerencias(login));
		}
		return infoLogin;
	}
	
	@RequestMapping(value="/usuario/disponible/{login}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InfoLogin> loginDiponible2(
			@PathVariable("login") String login) {

		InfoLogin infoLogin = null;

		if (usuarioBO.getUsuario(login) == null) { // usuario disponible
			infoLogin = new InfoLogin(true, null);

		} else { // usuario no disponible
			infoLogin = new InfoLogin(false, usuarioBO.generarSugerencias(login));
		}
		return new ResponseEntity<InfoLogin>(infoLogin, HttpStatus.OK);
	}
	
	@RequestMapping(value="/usuario/alta", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes="application/json")
	public ResponseEntity<Usuario> altaUsuario(@RequestBody Usuario usuario) {
		
		if (usuario == null) {
			usuario = new Usuario("marquito", "Marco Hinojosa");
		}
		return new ResponseEntity<Usuario>(usuarioBO.altaUsuario(usuario), HttpStatus.CREATED);
	}

}
