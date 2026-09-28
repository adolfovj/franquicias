package com.adovj.franquicias.service;

import com.adovj.franquicias.entity.Franquicia;
import com.adovj.franquicias.repository.FranquiciaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FranquiciaServiceImpl implements IFranquicia{

    private FranquiciaRepository franquiciaRepository;

    public FranquiciaServiceImpl(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }

    @Override
    public Franquicia save(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    @Override
    public List<Franquicia> findAll() {
        return franquiciaRepository.findAll();
    }

    @Override
    public Franquicia updateNombre(Integer id, String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de la franquicia es obligatorio");
        }
        nombre = nombre.trim();
        if (nombre.length() < 2 || nombre.length() > 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe tener entre 2 y 100 caracteres");
        }

        Franquicia franquicia = franquiciaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Franquicia no encontrada: " + id));

        franquicia.setNombre(nombre);
        return franquiciaRepository.save(franquicia);
    }
}
