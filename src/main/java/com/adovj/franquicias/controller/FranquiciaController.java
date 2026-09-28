package com.adovj.franquicias.controller;

import com.adovj.franquicias.entity.Franquicia;
import com.adovj.franquicias.entity.Producto;
import com.adovj.franquicias.service.IFranquicia;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/franquicia")
public class FranquiciaController {

    private IFranquicia franquiciaService;

    public FranquiciaController(IFranquicia franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    @PostMapping("/crear")
    public Franquicia save(@Valid @RequestBody Franquicia franquicia){
        return franquiciaService.save( franquicia );
    }

    @GetMapping("/obtener")
    public List<Franquicia> findAll() {
        return franquiciaService.findAll();
    }

    @PatchMapping("/updateNombre/{id}")
    public Franquicia updateNombre(@PathVariable Integer id, @Valid @RequestBody Franquicia franquicia) {
        return franquiciaService.updateNombre(id, franquicia.getNombre());
    }

}
