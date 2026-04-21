package com.josan.pedido;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTO_PEDIDO")
public class ProductoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProductoPedido", nullable = false)
    private Integer id;

    @Column(name = "estado", length = 50)
    private String estado;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "id_pedido")
    private Integer idPedido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

}