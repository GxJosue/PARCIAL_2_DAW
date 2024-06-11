/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.negocio;

import com.mycompany.appweb.entidades.Alumno;
import com.mycompany.appweb.entidades.Inscripcion;
import com.mycompany.appweb.entidades.Materia;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author rnavarro
 */
@Stateless
public class DataService {
    
  @PersistenceContext( unitName="pu")
  EntityManager entityManager;
  
 
 /* Manejo de alumnos */
    public List<Alumno> getAlumnos(){
        
        Query query = entityManager.createQuery("Select e FROM Alumno e ORDER BY e.id DESC");
        
        List<Alumno> alumnos = query.getResultList();
                
        return alumnos;
        
    }
   
   @Transactional
   public void saveAlumno(Alumno alumno){
       entityManager.persist(alumno);
   }
   
   @Transactional
   public void editAlumno(Alumno alumno){
       entityManager.merge(alumno);
   }
   
   @Transactional
   public void deleteAlumno(Alumno alumno){
       Alumno alumnoEliminar = entityManager.find(Alumno.class, alumno.getId());
       entityManager.remove(alumnoEliminar);
   }
   
   
 /* Manejo de materias */
   public List<Materia> getMaterias() {
        Query query = entityManager.createQuery("Select m FROM Materia m ORDER BY m.id DESC");
        List<Materia> materias = query.getResultList();
        return materias;
    }

    @Transactional
    public void saveMateria(Materia materia) {
        entityManager.persist(materia);
    }

    @Transactional
    public void editMateria(Materia materia) {
        entityManager.merge(materia);
    }

    @Transactional
    public void deleteMateria(Materia materia) {
        Materia materiaEliminar = entityManager.find(Materia.class, materia.getId());
        entityManager.remove(materiaEliminar);
    }
    
    /* Manejo de inscripciones */
    public List<Inscripcion> getInscripciones() {
        Query query = entityManager.createQuery("SELECT i FROM Inscripcion i ORDER BY i.id DESC");
        List<Inscripcion> inscripciones = query.getResultList();
        return inscripciones;
    }

    public void saveInscripcion(Inscripcion inscripcion) {
        try {
            entityManager.persist(inscripcion);
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace();
        }
    }
    @Transactional
    public void editInscripcion(Inscripcion inscripcion) {
        entityManager.merge(inscripcion);
    }

    @Transactional
    public void deleteInscripcion(Inscripcion inscripcion) {
        Inscripcion inscripcionEliminar = entityManager.find(Inscripcion.class, inscripcion.getId());
        entityManager.remove(inscripcionEliminar);
    }
    
}
