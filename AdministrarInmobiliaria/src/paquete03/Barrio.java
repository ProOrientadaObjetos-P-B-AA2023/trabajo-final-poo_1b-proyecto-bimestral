package paquete03;

import paquete02.Propietario;

import java.io.*;

public class Barrio implements Serializable{
    //Atributos
    private String nombreBarrio;
    private String referenciaBarrio;
    //Constructores
    public Barrio() {
    }

    public Barrio(String nombreBarrio, String referenciaBarrio) {
        this.nombreBarrio = nombreBarrio;
        this.referenciaBarrio = referenciaBarrio;
    }
    //Metodos SET y GET
    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public void setReferenciaBarrio(String referenciaBarrio) {
        this.referenciaBarrio = referenciaBarrio;
    }

    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public String getReferenciaBarrio() {
        return referenciaBarrio;
    }
    //Metodos
    public void guardarObjeto(Object barrio) {
        try {
            // Guardar el objeto en el archivo
            ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream("./datos/barrio.dat"));
            objetoSalida.writeObject(barrio);
            objetoSalida.close();
            System.out.println("Objeto guardado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar el objeto: " + e.getMessage());
        }
    }

    public void leerObjeto() {
        try {
            ObjectInputStream objetoEntrada = new ObjectInputStream(new FileInputStream("./datos/barrio.dat"));
            System.out.println((Propietario) objetoEntrada.readObject());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
