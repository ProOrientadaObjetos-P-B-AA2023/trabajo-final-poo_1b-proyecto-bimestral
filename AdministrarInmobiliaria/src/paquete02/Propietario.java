package paquete02;

import java.io.*;

public class Propietario implements Serializable {
    //Atributos
    private String nombresPropietario;
    private String apellidosPropietario;
    private String identificacionPropietario;
    //Constructores
    public Propietario() {
    }

    public Propietario(String nombresPropietario, String apellidosPropietario, String identificacionPropietario) {
        this.nombresPropietario = nombresPropietario;
        this.apellidosPropietario = apellidosPropietario;
        this.identificacionPropietario = identificacionPropietario;
    }
    //Metodos SET y GET
    public void setNombresPropietario(String nombresPropietario) {
        this.nombresPropietario = nombresPropietario;
    }

    public void setApellidosPropietario(String apellidosPropietario) {
        this.apellidosPropietario = apellidosPropietario;
    }

    public void setIdentificacionPropietario(String identificacionPropietario) {
        this.identificacionPropietario = identificacionPropietario;
    }

    public String getNombresPropietario() {
        return nombresPropietario;
    }

    public String getApellidosPropietario() {
        return apellidosPropietario;
    }

    public String getIdentificacionPropietario() {
        return identificacionPropietario;
    }
}
