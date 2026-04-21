package com.josan.pedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESTADO_PEDIDO")
public class EstadoPedido {
    @Id
    @Column(name = "idEstadoPedido", nullable = false)
    private Integer id;

    @Column(name = "tipoEstadoPedido", length = 50)
    private String tipoEstadoPedido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoEstadoPedido() {
        return tipoEstadoPedido;
    }

    public void setTipoEstadoPedido(String tipoEstadoPedido) {
        this.tipoEstadoPedido = tipoEstadoPedido;
    }

}