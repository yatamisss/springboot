package com.generation.newspringboot.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.generation.newspringboot.repository.EstudianteRepository;
import com.generation.newspringboot.model.Estudiante;

@Service
@Transactional
public class EstudianteService {

    //se conecta con el archivo repository para poder ocuparlo a nivel
    //de las instrucciones creadas en esta 
    private EstudianteRepository estudianteRepository;

    public void saveEstudiante(Estudiante estudiante){
        //este .save esta haciendo el trabajo de in insert into;
        //pero java ya lo reconoce por defecto, entonces lo hara de manera automatica
        //cuando reconozca este metodo
        this.estudianteRepository.save(estudiante);
    }

    public void updateEstudiante(Estudiante estudiante){
        //a pesar de ser una funcion de actualizacion se ocupa 
        //el mismo metodo de guardarlo
        this.estudianteRepository.save(estudiante);
    }

    public void deleteEstudiante (Integer id){
        estudianteRepository.deleteById(id);
    }
    
    public List<Estudiante> findAll(){
        return estudianteRepository.findAll();
    }

    public List<Estudiante> estudiantesConLL(){
        return estudianteRepository.findEstudiantesWithLL();
    }

    public List<Estudiante> estudiantePorEquipo(Integer equipo){
        return estudianteRepository.findEstudianteByEquipo(equipo);
    }
}
