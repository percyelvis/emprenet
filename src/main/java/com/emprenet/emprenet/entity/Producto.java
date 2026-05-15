package com.emprenet.emprenet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private Double precio;

    private String estado;

    private LocalDateTime fechaPublicacion = LocalDateTime.now();

    // 🔥 RELACIONES CORREGIDAS

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"productos", "favoritos", "mensajesEnviados", "mensajesRecibidos"})
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Imagen> imagenes;

    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<Favorito> favoritos;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Producto() {}

    public Producto(Long id, String nombre, String descripcion, Double precio, String estado, LocalDateTime fechaPublicacion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
    }

    // GETTERS Y SETTERS

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getPrecio() { return precio; }

    public void setPrecio(Double precio) { this.precio = precio; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFechaPublicacion() { return fechaPublicacion; }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<Imagen> getImagenes() { return imagenes; }

    public void setImagenes(List<Imagen> imagenes) { this.imagenes = imagenes; }

    public List<Favorito> getFavoritos() { return favoritos; }

    public void setFavoritos(List<Favorito> favoritos) { this.favoritos = favoritos; }

    public Categoria getCategoria() { return categoria; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}