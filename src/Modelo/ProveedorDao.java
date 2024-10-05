
package Modelo;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;


public class ProveedorDao {
   Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
   public boolean RegistrarProveedor (Proveedor pr){
       String sql = "INSERT INTO  proveedores (nombre, telefono, direccion, descripcion) VALUES (?, ?,?,?)";
       try{
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
          ps.setString(1, pr.getNombre());
          ps.setInt(2, pr.getTelefono());
          ps.setString(3, pr.getDireccion());
          ps.setString(4, pr.getDescripcion());
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
   
   public List ListarProveedor(){
       List<Proveedor> ListaPr = new ArrayList();
       String sql = "SELECT * FROM proveedores ";
       try{
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         while(rs.next()){
          Proveedor pr = new Proveedor();
          pr.setId(rs.getInt("id"));
          pr.setNombre(rs.getString("nombre"));
          pr.setTelefono(rs.getInt("telefono"));
          pr.setDireccion(rs.getString("direccion"));
          pr.setDescripcion(rs.getString("descripcion"));
          ListaPr.add(pr);
         }
       }catch(SQLException e){
           System.out.println(e.toString());
       }
       return ListaPr;
   }
   
   public boolean EliminarProveedor(int id){
   String sql = "DELETE FROM proveedores WHERE id = ?";
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
   
   public boolean ModificarProveedor(Proveedor pr){
       String sql = "UPDATE proveedores SET nombre=?, telefono=?, direccion=?, descripcion=? WHERE id=?";
       try{
         ps = con.prepareStatement(sql);
         ps.setString(1, pr.getNombre());
         ps.setInt(2, pr.getTelefono());
         ps.setString(3, pr.getDireccion());
         ps.setString(4, pr.getDescripcion());
         ps.setInt(5, pr.getId());
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

