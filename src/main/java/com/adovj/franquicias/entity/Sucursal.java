package com.adovj.franquicias.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre de la franquicia es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    // Relación Muchos a Uno con Franquicia (Llave foránea)
    @ManyToOne
    @JoinColumn(name = "franquicia_id", nullable = false)
    private Franquicia franquicia;

    // Relación Uno a Muchos con Producto
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos = new ArrayList<>();

    public Sucursal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
