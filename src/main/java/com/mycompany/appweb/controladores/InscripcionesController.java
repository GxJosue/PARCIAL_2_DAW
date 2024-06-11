/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.controladores;

import com.mycompany.appweb.entidades.Alumno;
import com.mycompany.appweb.entidades.Inscripcion;
import com.mycompany.appweb.entidades.Materia;
import com.mycompany.appweb.negocio.DataService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rnavarro
 */
@Named
@RequestScoped
public class InscripcionesController {
    
    private List<Inscripcion> inscripcionesList = new ArrayList<>();
    
    private Inscripcion inscripcion = new Inscripcion();
    
    private Alumno selectedAlumno; // Propiedad para almacenar el alumno seleccionado
    
    private Materia selectedMateria; // Propiedad para almacenar la materia seleccionada
    
    private List<Alumno> alumnosList; // Lista de alumnos
    
    private List<Materia> materiasList; // Lista de materias
    
    @EJB 
    DataService servicio;
    
    @PostConstruct
    public void cargarInscripciones(){
        inscripcionesList = servicio.getInscripciones();
        alumnosList = servicio.getAlumnos();
        materiasList = servicio.getMaterias(); // Asignar la lista de materias aquí
    }
    
    public void guardarInscripcion(){
        if(inscripcion.getId() != null){
            servicio.editInscripcion(inscripcion);
        }else{
            servicio.saveInscripcion(inscripcion);
        }
        inscripcion = new Inscripcion();
        cargarInscripciones();   
    }

    public void llenarFormEditarInscripcion(Inscripcion inscripcion) {
        this.inscripcion.setId(inscripcion.getId());
        this.inscripcion.setAlumno(inscripcion.getAlumno());
        this.inscripcion.setMateria(inscripcion.getMateria());
        this.inscripcion.setAnio(inscripcion.getAnio());
        this.inscripcion.setCiclo(inscripcion.getCiclo());
    }
    
    public void eliminarInscripcion(Inscripcion inscripcion){
        servicio.deleteInscripcion(inscripcion);
        cargarInscripciones();
    }
    
    /* Getters and setters */
    public List<Inscripcion> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripcion> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }   
   
    // Getter y setter para selectedAlumno
    public Alumno getSelectedAlumno() {
        return selectedAlumno;
    }

    public void setSelectedAlumno(Alumno selectedAlumno) {
        this.selectedAlumno = selectedAlumno;
    }

    // Getter y setter para selectedMateria
    public Materia getSelectedMateria() {
        return selectedMateria;
    }

    public void setSelectedMateria(Materia selectedMateria) {
        this.selectedMateria = selectedMateria;
    }
    
    // Getter y setter para alumnosList
    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }
    
    // Getter y setter para materiasList
    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }
    
}
