package com.adovj.franquicias.service;

import com.adovj.franquicias.entity.Franquicia;
import com.adovj.franquicias.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProducto  {

    Producto save (Producto producto);

    void deleteByIdAndSucursalId(Integer id, Integer Sucursal_Id);

    Producto update (Producto producto);

    List<Producto> maxStock(Integer franquiciaId);

    Producto updateNombre(Integer id, String nombre);;
}
