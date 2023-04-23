package com.generation.newspringboot.controller;

import java.util.List;


import com.generation.newspringboot.model.Equipo;
import com.generation.newspringboot.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@CrossOrigin("*")
@RestController
public class EquipoController {

    private EquipoService equipoService;

    public EquipoController(@Autowired EquipoService equipoService){
        this.equipoService=equipoService;
    }

    
    @PostMapping("/equipo/save")
    public void GuardarEquipo(@RequestBody Equipo equipo){
        equipoService.saveEquipo(equipo);
    }

    @PutMapping("/equipo/update")
    public void EditarEquipo(@RequestBody Equipo equipo){
        equipoService.updateEquipo(equipo);
    }

    @DeleteMapping("/equipo/update")
    public void eliminarEquipo(@PathVariable Integer id){
        equipoService.deleteEquipo(id);
    }
       
    @GetMapping("/equipo/findAll")
    public List <Equipo> mostrarEquipo(){
        return equipoService.findAll();
    }

    @GetMapping("/equipo/proyecto/{id}")
    public List<Equipo> nombreProyecto (@PathVariable Integer id){
        return equipoService.proyectoPorEquipo(id);
    }

}