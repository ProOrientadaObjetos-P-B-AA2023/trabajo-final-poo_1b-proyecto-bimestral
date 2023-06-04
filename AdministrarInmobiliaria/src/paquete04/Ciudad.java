package paquete04;


import java.io.*;

public class Ciudad implements Serializable {
    //Atributos
    private String nombreCiudad;
    private String nombreProvincia;
    //Constructores
    public Ciudad() {
    }

    public Ciudad(String nombreCiudad, String nombreProvincia) {
        this.nombreCiudad = nombreCiudad;
        this.nombreProvincia = nombreProvincia;
    }
    //Metodos GET y SET
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }
}
