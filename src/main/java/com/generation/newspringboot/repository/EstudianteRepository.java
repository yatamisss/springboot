package com.generation.newspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.generation.newspringboot.model.Estudiante;

//Este va a ser el que nos permite hacer las consultas (el repository).
//Interfaces=clases en java que nos permiten generar bases o instrucciones para despues ocuparlas.
//vas a crear un archivo repositorio en donde te conectes a la base
//vas a trabajr con objetos de tipo estudiante el tiene un ID de tipo Integer
public interface EstudianteRepository extends JpaRepository <Estudiante, Integer> {

    //esta es una query nativa, sin parametros que nos permite obtener los estudiantes que tengan 
    //una "LL" en su nombre
    @Query(value = "SELECT * FROM estudiantes WHERE nombre like ('%ll%')", nativeQuery=true)
    List <Estudiante> findEstudiantesWithLL();

    //esta es tambien otra query nativa con parametros que nos prermite obtener los estudiantes 
    //pertenecientes a un equipo el cual yo voy a especificar cuando llame a esta consulta
    //tambien es una consulta personalizada 
    //esto de abajo es un ejemplo
    //@Query(value = "SELECT * FROM estudiantes WHERE equipo_id = ?1 AND nombre = ?2", nativeQuery=true)// no es necesario los ";"
    //List <Estudiante> findEstudianteByEquipo(Integer equipo, String nombre);
    
    @Query(value = "SELECT * FROM estudiantes WHERE equipo_id = ?1", nativeQuery=true)// no es necesario los ";"
    List <Estudiante> findEstudianteByEquipo(Integer equipo);
    
    //como hacer una funcion de modificacion en querys nativas
    //ojo este ejemplo es de otro proyecto
    /*@Modifying
    @Query(value = "UPDATE PRODUCT p SET p.STOCK = p.stock+10 WHERE p.id = ?1", nativeQuery = true)
    void sumarStock(Long recetaID);*/
}
