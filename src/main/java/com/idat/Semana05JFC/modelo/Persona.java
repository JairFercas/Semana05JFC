package com.idat.Semana05JFC.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;
    @Column(name = "dni", nullable = false, length = 8)
    private String dni;
    
    public Long getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public Persona(Long idPersona, String nombres, String apellidos, String dni) {
        this.idPersona = idPersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
    }
    public Persona() {
    }

    
}
