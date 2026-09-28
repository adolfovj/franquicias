package com.adovj.franquicias.service;

import com.adovj.franquicias.entity.Producto;
import com.adovj.franquicias.repository.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProducto {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteByIdAndSucursalId(Integer id, Integer SucursalId) {
        productoRepository.deleteByIdAndSucursalId(id, SucursalId);
    }

    @Override
    public Producto update(Producto producto) {
        Producto productoBDD = productoRepository.findById(producto.getId()).get();

        productoBDD.setNombre(producto.getNombre());
        productoBDD.setPrecio(producto.getPrecio());
        productoBDD.setStock(producto.getStock());

        return productoRepository.save(productoBDD);
    }

    @Override
    public List<Producto> maxStock(Integer franquiciaId) {
        return productoRepository.maxStock(franquiciaId);
    }

    @Override
    public Producto updateNombre(Integer id, String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del producto es obligatorio");
        }
        if (nombre.length() < 2 || nombre.length() > 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe tener entre 2 y 100 caracteres");
        }

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Producto no encontrado: " + id));

        producto.setNombre(nombre);
        return productoRepository.save(producto);
    }
}
