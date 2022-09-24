/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JP
 */
public class TiendaController {
      Tienda[] tablaproducto;
    int indiceArray;
    private ConexionBaseDeDatos conectorBD;
    private Connection conexion;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    
    public TiendaController(){
        this.tablaproducto = new Tienda[100];
        this.indiceArray=0;
    }
    
     public void guardarProducto(Tienda alumno){
        this.tablaproducto[this.indiceArray]=alumno;  
        this.indiceArray=this.indiceArray+1;
        // procedimiento para almacenar en la Base de Datos
    }
    
    public Tienda[] getProducto(){
        return this.tablaproducto;
    }
    
    public void abrirConexion(){
        conectorBD= new ConexionBaseDeDatos();
        conexion=conectorBD.conectar();
    }    
   
    
    public String guardarProducto2(Tienda alumno){        
        String sql = "INSERT INTO universidad.alumno(numero, marca, modelo, dimension,año, genero_idgenero) ";
             sql += " VALUES(?,?,?,?,?)";              
       try{     
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            statement.setInt(1, alumno.getCodigo());
            statement.setString(2, alumno.getMarca());
            statement.setString(3, alumno.getModelo());
            statement.setString(4, alumno.getDimension());
            statement.setString(4, alumno.getAño());
            statement.setInt(5, alumno.getTipo());
                int resultado = statement.executeUpdate(); 
                if(resultado > 0){
                    return String.valueOf(resultado);
                }else{
                    return String.valueOf(resultado);
                }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    public void getProducto2(StringBuffer respuesta){   
        String sql="select * from universidad.alumno";
        try{
        abrirConexion();
        respuesta.setLength(0); //Le agregue esto
        statement= conexion.prepareStatement(sql);                        
        result = statement.executeQuery();            
            if (result!=null){
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("numero")).append("</td>");
                respuesta.append("<td >").append(result.getString("marca")).append("</td>");
                respuesta.append("<td >").append(result.getString("modelo")).append("</td>");
                respuesta.append("<td >").append(result.getString("dimension")).append("</td>");
                respuesta.append("<td >").append(result.getString("año")).append("</td>");
                respuesta.append("<td id=\"").append(result.getString("numero"))
                        .append("\"  onclick=\"eliminarAlumno(this.id);\">") 
                         //.append("\"  onclick=\"eliminarAlumno("+result.getString("numero_carne")+");\">") 
                        .append(" <a class=\"btn btn-warning\"'><i class=\"fas fa-edit\"></i>  </a>"
                                +" <a class=\"btn btn-danger\"'> <i class=\"fas fa-trash-alt\"></i> </a>"
                                + " <td></tr>");
                }
            }else{
                respuesta.append("error al consultar");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public String eliminarProducto(int carne){        
        String sql = "DELETE FROM alumno WHERE numero="+carne;              
       try{     
            abrirConexion();
            statement = conexion.prepareStatement(sql); 
            int resultado = statement.executeUpdate();
            if(resultado > 0){
                return String.valueOf(resultado);
            }else{
                return String.valueOf(resultado);
            }
        }catch(SQLException e){ 
            return e.getMessage();
        }
    }
    
    
}
