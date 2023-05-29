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
    //toString
    @Override
    public String toString() {
        return "Propietario{" +
                "nombresPropietario='" + nombresPropietario + '\'' +
                ", apellidosPropietario='" + apellidosPropietario + '\'' +
                ", identificacionPropietario='" + identificacionPropietario + '\'' +
                '}';
    }

    //Metodos
    public void guardarObjeto(Object propietario) {
        try {
            // Guardar el objeto en el archivo
            ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream("./datos/propietario.dat"));
            objetoSalida.writeObject(propietario);
            objetoSalida.close();
            System.out.println("Objeto guardado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar el objeto: " + e.getMessage());
        }
    }

    public void leerObjeto() {
        try {
            ObjectInputStream objetoEntrada = new ObjectInputStream(new FileInputStream("./datos/propietario.dat"));
            System.out.println((Propietario) objetoEntrada.readObject());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
