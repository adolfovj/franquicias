package com.adovj.franquicias.controller;

import com.adovj.franquicias.entity.Franquicia;
import com.adovj.franquicias.entity.Sucursal;
import com.adovj.franquicias.service.ISucursal;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sucursales")
public class SucursalController {

    private ISucursal sucursalService;

    public SucursalController(ISucursal sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PostMapping("/crear/{franquiciaId}")
    public Sucursal save(@PathVariable Integer franquiciaId,@Valid @RequestBody Sucursal sucursal) {

        Franquicia franquicia = new Franquicia();
        franquicia.setId(franquiciaId);

        sucursal.setFranquicia(franquicia);

        return sucursalService.save(sucursal);
    }

    @PatchMapping("/updateNombre/{id}")
    public Sucursal updateNombre(@PathVariable Integer id, @Valid @RequestBody Sucursal sucursal) {
        return sucursalService.updateNombre(id, sucursal.getNombre());
    }
}
