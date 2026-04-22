package coreProyect.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente", nullable = false)
    private Integer id;

    @Column(name = "CIF", length = 50)
    private String cif;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "historico_gasto", precision = 12, scale = 2)
    private BigDecimal historicoGasto;

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

    public BigDecimal getHistoricoGasto() {
        return historicoGasto;
    }

    public void setHistoricoGasto(BigDecimal historicoGasto) {
        this.historicoGasto = historicoGasto;
    }

}