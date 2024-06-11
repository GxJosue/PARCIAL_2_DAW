/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appweb.resources;

import com.mycompany.appweb.entidades.Alumno;
import com.mycompany.appweb.entidades.Inscripcion;
import com.mycompany.appweb.entidades.Materia;
import com.mycompany.appweb.negocio.DataService;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author rnavarro
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Recurso {
    
    @EJB DataService servicio;
    @Path("/alumnos")
    @GET
    public Response getAlumnos(){
        List<Alumno> alumnos = servicio.getAlumnos();
        return Response.ok(alumnos).build();
    }
  
    @Path("/alumnos")
    @POST
    public Response saveAlumno(Alumno alumno){
        servicio.saveAlumno(alumno);
        return Response.ok("Alumno creado exitosamente").build();
    }
    @Path("/alumnos")
    @PUT
    public Response edtiAlumno(Alumno alumno){
        servicio.editAlumno(alumno);
        return Response.ok("Alumno editado exitosamente").build();
    }
    
    @DELETE
    @Path("/alumnos/{id}")
    public Response deleteAlumno(@PathParam("id") Integer id){
        servicio.deleteAlumno(new Alumno(id));
        return Response.ok("Alumno eliminado exitosamente").build();
    }
    
    @Path("/materias") // Subruta para el recurso de materias
    @GET
    public Response getMaterias(){
        List<Materia> materias = servicio.getMaterias();
        return Response.ok(materias).build();
    }
  
    @Path("/materias") // Subruta para el recurso de materias
    @POST
    public Response saveMateria(Materia materia){
        servicio.saveMateria(materia);
        return Response.ok("Materia creada exitosamente").build();
    }
    
    @Path("/materias") // Subruta para el recurso de materias
    @PUT
    public Response editMateria(Materia materia){
        servicio.editMateria(materia);
        return Response.ok("Materia editada exitosamente").build();
    }
    
    @Path("/materias/{id}") // Subruta para el recurso de materias con un parámetro de ruta para el ID
    @DELETE
    public Response deleteMateria(@PathParam("id") Integer id){
        servicio.deleteMateria(new Materia(id));
        return Response.ok("Materia eliminada exitosamente").build();
    }
    
    
    /* apartado para inscripciones */
    @Path("/inscripciones")
    @GET
    public Response getInscripciones(){
        List<Inscripcion> inscripciones = servicio.getInscripciones();
        return Response.ok(inscripciones).build();
    }
  
    @Path("/inscripciones")
    @POST
    public Response saveInscripcion(Inscripcion inscripcion){
        servicio.saveInscripcion(inscripcion);
        return Response.ok("Inscripción creada exitosamente").build();
    }
    
    @Path("/inscripciones")
    @PUT
    public Response editInscripcion(Inscripcion inscripcion){
        servicio.editInscripcion(inscripcion);
        return Response.ok("Inscripción editada exitosamente").build();
    }
    
    @DELETE
    @Path("/inscripciones/{id}")
    public Response deleteInscripcion(@PathParam("id") Integer id){
        servicio.deleteInscripcion(new Inscripcion(id));
        return Response.ok("Inscripción eliminada exitosamente").build();
    }
}
