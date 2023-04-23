package com.generation.newspringboot.service;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.generation.newspringboot.model.Equipo;
import com.generation.newspringboot.repository.EquipoRepository;

@Service
@Transactional
public class EquipoService {
    private EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository){
        this.equipoRepository=equipoRepository;
    }


    public void saveEquipo(Equipo equipo){
        //este .save esta haciendo el trabajo de in insert into;
        //pero java ya lo reconoce por defecto, entonces lo hara de manera automatica
        //cuando reconozca este metodo
        this.equipoRepository.save(equipo);
    }

    public void updateEquipo(Equipo equipo){
        //a pesar de ser una funcion de actualizacion se ocupa 
        //el mismo metodo de guardarlo
        this.equipoRepository.save(equipo);
    }

    public void deleteEquipo(Integer id){
        equipoRepository.deleteById(id);
    }

    public List<Equipo> findAll(){
        return equipoRepository.findAll();
    }

    public List<Equipo> proyectoPorEquipo(Integer id){
        return equipoRepository.findProyectoById(id);
    }
}
