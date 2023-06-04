package paquete06;

import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

import java.io.*;

public class Departamento implements Serializable {
    //Atributos
    private Propietario propietario;
    private Constructora constructora;
    private Ciudad ciudad;
    private Barrio barrio;
    private String nombreEdificio;
    private String ubicacionDepartamento;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrados;
    private double valorAlicuotaMensual;
    private double costoFinal;
    //Constructores
    public Departamento() {
    }

    public Departamento(Propietario propietario, Constructora constructora, Ciudad ciudad, Barrio barrio, String nombreEdificio, String ubicacionDepartamento, double precioMetroCuadrado, double numeroMetrosCuadrados, double valorAlicuotaMensual) {
        this.propietario = propietario;
        this.constructora = constructora;
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.nombreEdificio = nombreEdificio;
        this.ubicacionDepartamento = ubicacionDepartamento;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.numeroMetrosCuadrados = numeroMetrosCuadrados;
        this.valorAlicuotaMensual = valorAlicuotaMensual;
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

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public void setUbicacionDepartamento(String ubicacionDepartamento) {
        this.ubicacionDepartamento = ubicacionDepartamento;
    }

    public void setPrecioMetroCuadrado(double precioMetroCuadrado) {
        this.precioMetroCuadrado = precioMetroCuadrado;
    }

    public void setNumeroMetrosCuadrados(double numeroMetrosCuadrados) {
        this.numeroMetrosCuadrados = numeroMetrosCuadrados;
    }

    public void setValorAlicuotaMensual(double valorAlicuotaMensual) {
        this.valorAlicuotaMensual = valorAlicuotaMensual;
    }

    public void calcularCostoFinal() {
        this.costoFinal = (numeroMetrosCuadrados * precioMetroCuadrado) + (valorAlicuotaMensual * (double) 12);
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

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public String getUbicacionDepartamento() {
        return ubicacionDepartamento;
    }

    public double getPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public double getNumeroMetrosCuadrados() {
        return numeroMetrosCuadrados;
    }

    public double getValorAlicuotaMensual() {
        return valorAlicuotaMensual;
    }

    public double getCostoFinal() {
        return costoFinal;
    }
}
