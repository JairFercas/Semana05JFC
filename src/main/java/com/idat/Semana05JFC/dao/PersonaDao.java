package com.idat.Semana05JFC.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.Semana05JFC.modelo.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long> {
    
}
