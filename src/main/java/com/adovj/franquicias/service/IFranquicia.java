package com.adovj.franquicias.service;

import com.adovj.franquicias.entity.Franquicia;
import com.adovj.franquicias.entity.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IFranquicia  {

    Franquicia save (Franquicia franquicia);
    List<Franquicia> findAll();
    Franquicia updateNombre(Integer id, String nombre);
}
