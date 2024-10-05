package Modelo;

public class Cliente {

    private int ID;
    private int Nit;
    private String Nombre;
    private String Direccion;
    private int Telefono;
    private int Fecha;

    public Cliente() {
    }

    public Cliente(int ID, int Nit, String Nombre, String Direccion, int Telefono, int Fecha) {
        this.ID = ID;
        this.Nit = Nit;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Fecha = Fecha;
    }

    public int getID() {
        return ID;
    }

    public int getNit() {
        return Nit;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public int getFecha() {
        return Fecha;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNit(int Nit) {
        this.Nit = Nit;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public void setFecha(int Fecha) {
        this.Fecha = Fecha;
    }
    
}
