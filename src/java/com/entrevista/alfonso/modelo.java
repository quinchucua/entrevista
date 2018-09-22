
package com.entrevista.alfonso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Alfonso
 */
public class modelo {
    
    private DataSource pool;
    public modelo(DataSource origen){
        pool = origen;
        
    }
    public List<Formulario> obtenerFormulario()throws Exception{
        List<Formulario> formulario = new ArrayList<>();
        Connection conexion = null;
        Statement sentencia = null;
        ResultSet resul = null;
        
        conexion = pool.getConnection();
        String sql = "select * from Formulario";
        sentencia = conexion.createStatement();
        resul = sentencia.executeQuery(sql);
        while (resul.next()){
            String nombre = resul.getString("Nombre");
            String apellido = resul.getString("Apellido");
            int tipo = resul.getInt("Tipo_peticion");
            Date fecha = resul.getDate("Fecha");
            String descripcion = resul.getString("Descripcion");
            Formulario tempFor = new Formulario(nombre, apellido, descripcion, fecha, tipo);
            formulario.add(tempFor);
        }
        
        return formulario;
        
    } 
    

}