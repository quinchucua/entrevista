
package com.entrevista.alfonso;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author Alfonso
 */
public class Formulario {
    private String nombre;
    private String apellido;
    private String descripcion;
    private String fecha;   
    private String tipos;
    private String nombre_archivo;
    private long telefono;
    private int tipo;
    private byte [] archivo;
    
    

    public Formulario(String nombre, String apellido, String descripcion, String fecha, String tipos, byte [] archivo, String nombArch, long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipos = tipos;
        this.archivo = archivo;
        this.telefono = telefono;
        nombre_archivo = nombArch;
    }
    
    public Formulario(String nombre, String apellido, String descripcion, String fecha, int tipo, byte [] archivo, String nombArch, long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipo = tipo;
        this.archivo = archivo;
        this.telefono = telefono;
        nombre_archivo = nombArch;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }
    
    

    public byte [] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte [] archivo) {
        this.archivo = archivo;
    }

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        this.tipos = tipos;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
