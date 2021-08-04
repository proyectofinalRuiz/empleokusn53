package com.kevinsoto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kevinsoto.model.Vacante;
import com.kevinsoto.repository.VacantesRepository;

@Service
@Primary
public class VacantesServiceJpa implements IntVacantesService {
	
	@Autowired
	public VacantesRepository repoVacantes;

	@Override
	public List<Vacante> obtenerTodas() {
		// TODO Auto-generated method stub
		return repoVacantes.findAll();
	}

	@Override
	public void guardar(Vacante vacante) {
		// TODO Auto-generated method stub
		repoVacantes.save(vacante);
	}

	@Override
	public void eliminar(Integer idVacante) {
		// TODO Auto-generated method stub
		repoVacantes.deleteById(idVacante);
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		// TODO Auto-generated method stub
		Optional<Vacante> optional = 
				repoVacantes.findById(idVacante);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@Override
	public Integer numeroVacantes() {
		return repoVacantes.findAll().size();
	}

	@Override
	public Page<Vacante> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub 
		return repoVacantes.findAll(page) ;
	}

	@Override
	public List<Vacante> obtenerDestacadas() {
		return repoVacantes.findByDestacadoAndEstatusOrderByIdDesc(1, "Aprobada");
	}

	@Override
	public List<Vacante> todasDestacadas() {
		// TODO Auto-generated method stub
		return repoVacantes.obtenerTodasDestacadas();
	}
	
	

}
