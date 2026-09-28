package com.adovj.franquicias.controller;

import com.adovj.franquicias.entity.Producto;
import com.adovj.franquicias.entity.Sucursal;
import com.adovj.franquicias.service.IProducto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final IProducto productoService;

    public ProductoController(IProducto productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/crear/{sucursalId}")
    public Producto save(@PathVariable Integer sucursalId, @Valid @RequestBody Producto producto) {

        Sucursal sucursal = new Sucursal();
        sucursal.setId(sucursalId);

        producto.setSucursal(sucursal);

        return productoService.save(producto);
    }

    //@DeleteMapping("/{id}/{sucursalId}") : Producto y luego sucursal
    @DeleteMapping("/eliminar/{id}/{sucursalId}")
    public void deleteByIdAndSucursalId(@PathVariable Integer id, @PathVariable Integer sucursalId) {
        // Llama al servicio que a su vez ejecutará el método en el repositorio
        productoService.deleteByIdAndSucursalId(id, sucursalId);
    }

    @PutMapping("/editar/{id}")
    public Producto update(@PathVariable Integer id, @Valid @RequestBody Producto producto) {
        // 1. Atrapamos el ID de la URL usando @PathVariable
        // 2. Se lo asignamos al producto para que deje de ser NULL
        producto.setId(id);

        return productoService.update(producto);
    }

    // Producto con más stock por cada sucursal de una franquicia
    @GetMapping("/maxStock/{franquiciaId}")
    public List<Producto> maxStock(@PathVariable Integer franquiciaId) {
        return productoService.maxStock(franquiciaId);
    }

    @PatchMapping("/updateNombre/{id}")
    public Producto updateNombre(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoService.updateNombre(id, producto.getNombre());
    }
}
