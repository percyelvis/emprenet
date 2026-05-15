package com.emprenet.emprenet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "imagenes")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreArchivo;

    private String tipo;

    private String ruta;

    @Lob
    private byte[] datos;

    // RELACIÓN
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public Imagen() {
    }

    public Imagen(Long id, String nombreArchivo, String tipo, String ruta, byte[] datos) {
        this.id = id;
        this.nombreArchivo = nombreArchivo;
        this.tipo = tipo;
        this.ruta = ruta;
        this.datos = datos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public byte[] getDatos() {
        return datos;
    }

    public void setDatos(byte[] datos) {
        this.datos = datos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}