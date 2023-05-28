package paquete02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;

public class Propietario {
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
    //Metodos
    public void guardarObjeto() throws FileNotFoundException, IOException, ClassNotFoundException {
        //Creacion del archivo
        Formatter flujoSalida = new Formatter("./datos/propietarios.txt");
        //Escritura en el archivo
        flujoSalida.format("%s,%s,%s",getNombresPropietario(),getApellidosPropietario(),getIdentificacionPropietario());
        //Cerrar archivo para escribir en este mismo.
        flujoSalida.close();
    }
}
