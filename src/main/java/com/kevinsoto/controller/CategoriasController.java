package com.kevinsoto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kevinsoto.model.Categoria;
import com.kevinsoto.service.IntCategoriasService;


@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	
	@Autowired
	private IntCategoriasService categoriasService;
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("id")int idCategoria, Model model) {
		Categoria categoria = categoriasService.buscarPorId(idCategoria);
		System.out.println(categoria);
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") int idCategoria, RedirectAttributes attribute) {
		//System.out.println("IdCategoria = " + idCategoria);
		attribute.addFlashAttribute("msg", "Registro eliminado con exito");
		categoriasService.eliminar(idCategoria);
		return "redirect:/categorias/indexPaginado";
	}
	
	@PostMapping("/guardar")
	public String guardar (Categoria categoria, RedirectAttributes attribute) {
		//categoria.setId(categoriasService.obtenerTodas().size()+1);
		System.out.println(categoria);
		categoriasService.guardar(categoria);
		attribute.addFlashAttribute("msg", "¡Categoria guardada con exito!");
		//redireccionamiento a una nuevapeticion
		return "redirect:/categorias/indexPaginado";
	}
	
	/*@PostMapping("/guardar")
	public String guardar( @RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, Model model) {
		/*System.out.println("Nombre:" + nombre);
		System.out.println("Descripcion:" + descripcion);
		
		//guardar
		Categoria c = new Categoria();
		c.setId(categoriasService.obtenerTodas().size()+1);
		c.setNombre(nombre);
		c.setDescripcion(descripcion);
		categoriasService.guardar(c);
		model.addAttribute("categorias", categoriasService.obtenerTodas());	
		return "categorias/listaCategorias";
	}*/
	
	@GetMapping(value = "/indexPaginado")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Categoria> lista = categoriasService.buscarTodas(page);
	model.addAttribute("categorias", lista);
	return "categorias/listaCategorias";
	}

	
	@GetMapping("/crear")
	public String crear(Categoria categoria) {
		return "categorias/formCategoria";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("categorias", categoriasService.obtenerTodas());
		for(Categoria categoria : categoriasService.obtenerTodas()) {
			System.out.println(categoria);
		}
		
		return "categorias/listaCategorias";
	}
}

