package com.emprenet.emprenet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 50)
    private String rol;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    // 🔥 RELACIONES (CORREGIDO)

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Producto> productos;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Favorito> favoritos;

    @JsonIgnore
    @OneToMany(mappedBy = "emisor")
    private List<Mensaje> mensajesEnviados;

    @JsonIgnore
    @OneToMany(mappedBy = "receptor")
    private List<Mensaje> mensajesRecibidos;

    public Usuario() {}

    // GETTERS Y SETTERS

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getRol() { return rol; }

    public void setRol(String rol) { this.rol = rol; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }

    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    public List<Producto> getProductos() { return productos; }

    public void setProductos(List<Producto> productos) { this.productos = productos; }

    public List<Favorito> getFavoritos() { return favoritos; }

    public void setFavoritos(List<Favorito> favoritos) { this.favoritos = favoritos; }

    public List<Mensaje> getMensajesEnviados() { return mensajesEnviados; }

    public void setMensajesEnviados(List<Mensaje> mensajesEnviados) { this.mensajesEnviados = mensajesEnviados; }

    public List<Mensaje> getMensajesRecibidos() { return mensajesRecibidos; }

    public void setMensajesRecibidos(List<Mensaje> mensajesRecibidos) { this.mensajesRecibidos = mensajesRecibidos; }
}