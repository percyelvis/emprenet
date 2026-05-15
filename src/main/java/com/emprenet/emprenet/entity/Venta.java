package com.emprenet.emprenet.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;

    private Double precioTotal;

    private String estado; // PENDIENTE, PAGADO, ENTREGADO, CANCELADO
    // Producto vendido
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    // Usuario comprador
    @ManyToOne
    @JoinColumn(name = "comprador_id")
    private Usuario comprador;

    // Usuario vendedor
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Usuario vendedor;



    public Venta() {
    }

    public Venta(Long id, LocalDateTime fecha, Double precioTotal, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }
}
