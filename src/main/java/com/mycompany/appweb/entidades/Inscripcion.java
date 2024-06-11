/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author rnavarro
 */
@Entity
@Table(name="inscripciones")
public class Inscripcion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripciones_id_seq")
    @SequenceGenerator(name = "inscripciones_id_seq", sequenceName = "inscripciones_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_materia")
    private Materia materia;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "ciclo")
    private String ciclo;

    @Column(name = "fecha_inscripcion")
    private Date fechaInscripcion;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    // Constructores
    public Inscripcion() {
    }

    public Inscripcion(Integer id) {
        this.id = id;
    }

    public Inscripcion(Alumno alumno, Materia materia, Integer anio, String ciclo, Date fechaInscripcion) {
        this.alumno = alumno;
        this.materia = materia;
        this.anio = anio;
        this.ciclo = ciclo;
        this.fechaInscripcion = fechaInscripcion;
    }
}

