
package com.entrevista.alfonso;

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
        String operacion = "exitosa";
        try {
            
            conexion = pool.getConnection();
            String sentenSql = "insert into formulario (Nombre,Apellido,Descripcion,Fecha,Tipo_peticion) VALUES (?,?,?,?,?)";
            PreparedStatement sen = conexion.prepareStatement(sentenSql);
            sen.setString(1, formu.getNombre());
            sen.setString(2, formu.getApellido());
            sen.setString(3, formu.getDescripcion());
            sen.setString(4, formu.getFecha());
            sen.setInt(5, formu.getTipo());
            sen.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return operacion ;
        
    }
    
    public List<Formulario> obtenerFormulario()throws Exception{
        List<Formulario> formulario = new ArrayList<>();
        
        
        conexion = pool.getConnection();
        String sql = "select * from Formulario";
        sentencia = conexion.createStatement();
        resul = sentencia.executeQuery(sql);
        while (resul.next()){
            String nombre = resul.getString("Nombre");
            String apellido = resul.getString("Apellido");
            int tipo = resul.getInt("Tipo_peticion");
            String fecha = resul.getString("Fecha");
            String descripcion = resul.getString("Descripcion");
            Formulario tempFor = new Formulario(nombre, apellido, descripcion, fecha, tipo);
            formulario.add(tempFor);
        }
        
        return formulario;
        
    } 
    

}