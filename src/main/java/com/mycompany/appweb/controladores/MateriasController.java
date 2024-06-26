/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.controladores;

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
public class MateriasController {
    
    private List<Materia> materiasList = new ArrayList<>(); // Lista de materias
    
    private Materia materia = new Materia(); // Materia
    
    @EJB 
    DataService servicio;
 
    /* Materias */
    @PostConstruct
    public void cargarMaterias(){
      materiasList = servicio.getMaterias();
    }
    
    public void guardarMateria(){
        if(materia.getId()!=null){
            servicio.editMateria(materia);
        }else{
            servicio.saveMateria(materia);
        }
        materia = new Materia();
        cargarMaterias();   
    }

    public void llenarFormEditarMateria(Materia materia){
        this.materia.setId(materia.getId());
        this.materia.setNombre(materia.getNombre());
        this.materia.setDescripcion(materia.getDescripcion());
        this.materia.setCodigo(materia.getCodigo());
    }
    
    public void eliminarMateria(Materia materia){
        servicio.deleteMateria(materia);
        cargarMaterias();
    }

    public List<Materia> getMateriasList() {
        return materiasList;
    }
    
    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }
    
    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

                 
}
