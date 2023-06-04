package paquete07;

import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;
import paquete06.Casa;
import paquete06.Departamento;

import java.io.*;
import java.util.*;

public class Inmobiliaria {
    //Atributos
    private static String[] rutasArchivos = new String[6];
    private List<Propietario> propietarios;
    private List<Barrio> barrios;
    private List<Ciudad> ciudades;
    private List<Constructora> constructoras;
    private List<Casa> casas;
    private List<Departamento> departamentos;
    //Constructor
    public Inmobiliaria() {
        rutasArchivos = new String[]{"./datos/propietarios.txt",
                                     "./datos/barrios.txt",
                                     "./datos/ciudades.txt",
                                     "./datos/constructoras.txt",
                                     "./datos/casas.txt",
                                     "./datos/departamentos.txt"};
        propietarios = new ArrayList<>();
        barrios = new ArrayList<>();
        ciudades = new ArrayList<>();
        constructoras = new ArrayList<>();
        casas = new ArrayList<>();
        departamentos = new ArrayList<>();
    }
    //Metodos para agregar a las listas los respectivos objetos
    public void agregarPropietario(Propietario propietario) {
        propietarios.add(propietario);
    }

    public void agregarBarrio(Barrio barrio) {
        barrios.add(barrio);
    }

    public void agregarCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
    }

    public void agregarConstructora(Constructora constructora) {
        constructoras.add(constructora);
    }

    public void agregarCasa(Casa casa) {
        casas.add(casa);
    }

    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }
    //Metodos para SEREALIZAR los diferentes tipos de objetos mediante CARACTERES.
    public void serializarPropietarios() {
        try (BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(rutasArchivos[0],true))) {
            for (Propietario propietario : propietarios) {
                String linea = propietario.getNombresPropietario() + ";" + propietario.getApellidosPropietario() + ";" + propietario.getIdentificacionPropietario() + "\n";
                flujoSalida.write(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al serializar los propietarios.");
        }
    }

    public void serializarBarrios() {
        try (BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(rutasArchivos[1],true))) {
            for (Barrio barrio : barrios) {
                String linea = barrio.getNombreBarrio() + ";" + barrio.getReferenciaBarrio() + "\n";
                flujoSalida.write(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al serializar los barrios.");
        }
    }

    public void serializarCiudades() {
        try (BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(rutasArchivos[2],true))) {
            for (Ciudad ciudad : ciudades) {
                String linea = ciudad.getNombreCiudad() + ";" + ciudad.getNombreProvincia() + "\n";
                flujoSalida.write(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al serializar los ciudades.");
        }
    }

    public void serializarConstructoras() {
        try (BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(rutasArchivos[3],true))) {
            for (Constructora constructora : constructoras) {
                String linea = constructora.getNombreConstructora() + ";" + constructora.getIdEmpresaConstructora() + "\n";
                flujoSalida.write(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al serializar los constructoras.");
        }
    }

    public void serializarCasas() {
        try (BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(rutasArchivos[4],true))) {
            for (Casa casa : casas) {
                flujoSalida.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                        casa.getPropietario().getNombresPropietario(),
                        casa.getPropietario().getApellidosPropietario(),
                        casa.getPropietario().getIdentificacionPropietario(),
                        casa.getConstructora().getNombreConstructora(),
                        casa.getConstructora().getIdEmpresaConstructora(),
                        casa.getCiudad().getNombreCiudad(),
                        casa.getCiudad().getNombreProvincia(),
                        casa.getBarrio().getNombreBarrio(),
                        casa.getBarrio().getReferenciaBarrio(),
                        casa.getPrecioMetroCuadrado(),
                        casa.getNumeroMetrosCuadrados(),
                        casa.getNumeroCuartos()));
            }
        } catch (IOException e) {
            System.out.println("Error al serializar los ciudades.");
        }
    }

    public void serializarDepartamentos() {
        try (BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(rutasArchivos[5],true))) {
            for (Departamento departamento : departamentos) {
                flujoSalida.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                        departamento.getPropietario().getNombresPropietario(),
                        departamento.getPropietario().getApellidosPropietario(),
                        departamento.getPropietario().getIdentificacionPropietario(),
                        departamento.getConstructora().getNombreConstructora(),
                        departamento.getConstructora().getIdEmpresaConstructora(),
                        departamento.getCiudad().getNombreCiudad(),
                        departamento.getCiudad().getNombreProvincia(),
                        departamento.getBarrio().getNombreBarrio(),
                        departamento.getBarrio().getReferenciaBarrio(),
                        departamento.getNombreEdificio(),
                        departamento.getUbicacionDepartamento(),
                        departamento.getPrecioMetroCuadrado(),
                        departamento.getNumeroMetrosCuadrados(),
                        departamento.getValorAlicuotaMensual()));
            }
        } catch (IOException e) {
            System.out.println("Error al serializar los ciudades.");
        }
    }
    //Metodos para DESEREALIZAR los diferentes tipos de objetos mediante CARACTERES.
    public void deserializarPropietarios() {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutasArchivos[0]))) {
            String linea;
            //Si la cadena llega al final del archivo retorna null
            while ((linea = reader.readLine()) != null) {
                //Separamos los datos leidos en un array
                String[] datos = linea.split(";");
                Propietario propietario = new Propietario(datos[0], datos[1], datos[2]);
                //Añadimos los datos persistentes a la lista correspondiente
                propietarios.add(propietario);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentran registros");
        } catch (IOException e) {
            System.out.println("Error al deserializar los propietarios.");
        }
    }

    public void deserializarBarrios() {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutasArchivos[1]))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(";");
                Barrio barrio = new Barrio(datos[0], datos[1]);
                barrios.add(barrio);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentran registros");
        } catch (IOException e) {
            System.out.println("Error al deserializar los propietarios.");
        }
    }

    public void deserializarCiudades() {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutasArchivos[2]))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(";");
                Ciudad ciudad = new Ciudad(datos[0], datos[1]);
                ciudades.add(ciudad);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentran registros");
        } catch (IOException e) {
            System.out.println("Error al deserializar los propietarios.");
        }
    }

    public void deserializarConstructoras() {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutasArchivos[3]))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(";");
                Constructora constructora = new Constructora(datos[0], datos[1]);
                constructoras.add(constructora);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentran registros");
        } catch (IOException e) {
            System.out.println("Error al deserializar los propietarios.");
        }
    }

    public void deserializarCasas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutasArchivos[4]))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(";");
                //Separamos los datos de los objetos y creamos a partir de ellos los objetos necesarios
                Propietario p1 = new Propietario(datos[0],datos[1],datos[2]);
                Constructora co1 = new Constructora(datos[3],datos[4]);
                Ciudad ci1 = new Ciudad(datos[5],datos[6]);
                Barrio b1 = new Barrio(datos[7],datos[8]);
                //Recuperamos el objeto con los parametros
                Casa casa = new Casa();
                casa.setPropietario(p1);
                casa.setConstructora(co1);
                casa.setCiudad(ci1);
                casa.setBarrio(b1);
                casa.setPrecioMetroCuadrado(Double.parseDouble(datos[9]));
                casa.setNumeroMetrosCuadrados(Double.parseDouble(datos[10]));
                casa.setNumeroCuartos(Integer.parseInt(datos[11]));
                casa.calcularCostoFinal();
                casas.add(casa);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentran registros");
        } catch (IOException e) {
            System.out.println("Error al deserializar los propietarios.");
        }
    }

    public void deserializarDepartamentos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutasArchivos[5]))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(";");
                //Separamos los datos de los objetos y creamos a partir de ellos los objetos necesarios
                Propietario p1 = new Propietario(datos[0],datos[1],datos[2]);
                Constructora co1 = new Constructora(datos[3],datos[4]);
                Ciudad ci1 = new Ciudad(datos[5],datos[6]);
                Barrio b1 = new Barrio(datos[7],datos[8]);
                //Recuperamos el objeto con los parametros
                Departamento departamento = new Departamento();
                departamento.setPropietario(p1);
                departamento.setConstructora(co1);
                departamento.setCiudad(ci1);
                departamento.setBarrio(b1);
                departamento.setNombreEdificio(datos[9]);
                departamento.setUbicacionDepartamento(datos[10]);
                departamento.setPrecioMetroCuadrado(Double.parseDouble(datos[11]));
                departamento.setNumeroMetrosCuadrados(Double.parseDouble(datos[12]));
                departamento.setValorAlicuotaMensual(Double.parseDouble(datos[13]));
                departamento.calcularCostoFinal();
                departamentos.add(departamento);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentran registros");
        } catch (IOException e) {
            System.out.println("Error al deserializar los propietarios.");
        }
    }

    //Metodos para imprimir las diferentes listas de objetos con bucle for-each
    public void imprimirPropietarios() {
        System.out.println("--------------- LISTADO PROPIETARIOS ---------------");
        for (Propietario propietario : propietarios) {
            System.out.printf("%s %s %s \n",propietario.getNombresPropietario(),propietario.getApellidosPropietario(), propietario.getIdentificacionPropietario());
        }
    }

    public void imprimirBarrios() {
        System.out.println("--------------- LISTADO BARRIOS ---------------");
        for (Barrio barrio : barrios) {
            System.out.printf("%s %s \n",barrio.getNombreBarrio(),barrio.getReferenciaBarrio());
        }
    }

    public void imprimirCiudades() {
        System.out.println("--------------- LISTADO CIUDADES ---------------");
        for (Ciudad ciudad : ciudades) {
            System.out.printf("%s %s \n",ciudad.getNombreCiudad(),ciudad.getNombreProvincia());
        }
    }

    public void imprimirConstructoras() {
        System.out.println("--------------- LISTADO CONSTRUCTORAS ---------------");
        for (Constructora constructora : constructoras) {
            System.out.printf("%s %s \n",constructora.getNombreConstructora(),constructora.getIdEmpresaConstructora());
        }
    }

    public void imprimirCasas() {
        System.out.println("--------------- LISTADO CASAS ---------------");
        for (Casa casa : casas) {
            System.out.printf("%s %s %s %s %.2f %.2f %d %.2f \n",casa.getPropietario().getIdentificacionPropietario() + " " + casa.getPropietario().getApellidosPropietario(),
                    casa.getConstructora().getNombreConstructora(),
                    casa.getCiudad().getNombreCiudad(),
                    casa.getBarrio().getNombreBarrio(),
                    casa.getPrecioMetroCuadrado(),
                    casa.getNumeroMetrosCuadrados(),
                    casa.getNumeroCuartos(),
                    casa.getCostoFinal());
        }
    }

    public void imprimirDepartamentos() {
        System.out.println("--------------- LISTADO DEPARTAMENTOS ---------------");
        for (Departamento departamento : departamentos) {
            System.out.printf("%s %s %s %s %s %s %.2f %.2f %.2f %.2f \n",departamento.getPropietario().getNombresPropietario() + " " + departamento.getPropietario().getApellidosPropietario(),
                    departamento.getConstructora().getNombreConstructora(),
                    departamento.getCiudad().getNombreCiudad(),
                    departamento.getBarrio().getNombreBarrio(),
                    departamento.getNombreEdificio(),
                    departamento.getUbicacionDepartamento(),
                    departamento.getPrecioMetroCuadrado(),
                    departamento.getNumeroMetrosCuadrados(),
                    departamento.getValorAlicuotaMensual(),
                    departamento.getCostoFinal());
        }
    }
    // Metodo general para buscar una palabra o caracteres si se encuentran repetidos en los archivos .dat
    public boolean buscadorEnArchivos(String rutaArchivo, String palabra) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                if (linea.contains(palabra)) {
                    //Retorna true si la palabra se encuentra repetida
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra en los registros la busqueda");
        } catch (IOException e) {
            System.out.println("ERROR (Fallo de lectura en lineas al ejecutar la busqueda)");
        }
        return false;
    }

    public Object obtenerObjetoArchivo(String rutaArchivo, String palabra) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.contains(palabra)) {
                    //Si encontramos el objeto buscado por la palabra entonces lo deserializamos
                    //dependiendo del tipo de objeto
                    String[] datos = linea.split(";");
                    if (rutasArchivos[0] == rutaArchivo) {
                        Propietario propietarioRetorno = new Propietario(datos[0], datos[1], datos[2]);
                        return propietarioRetorno;
                    } else if (rutasArchivos[1] == rutaArchivo) {
                        Barrio barrioRetorno = new Barrio(datos[0], datos[1]);
                        return barrioRetorno;
                    } else if (rutasArchivos[2] == rutaArchivo) {
                        Ciudad ciudadRetorno = new Ciudad(datos[0], datos[1]);
                        return ciudadRetorno;
                    } else if (rutasArchivos[3] == rutaArchivo){
                        Constructora constructoraRetorno = new Constructora(datos[0], datos[1]);
                        return constructoraRetorno;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra en los registros la busqueda");
        } catch (IOException e) {
            System.out.println("ERROR (Fallo de lectura en lineas al ejecutar la busqueda)");
        }
        return null;
    }

    public void vaciarListas() {
        this.propietarios.clear();
        this.barrios.clear();
        this.ciudades.clear();
        this.constructoras.clear();
        this.casas.clear();
        this.departamentos.clear();
    }
}