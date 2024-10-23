package com.pruebajava.java.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebajava.java.domain.Estudiante;
import com.pruebajava.java.servicio.IEstudianteService;


@RestController
@RequestMapping("/estudiantes")
public class Controlador {
    
    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> listar(Model model){
        return estudianteService.listarEstudiantes();
    }

     @GetMapping("/{id}")
    public Estudiante getStudentById(@PathVariable Long id) {
        return estudianteService.encontrarEstudiantePorId(id);
    }

    @PostMapping
    public Estudiante createStudent(@RequestBody Estudiante student) {
        return estudianteService.guardar(student);
    }

    @PutMapping("/{id}")
    public Estudiante updateStudent(@PathVariable Long id, @RequestBody Estudiante studentDetails) {
        return estudianteService.actualizar(id, studentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        estudianteService.eliminar(id);
    }

    @GetMapping("/grade/{grade}")
    public List<Estudiante> getStudentsByGrade(@PathVariable String grado) {
        return estudianteService.obtenerEstudiantesPorGrado(grado);
    }

    @GetMapping("/age-range")
    public List<Estudiante> getStudentsByAgeRange(@RequestParam int startAge, @RequestParam int endAge) {
        return estudianteService.obtenerEstudiantesPorRangoEdad(startAge, endAge);
    }
}
