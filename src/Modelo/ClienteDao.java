/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ClienteDao {
   Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
   public boolean RegistrarCliente (Cliente cl){
       String sql = "INSERT INTO  clientes (nombre, telefono, direccion, Nit) VALUES (?, ?,?,?)";
       try{
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
          ps.setString(1, cl.getNombre());
          ps.setInt(2, cl.getTelefono());
          ps.setString(3, cl.getDireccion());
          ps.setString(4, cl.getNit());
          ps.execute();
         return true;
       }catch(SQLException e){
         JOptionPane.showMessageDialog(null, e.toString());
         return false;
       }finally{
           try{
              con.close();
           }catch (SQLException e){
              System.out.println(e.toString());
           }
       }
       
   } 
   
   public List ListarCliente(){
       List<Cliente> ListaCl = new ArrayList();
       String sql = "SELECT * FROM clientes ";
       try{
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         while(rs.next()){
          Cliente cl = new Cliente();
          cl.setId(rs.getInt("id"));
          cl.setNombre(rs.getString("nombre"));
          cl.setTelefono(rs.getInt("telefono"));
          cl.setDireccion(rs.getString("direccion"));
          cl.setNit(rs.getString("Nit"));
          ListaCl.add(cl);
         }
       }catch(SQLException e){
           System.out.println(e.toString());
       }
       return ListaCl;
   }
   
   public boolean EliminarCliente(int id){
   String sql = "DELETE FROM clientes WHERE id = ?";
   try{
    ps = con.prepareStatement(sql);
    ps.setInt(1, id);
    ps.execute();
    return true;
    
}catch(SQLException e){
    System.out.println(e.toString());
    return false; 
}finally{
       try{
         con.close();
       }catch(SQLException ex){
        System.out.println(ex.toString());   
       }
   }
   }          
   
   public boolean ModificarCliente(Cliente cl){
       String sql = "UPDATE clientes SET nombre=?, telefono=?, direccion=?, Nit=? WHERE id=?";
       try{
         ps = con.prepareStatement(sql);
         ps.setString(1, cl.getNombre());
         ps.setInt(2, cl.getTelefono());
         ps.setString(3, cl.getDireccion());
         ps.setString(4, cl.getNit());
         ps.setInt(5, cl.getId());
         ps.execute();
         return true;
       }catch(SQLException e){
          System.out.println(e.toString());
          return false;
       }finally{
           try{
               con.close();
           }catch(SQLException e){
               System.out.println(e.toString());
           }
       }
   } 
}

