package paquete04;

import paquete02.Propietario;

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
    //Metodos
    public void guardarObjeto(Object ciudad) {
        try {
            // Guardar el objeto en el archivo
            ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream("./datos/ciudad.dat"));
            objetoSalida.writeObject(ciudad);
            objetoSalida.close();
            System.out.println("Objeto guardado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar el objeto: " + e.getMessage());
        }
    }

    public void leerObjeto() {
        try {
            ObjectInputStream objetoEntrada = new ObjectInputStream(new FileInputStream("./datos/ciudad.dat"));
            System.out.println((Propietario) objetoEntrada.readObject());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
