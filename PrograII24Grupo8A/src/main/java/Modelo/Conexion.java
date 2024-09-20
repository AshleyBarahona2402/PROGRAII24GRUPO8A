
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
     public static Connection getConexion(){
        
        String url = "jdbc:sqlserver://Andy-Mata:1433;"
                + "Database=SuperMercado;"
                + "user=sa;"
                + "password=AndyMata2003.;";
        try{
            Connection Con = DriverManager.getConnection(url); 
            return Con;
            
        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
}     
