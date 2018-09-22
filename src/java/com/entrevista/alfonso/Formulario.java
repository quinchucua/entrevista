
package com.entrevista.alfonso;

import java.util.Date;

/**
 *
 * @author Alfonso
 */
public class Formulario {
    private String nombre;
    private String apellido;
    private String descripcion;
    private Date fecha;
    private int tipo;

    public Formulario(String nombre, String apellido, String descripcion, Date fecha, int tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Formulario{" + "nombre=" + nombre + ", apellido=" + apellido + ", descripcion=" + descripcion + ", fecha=" + fecha + ", tipo=" + tipo + '}';
    }
    
    
}
