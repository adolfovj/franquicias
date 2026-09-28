package com.adovj.franquicias.service;

import com.adovj.franquicias.entity.Sucursal;

public interface ISucursal {
    Sucursal save (Sucursal sucursalId);

    Sucursal updateNombre(Integer id, String nombre);
}
