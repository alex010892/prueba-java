package com.pruebajava.java.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pruebajava.java.dao.IEstudiante;
import com.pruebajava.java.domain.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

    private IEstudiante estudiante;

    public EstudianteServiceImpl(IEstudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public List<Estudiante> listarEstudiantes() {
        return (List<Estudiante>) estudiante.findAll();
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return this.estudiante.save(estudiante);
    }

    @Override
    public void eliminar(Long id) {
        this.estudiante.deleteById(id);
    }

    @Override
    public Estudiante encontrarEstudiantePorId(Long id) {
        return this.estudiante.findById(id).orElse(null);
    }
    
    @Override
    public Estudiante actualizar(Long id, Estudiante studentDetails) {
        Estudiante student = estudiante.findById(id).orElse(null);
        if (student != null) {
            student.setTipoDocumento(studentDetails.getTipoDocumento());
            student.setNumeroIdentidad(studentDetails.getNumeroIdentidad());
            student.setNombres(studentDetails.getNombres());
            student.setApellidos(studentDetails.getApellidos());
            student.setFechaNacimiento(studentDetails.getFechaNacimiento());
            student.setEdad(studentDetails.getEdad());
            student.setGrade(studentDetails.getGrade());
            student.setEmail(studentDetails.getEmail());
            student.setTelefonoFijo(studentDetails.getTelefonoFijo());
            student.setCelular(studentDetails.getCelular());
            return estudiante.save(student);
        }
        return null;
    }

    @Override
    public List<Estudiante> obtenerEstudiantesPorGrado(String grado) {
        return estudiante.findByGrade(grado);
    }

    @Override
    public List<Estudiante> obtenerEstudiantesPorRangoEdad(int edadInicio, int edadFinal) {
        return estudiante.findByEdadBetween(edadInicio, edadFinal);
    }
}
