package com.idat.Semana05JFC.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.idat.Semana05JFC.modelo.Venta;
import com.idat.Semana05JFC.service.VentaService;

@RestController
@RequestMapping("/venta")
public class VentaController {

	@Autowired
	private VentaService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Venta> listar(){
		return service.listar();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Venta buscar(@PathVariable("id") Long id) {
		return service.buscar(id);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Venta> registrar(@RequestBody Venta pN){
		Venta _p=service.registrar(pN);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
												.path("/{id}")
												.buildAndExpand(_p.getIdVenta())
												.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Venta modificar(@RequestBody Venta pM) {
		return service.modificar(pM);
	}
	
	@DeleteMapping("/{id}")
	public boolean eliminar(@PathVariable("id") Long id)
	{
		return service.eliminar(id);
	}
	
	@GetMapping("/listarPagina")
	public Page<Venta> listarPagina(Pageable pag){
		return service.listarPagina(pag);
	}
}
