
package Modelo;

    public class login {
    private int ID;
    private String Nombre;
    private String Correo; 
    private String Contraseña;

    public login() {
    }

    public login(int ID, String Nombre, String Correo, String Contraseña) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Contraseña = Contraseña;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
