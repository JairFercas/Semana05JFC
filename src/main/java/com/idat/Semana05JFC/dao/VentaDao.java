package com.idat.Semana05JFC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.Semana05JFC.modelo.Venta;

public interface VentaDao extends JpaRepository<Venta, Long>{
    
}
