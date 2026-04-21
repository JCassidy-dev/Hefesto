package com.josan.pedido;

import jakarta.persistence.*;

@Entity
@Table(name = "PEDIDO")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido", nullable = false)
    private Integer id;

    @Column(name = "numero", length = 50)
    private String numero;

    @Column(name = "id_estadoPedido")
    private Integer idEstadopedido;

    @Column(name = "id_proveedor")
    private Integer idProveedor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getIdEstadopedido() {
        return idEstadopedido;
    }

    public void setIdEstadopedido(Integer idEstadopedido) {
        this.idEstadopedido = idEstadopedido;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

}