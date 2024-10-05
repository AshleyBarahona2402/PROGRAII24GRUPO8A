
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ProductosDao {
   Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
   public boolean RegistrarProductos (Productos pro){
       String sql = "INSERT INTO  productos (codigo, nombre, descripcion, stock, precio, proveedor) VALUES (?,?,?,?,?,?)";
       try{
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
          ps.setString(1, pro.getCodigo());
          ps.setString(2, pro.getNombre());
          ps.setString(3, pro.getDescripcion());
          ps.setInt(4, pro.getStock());
          ps.setDouble(5, pro.getPrecio());
          ps.setString(6, pro.getProveedor());
          
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
   
   public void ConsultarProveedor(JComboBox proveedor){
   String sql = "SELECT nombre FROM proveedores";
   try{
      con = cn.getConnection();
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()){
          proveedor.addItem(rs.getString("nombre"));
      }
          
   }catch (SQLException e){
       System.out.println(e.toString());
   }
   }
   
   public List ListarProductos(){
       List<Productos> ListaPro = new ArrayList();
       String sql = "SELECT * FROM productos ";
       try{
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
         rs = ps.executeQuery();
         while(rs.next()){
          Productos pro = new Productos();
          pro.setId(rs.getInt("id"));
          pro.setCodigo(rs.getString("codigo"));
          pro.setNombre(rs.getString("nombre"));
          pro.setDescripcion(rs.getString("descripcion"));
          pro.setStock(rs.getInt("stock"));
          pro.setPrecio(rs.getDouble("precio"));
          pro.setProveedor(rs.getString("proveedor"));
          ListaPro.add(pro);
         }
       }catch(SQLException e){
           System.out.println(e.toString());
       }
       return ListaPro;
   }
   
   public boolean EliminarProductos(int id){
   String sql = "DELETE FROM productos WHERE id = ?";
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
   
   public boolean ModificarProductos(Productos Pro){
       String sql = "UPDATE productos SET codigo=?, nombre=?, descripcion=?, stock=?, precio=?, proveedor=?  WHERE id=?";
       try{
         ps = con.prepareStatement(sql);
         ps.setString(1, Pro.getCodigo());
         ps.setString(2, Pro.getNombre());
         ps.setString(3, Pro.getDescripcion());
         ps.setInt(4, Pro.getStock());
         ps.setDouble(5, Pro.getPrecio());
         ps.setString(6, Pro.getProveedor());
         ps.setInt(7, Pro.getId());
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
   
   public Productos BuscarPro(String cod){
       Productos producto = new Productos();
       String sql = "SELECT * FROM productos WHERE codigo = ?";
       try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           ps.setString(1, cod);
           rs = ps.executeQuery();
           if(rs.next()){
               producto.setNombre(rs.getString("nombre"));
               producto.setPrecio(rs.getDouble("precio"));
               producto.setStock(rs.getInt("stock"));
           }
       }catch (SQLException e){
           System.out.println(e.toString());
       }
       return producto;
   }
   
   
}
