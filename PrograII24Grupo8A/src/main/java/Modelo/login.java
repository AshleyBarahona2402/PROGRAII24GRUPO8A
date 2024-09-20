
package Modelo;

    public class login {
    private int ID;
    private String Correo; 
    private String Contraseña;

    public login() {
    }

    public login(int ID, String Nombre, String Correo, String Contraseña) {
        this.ID = ID;
        this.Correo = Correo;
        this.Contraseña = Contraseña;
    }

    public int getID() {
        return ID;
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

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

}
