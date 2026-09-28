package com.adovj.franquicias.service;

import com.adovj.franquicias.entity.Sucursal;
import com.adovj.franquicias.repository.SucursalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SucursalServiceImpl implements ISucursal {

    private final SucursalRepository sucursalRepository;


    public SucursalServiceImpl(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal updateNombre(Integer id, String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de la sucursal es obligatorio");
        }
        nombre = nombre.trim();
        if (nombre.length() < 2 || nombre.length() > 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe tener entre 2 y 100 caracteres");
        }

        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Sucursal no encontrada: " + id));

        sucursal.setNombre(nombre);
        return sucursalRepository.save(sucursal);
    }
}
