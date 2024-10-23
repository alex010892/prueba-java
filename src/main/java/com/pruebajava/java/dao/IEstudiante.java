package com.pruebajava.java.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pruebajava.java.domain.Estudiante;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudiante extends JpaRepository<Estudiante, Long>{
 
    List<Estudiante> findByGrade(String grado);
    List<Estudiante> findByEdadBetween(int edadInicio, int edadFinal);
}
