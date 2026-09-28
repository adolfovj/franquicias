package com.adovj.franquicias.repository;

import com.adovj.franquicias.entity.Producto;
import com.adovj.franquicias.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {


}
