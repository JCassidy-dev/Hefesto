package com.josan.coreProyect.autentication;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPRESA")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpresa", nullable = false)
    private Integer id;

    @Column(name = "cif", length = 50)
    private String cif;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}