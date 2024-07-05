package com.idat.Semana05JFC.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.idat.Semana05JFC.dao.PersonaDao;
import com.idat.Semana05JFC.modelo.Persona;
import com.idat.Semana05JFC.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
	private PersonaDao dao;

    @Override
    public Persona registrar(Persona t) {
        t.setIdPersona(0L);
		return dao.save(t);
    }

    @Override
    public Persona modificar(Persona t) {
        return dao.save(t);
    }

    @Override
    public boolean eliminar(Long id) {
        Optional<Persona> opt= dao.findById(id);
		if (opt!=null) {
			dao.delete(opt.get());
			return true;
		}
		return false;
    }

    @Override
    public Persona buscar(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Persona> listar() {
        return dao.findAll();
    }

    @Override
    public Page<Persona> listarPagina(Pageable pag) {
        return dao.findAll(pag);
    }
}
