package com.kevinsoto.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kevinsoto.model.Categoria;
import com.kevinsoto.model.Vacante;

@Service
public class VacantesServiceImp implements IntVacantesService {
	
	private List<Vacante> lista;
	
	public VacantesServiceImp() {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		lista = new LinkedList<Vacante>();
		try {
			Vacante v1 = new Vacante();
			v1.setId(1);
			v1.setNombre("Adrian");
			v1.setDescripcion("Para Trabajo de contabilidad y finanzas");
			v1.setSalario(25500.0);
			v1.setFecha(LocalDate.parse("04-06-2021", formato));
			v1.setDestacado(1);
			v1.setEstatus("Creada");
			v1.setImagen("logo19.png");
			v1.setDetalles("<h3><strong>Amplia Experiencia</strong></h3>");
			Categoria c1 = new Categoria();
			c1.setId(2);
			c1.setNombre("Contabilidad");
			c1.setDescripcion("Relacionado con contabilidad");
			v1.setCategoria(c1);
			
			Vacante v2 = new Vacante();
			v2.setId(2);
			v2.setNombre("Jose");
			v2.setDescripcion("Para Trabajo de analisis de sistemas");
			v2.setSalario(4800.0);
			v2.setFecha(LocalDate.parse("02-05-2021", formato));
			v2.setDestacado(1);
			v2.setEstatus("Aprobada");
			v2.setImagen("logo15.png");
			v2.setDetalles("<h3><strong>Oportunidad de desarrollo</strong></h3>");
			Categoria c2 = new Categoria();
			c2.setId(3);
			c2.setNombre("Administracion");
			c2.setDescripcion("relacionado de administrar datos");
			v2.setCategoria(c2);
			
			Vacante v3 = new Vacante();
			v3.setId(3);
			v3.setNombre("Mario");
			v3.setDescripcion("Para Trabajo de Sistemas Infromaticos");
			v3.setSalario(1500.0);
			v3.setFecha(LocalDate.parse("20-08-2021", formato));
			v3.setDestacado(0);
			v3.setEstatus("Eliminada");
			v3.setDetalles("<h3><strong>De preferencia con certificacion</strong></h3>");
			Categoria c3 = new Categoria();
			c3.setId(4);
			c3.setNombre("Ingenieria");
			c3.setDescripcion("Relacionado con areas de ingenieria");
			v3.setCategoria(c3);
			
			Vacante v4 = new Vacante();
			v4.setId(4);
			v4.setNombre("Cristina");
			v4.setDescripcion("Para Trabajo de Administracion de Datos");
			v4.setSalario(11500.0);
			v4.setFecha(LocalDate.parse("04-04-2021", formato));
			v4.setDestacado(1);
			v4.setEstatus("Creada");
			v4.setImagen("logo20.png");
			v4.setDetalles("<h3><strong>Horario Flexible</strong></h3>");
			Categoria c4 = new Categoria();
			c4.setId(3);
			c4.setNombre("Ingenieria");
			c4.setDescripcion("Relacionado con areas de ingenieria");
			v4.setCategoria(c4);
			
			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
			lista.add(v4);
			
		}catch(DateTimeParseException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}
	
	@Override
	public List<Vacante> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public void guardar(Vacante vacante) {
		lista.add(vacante);

	}

	@Override
	public void eliminar(Integer idVacante) {
		lista.remove(buscarPorId(idVacante));

	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		for(Vacante v: lista) {
			if(v.getId() == idVacante) {
				return v;
			}
		}
		return null;
	}

	@Override
	public Integer numeroVacantes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vacante> obtenerDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vacante> todasDestacadas() {
		// TODO Auto-generated method stub
		return null;
	}

}
