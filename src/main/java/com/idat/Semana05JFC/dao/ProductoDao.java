package com.idat.Semana05JFC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.Semana05JFC.modelo.Producto;

public interface ProductoDao extends JpaRepository<Producto, Long>{
    
}
