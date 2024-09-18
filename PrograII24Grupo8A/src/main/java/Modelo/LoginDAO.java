package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public login log(String Correo, String Contraseña) {
        login l = new login();
        String sql = "SELECT * FROM Usuarios WHERE Correo = 'Andy@gmail.com' AND Contraseña = '123'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, Correo);
            ps.setString(2, Contraseña);
            rs = ps.executeQuery();
            if (rs.next()) {
                l.setID(rs.getInt("ID"));
                l.setNombre(rs.getString("Nombre"));
                l.setCorreo(rs.getString("Correo"));
                l.setContraseña(rs.getString("Contraseña"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());

        }
        return l;
    }
}
