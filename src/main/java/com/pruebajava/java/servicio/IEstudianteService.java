package com.pruebajava.java.servicio;

import java.util.List;

import com.pruebajava.java.domain.Estudiante;

public interface IEstudianteService {
    
    public List<Estudiante> listarEstudiantes();

    public Estudiante guardar(Estudiante estudiante);

    public void eliminar(Long id);

    public Estudiante actualizar(Long id, Estudiante studentDetails);

    public Estudiante encontrarEstudiantePorId(Long id);

    public List<Estudiante> obtenerEstudiantesPorGrado(String grado);

    List<Estudiante> obtenerEstudiantesPorRangoEdad(int edadInicio, int edadFinal);
}
