package Modelo;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteDAO {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public boolean RegistroCliente(Cliente cl) {
        String sql = "INSERT INTO Clientes (Nit, Nombre, Direccion, Telefono) VALUES (?,?,?,?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getNit());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getDireccion());
            ps.setInt(4, cl.getTelefono());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

    }
public ArrayList<Cliente> ListarCliente() {
        ArrayList<Cliente> Listacl = new ArrayList();
        String sql = "SELECT * FROM Clientes";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setID(rs.getInt("ID"));
                cl.setNombre(rs.getString("Nombre"));
                cl.setDireccion(rs.getString("Direccion"));
                cl.setTelefono(rs.getInt("Telefono"));
                cl.setNit(rs.getInt("Nit"));
                Listacl.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return Listacl;
    }

    public boolean EliminarCliente(int ID) {
        String sql = "DELETE FROM Clientes WHERE ID = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
   
}
