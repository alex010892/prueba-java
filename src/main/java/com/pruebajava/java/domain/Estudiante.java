package com.pruebajava.java.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "estudiante")
public class Estudiante {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    private String tipoDocumento;

    private String numeroIdentidad;

    @NotEmpty
    private String nombres;

    @NotEmpty
    private String apellidos;

    private Date fechaNacimiento;

    private int edad;

    private String grade;
    
    private String email;

    private String telefonoFijo;

    private String celular;


}
