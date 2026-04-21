package com.josan.infordat;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TARIFA")
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTarifa", nullable = false)
    private Integer id;

    @Column(name = "nombre_tarifa", length = 100)
    private String nombreTarifa;

    @Column(name = "fecha_vigencia")
    private LocalDate fechaVigencia;

    @Column(name = "total_productos")
    private Integer totalProductos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreTarifa() {
        return nombreTarifa;
    }

    public void setNombreTarifa(String nombreTarifa) {
        this.nombreTarifa = nombreTarifa;
    }

    public LocalDate getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(LocalDate fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public Integer getTotalProductos() {
        return totalProductos;
    }

    public void setTotalProductos(Integer totalProductos) {
        this.totalProductos = totalProductos;
    }

}