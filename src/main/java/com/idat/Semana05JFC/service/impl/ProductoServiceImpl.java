package com.idat.Semana05JFC.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.idat.Semana05JFC.dao.ProductoDao;
import com.idat.Semana05JFC.modelo.Producto;
import com.idat.Semana05JFC.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
	private ProductoDao dao;
	

    @Override
    public Producto registrar(Producto t) {
        t.setIdProducto(0L);
		return dao.save(t);
    }

    @Override
    public Producto modificar(Producto t) {
        return dao.save(t);

    }

    @Override
    public boolean eliminar(Long id) {
        Optional<Producto> opt=dao.findById(id);
		if (opt!=null) {
			dao.delete(opt.get());
			return true;
		}
		return false;
    }

    @Override
    public Producto buscar(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Producto> listar() {
        return dao.findAll();
    }

    @Override
    public Page<Producto> listarPagina(Pageable pag) {
        return dao.findAll(pag);
    }

    
    
}
