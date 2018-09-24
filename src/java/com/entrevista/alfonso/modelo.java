
package com.entrevista.alfonso;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Alfonso
 */
public class modelo {
    
    private DataSource pool;
    private Formulario form;
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resul = null;
    public modelo(DataSource origen){
        pool = origen;
        
    }
    
    public String Guardar(Formulario formu){
        String operacion = "Datos Guardados Exitosamente ";
        try {
            
            conexion = pool.getConnection();
            String sentenSql = "insert into formulario (Nombre,Apellido,Descripcion,Fecha,Tipo_peticion,adjunto,nombre_archivo) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement sen = conexion.prepareStatement(sentenSql);
            sen.setString(1, formu.getNombre());
            sen.setString(2, formu.getApellido());
            sen.setString(3, formu.getDescripcion());
            sen.setString(4, formu.getFecha());
            sen.setInt(5, formu.getTipo());
            sen.setBytes(6, formu.getArchivo());
            sen.setString(7, formu.getNombre_archivo());
            sen.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacion ;
        
    }
    
    public List<Formulario> obtenerFormulario()throws Exception{
        List<Formulario> formulario = new ArrayList<>();
        
        
        conexion = pool.getConnection();
        String sql = "SELECT * FROM formulario  LEFT JOIN tipo_peticion  ON formulario.Tipo_peticion = tipo_peticion.idTipo_peticion  ORDER by Fecha";
        sentencia = conexion.createStatement();
        resul = sentencia.executeQuery(sql);
        while (resul.next()){
            String nombre = resul.getString("Nombre");
            String apellido = resul.getString("Apellido");
            String tipo = resul.getString("Peticion");
            String fecha = resul.getString("Fecha");
            String descripcion = resul.getString("Descripcion");
            byte [] archivo = resul.getBytes("adjunto");
            String nombArch = resul.getString("nombre_archivo");
            
            //InputStream archivo = resul.get
            Formulario tempFor = new Formulario(nombre, apellido, descripcion, fecha, tipo, archivo, nombArch);
            formulario.add(tempFor);
        }
        
        return formulario;
        
    } 
    
    public List<Formulario> obtenerTipo()throws Exception{
        
        List<Formulario> formulario2 = new ArrayList<>();
        
        conexion = pool.getConnection();
        
        String sql = "SELECT * FROM formulario  LEFT JOIN tipo_peticion  ON formulario.Tipo_peticion = tipo_peticion.idTipo_peticion  ORDER by Peticion";
        
        sentencia = conexion.createStatement();
        
        resul = sentencia.executeQuery(sql);
        
        while (resul.next()){
            String nombre = resul.getString("Nombre");
            String apellido = resul.getString("Apellido");
            String tipo = resul.getString("Peticion");
            String fecha = resul.getString("Fecha");
            String descripcion = resul.getString("Descripcion");
            byte [] archivo = resul.getBytes("adjunto");
            String nombArch = resul.getString("nombre_archivo");
            
            Formulario tempFor2 = new Formulario(nombre, apellido, descripcion, fecha, tipo, archivo,nombArch);
            formulario2.add(tempFor2);     
        }
        
        return formulario2;
    }
    
     public List<Formulario> ObtenerOTipo(String op)throws Exception{
        
        List<Formulario> formulario3 = new ArrayList<>();
        
        String sql;
        
        
        //conexion = pool.getConnection();
        if (op.equalsIgnoreCase("asc")){
        sql = "SELECT * FROM formulario  LEFT JOIN tipo_peticion  ON formulario.Tipo_peticion = tipo_peticion.idTipo_peticion  ORDER by Peticion ASC ";
        }else{
        sql = "SELECT * FROM formulario  LEFT JOIN tipo_peticion  ON formulario.Tipo_peticion = tipo_peticion.idTipo_peticion  ORDER by Peticion DESC ";    
        }
               
        sentencia = conexion.createStatement();
        
        resul = sentencia.executeQuery(sql);
        
        
        while (resul.next()){
            String nombre = resul.getNString("Nombre");
            String apellido = resul.getString("Apellido");
            String tipo = resul.getString("Peticion");
            String fecha = resul.getString("Fecha");
            String descripcion = resul.getString("Descripcion");
            byte [] archivo = resul.getBytes("adjunto");
            String nombArch = resul.getString("nombre_archivo");
            Formulario tempFor3 = new Formulario(nombre, apellido, descripcion, fecha, tipo, archivo,nombArch);
            formulario3.add(tempFor3);
        }
        
        return formulario3;
         
     }
     
     public List<Formulario> ObtenerFechaAD(String op)throws Exception{
         
        String ope = op;
        
        List<Formulario> formulario4 = new ArrayList<>();
        
        String sql ;
        
        if (op.equalsIgnoreCase("asc")){
            
        sql = "SELECT * FROM formulario  LEFT JOIN tipo_peticion  ON formulario.Tipo_peticion = tipo_peticion.idTipo_peticion  ORDER by Fecha ASC ";
        
        }else{
            
        sql = "SELECT * FROM formulario  LEFT JOIN tipo_peticion  ON formulario.Tipo_peticion = tipo_peticion.idTipo_peticion  ORDER by Fecha DESC ";    
       
        }
        
        sentencia = conexion.createStatement();
        
        resul = sentencia.executeQuery(sql);
        
        while (resul.next()){
            String nombre = resul.getNString("Nombre");
            String apellido = resul.getString("Apellido");
            String tipo = resul.getString("Peticion");
            String fecha = resul.getString("Fecha");
            String descripcion = resul.getString("Descripcion");
            byte [] archivo = resul.getBytes("adjunto");
            String nombArch = resul.getString("nombre_archivo");
            
            Formulario tempFor3 = new Formulario(nombre, apellido, descripcion, fecha, tipo, archivo, nombArch);            
            formulario4.add(tempFor3);
        }
        
        return formulario4;
         
         
     }
     
}