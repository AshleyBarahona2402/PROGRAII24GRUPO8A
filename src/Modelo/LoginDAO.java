
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
   Connection con;
   PreparedStatement ps;
   ResultSet rs;
   Conexion cn = new Conexion();
   public login log(String correo, String pass){
       login l = new login();
       String sql = "SELECT * FROM usuarios WHERE correo = ? AND pass = ? ";
       try{
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
          ps.setString(1, correo);
          ps.setString(2, pass);
         rs = ps.executeQuery();
         if(rs.next()){
          l.setId(rs.getInt("id"));
          l.setCorreo(rs.getString("correo"));
          l.setPass(rs.getString("pass"));
         }
       }catch(Exception e){
         System.out.println(e.toString());
       }
       return l;
   }
   
}
