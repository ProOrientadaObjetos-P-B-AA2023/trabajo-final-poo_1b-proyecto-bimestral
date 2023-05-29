package paquete05;

import paquete02.Propietario;

import java.io.*;

public class Constructora implements Serializable {
    //Atributos
    private String nombreConstructora;
    private String idEmpresaConstructora;
    //Constructores
    public Constructora() {
    }

    public Constructora(String nombreConstructora, String idEmpresaConstructora) {
        this.nombreConstructora = nombreConstructora;
        this.idEmpresaConstructora = idEmpresaConstructora;
    }
    //Metodos SET y GET
    public void setNombreConstructora(String nombreConstructora) {
        this.nombreConstructora = nombreConstructora;
    }

    public void setIdEmpresaConstructora(String idEmpresaConstructora) {
        this.idEmpresaConstructora = idEmpresaConstructora;
    }

    public String getNombreConstructora() {
        return nombreConstructora;
    }

    public String getIdEmpresaConstructora() {
        return idEmpresaConstructora;
    }
    //Metodo
    public void guardarObjeto(Object constructora) {
        try {
            // Guardar el objeto en el archivo
            ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream("./datos/constructora.dat"));
            objetoSalida.writeObject(constructora);
            objetoSalida.close();
            System.out.println("Objeto guardado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar el objeto: " + e.getMessage());
        }
    }

    public void leerObjeto() {
        try {
            ObjectInputStream objetoEntrada = new ObjectInputStream(new FileInputStream("./datos/constructora.dat"));
            System.out.println((Propietario) objetoEntrada.readObject());

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
