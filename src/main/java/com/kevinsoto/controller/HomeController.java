package com.kevinsoto.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kevinsoto.model.Perfil;
import com.kevinsoto.model.Usuario;
import com.kevinsoto.model.Vacante;
import com.kevinsoto.service.IntUsuariosService;
import com.kevinsoto.service.IntVacantesService;

@Controller
public class HomeController {
	
	@Autowired
	private IntUsuariosService usuariosService;
	
		@Autowired
		private IntVacantesService vacantesService;
		
		@PostMapping("/guardar")
		public String guardarUsuario(Usuario usuario) {
			String modificar = "{noop}" + usuario.getPassword();
			usuario.setPassword(modificar);
			usuario.setEstatus(1);
			usuario.setFechaRegistro(LocalDate.now());
			// crear perfil o rol
			Perfil perfil = new Perfil ();
			perfil.setId(3); //rol-Usuario
			usuario.agregar(perfil);
			System.out.println(usuario);
			usuariosService.guardar(usuario);
			return "formLogin";
		}
		
		@GetMapping("/crear")
		public String crearUsuario(Usuario usuario) {
			return "formRegistro";
		}
		
		@GetMapping("/acerca")
		public String acerca() {
			return "acerca";
		}
		
		@GetMapping("/")
		public String mostrarHome(Model model) {
		List <Vacante>  vacantes =	vacantesService.obtenerDestacadas();
		model.addAttribute("vacantes", vacantes);
			return "home";
		}

	}
