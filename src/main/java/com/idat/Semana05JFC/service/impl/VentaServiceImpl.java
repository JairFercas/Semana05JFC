package com.idat.Semana05JFC.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.idat.Semana05JFC.dao.ProductoDao;
import com.idat.Semana05JFC.dao.VentaDao;
import com.idat.Semana05JFC.modelo.DetalleVenta;
import com.idat.Semana05JFC.modelo.Venta;
import com.idat.Semana05JFC.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService{

	@Autowired
	private VentaDao dao;
	
	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public Venta registrar(Venta t) {
		t.setIdVenta(0L);
		double importe=0;
		for (DetalleVenta det:t.getDetalleVenta()) {
			det.setVenta(t);
			det.setProducto(productoDao.findById(det.getProducto().getIdProducto()).get());
			det.setSubtotal(det.getCantidad()*det.getProducto().getPrecio());
			importe+=det.getSubtotal();
			
		}
		t.setImporte(importe);
		t=dao.save(t);		
		return t;
	}

	@Override
	public Venta modificar(Venta t) {
		return dao.save(t);
	}

	@Override
	public boolean eliminar(Long id) {
		Optional<Venta> opt=dao.findById(id);
		if (opt!= null) {
			dao.delete(opt.get());
			return true;
		}
		return false;
	}

	@Override
	public Venta buscar(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Venta> listar() {
		return dao.findAll();
	}

	@Override
	public Page<Venta> listarPagina(Pageable pag) {
		return dao.findAll(pag);
	}

}
