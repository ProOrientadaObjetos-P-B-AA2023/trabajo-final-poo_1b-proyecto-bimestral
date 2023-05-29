package paquete06;

import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

import java.io.*;

public class Casa implements Serializable {
    //Atributos
    private Propietario propietario;
    private Constructora constructora;
    private Ciudad ciudad;
    private Barrio barrio;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrados;
    private int numeroCuartos;
    private double costoFinal;
    //Constructores
    public Casa() {
    }

    public Casa(Propietario propietario, Constructora constructora, Ciudad ciudad, Barrio barrio, double precioMetroCuadrado, double numeroMetrosCuadrados, int numeroCuartos) {
        this.propietario = propietario;
        this.constructora = constructora;
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.numeroMetrosCuadrados = numeroMetrosCuadrados;
        this.numeroCuartos = numeroCuartos;
    }
    //Metodos SET y GET

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public void setConstructora(Constructora constructora) {
        this.constructora = constructora;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public void setPrecioMetroCuadrado(double precioMetroCuadrado) {
        this.precioMetroCuadrado = precioMetroCuadrado;
    }

    public void setNumeroMetrosCuadrados(double numeroMetrosCuadrados) {
        this.numeroMetrosCuadrados = numeroMetrosCuadrados;
    }

    public void setNumeroCuartos(int numeroCuartos) {
        this.numeroCuartos = numeroCuartos;
    }

    public void calcularCostoFinal() {
        this.costoFinal = numeroMetrosCuadrados * precioMetroCuadrado;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public Constructora getConstructora() {
        return constructora;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public double getPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public double getNumeroMetrosCuadrados() {
        return numeroMetrosCuadrados;
    }

    public int getNumeroCuartos() {
        return numeroCuartos;
    }

    public double getCostoFinal() {
        return costoFinal;
    }
    //Metodo
    public void guardarObjeto(Object casa) {
        try {
            // Guardar el objeto en el archivo
            ObjectOutputStream objetoSalida = new ObjectOutputStream(new FileOutputStream("./datos/casa.dat"));
            objetoSalida.writeObject(casa);
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
