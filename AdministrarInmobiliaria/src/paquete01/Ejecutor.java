package paquete01;


import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;
import paquete06.Casa;
import paquete06.Departamento;
import paquete07.Inmobiliaria;
import paquete07.Interfaz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejecutor {

    public static void main(String[] args) {
        // Variables y Objetos usados
        Scanner entrada = new Scanner(System.in);
        Inmobiliaria gestor = new Inmobiliaria();
        int opcionMenu_1, opcionMenu_2, opcionMenu_3;
        boolean bandera_1;
        boolean banderError1, banderError2;
        //Inicializacion de variables
        bandera_1 = true;
        banderError1 = true;
        banderError2 = true;
        opcionMenu_1 = -1;
        opcionMenu_2 = -1;
        do {
            /*Inicio del programa*/
            do {
                try {
                    Interfaz.menu_principal();
                    opcionMenu_1 = entrada.nextInt();
                    entrada.nextLine();
                    banderError1 = false;
                }catch (InputMismatchException e) {
                    Interfaz.manejoErrores(1);
                    entrada.nextLine();
                }
            } while (banderError1);

            //El usario puede escoger las siguientes opciones
            if (opcionMenu_1 == 1) {
                do {
                    try {
                        Interfaz.menu_secundario();
                        opcionMenu_2 = entrada.nextInt();
                        banderError2 = false;
                    }catch (InputMismatchException e) {
                        Interfaz.manejoErrores(1);
                        entrada.nextLine();
                    }
                } while (banderError2);
                entrada.nextLine();

                switch (opcionMenu_2) {
                    case 1 -> {
                        System.out.println("--------------- REGISTRO PROPIETARIO ---------------");
                        Propietario propietarioMain = new Propietario();
                        System.out.print("Ingrese los nombres: ");
                        propietarioMain.setNombresPropietario(entrada.nextLine());
                        System.out.print("Ingrese los apellidos: ");
                        propietarioMain.setApellidosPropietario(entrada.nextLine());
                        System.out.print("Ingrese la cedula o dni: ");
                        propietarioMain.setIdentificacionPropietario(entrada.nextLine());
                        //Busqueda elemento repetido
                        if (gestor.buscadorEnArchivos("./datos/propietarios.txt", propietarioMain.getIdentificacionPropietario())) {
                            System.out.println("Ya se encuentra registrado.");
                        } else {
                            //Guardado en archivo y agregado a clase principal
                            gestor.agregarPropietario(propietarioMain);
                            gestor.serializarPropietarios();
                            gestor.vaciarListas();
                        }
                    }
                    case 2 -> {
                        System.out.println("--------------- REGISTRO BARRIO ---------------");
                        Barrio barrioMain = new Barrio();
                        System.out.print("Ingrese nombre del barrio: ");
                        barrioMain.setNombreBarrio(entrada.nextLine());
                        System.out.print("Ingrese referencia del barrio: ");
                        barrioMain.setReferenciaBarrio(entrada.nextLine());
                        if (gestor.buscadorEnArchivos("./datos/barrios.txt", barrioMain.getNombreBarrio())) {
                            System.out.println("Ya se encuentra registrado.");
                        } else {
                            gestor.agregarBarrio(barrioMain);
                            gestor.serializarBarrios();
                            gestor.vaciarListas();
                        }
                    }
                    case 3 -> {
                        System.out.println("--------------- REGISTRO CIUDAD ---------------");
                        Ciudad ciudadMain = new Ciudad();
                        System.out.print("Ingrese el nombre de la ciudad: ");
                        ciudadMain.setNombreCiudad(entrada.nextLine());
                        System.out.print("Ingrese el nombre de la provincia: ");
                        ciudadMain.setNombreProvincia(entrada.nextLine());
                        if (gestor.buscadorEnArchivos("./datos/ciudades.txt", ciudadMain.getNombreCiudad())) {
                            System.out.println("Ya se encuentra registrado.");
                        } else {
                            gestor.agregarCiudad(ciudadMain);
                            gestor.serializarCiudades();
                            gestor.vaciarListas();
                        }
                    }
                    case 4 -> {
                        System.out.println("--------------- REGISTRO CONSTRUCTORA ---------------");
                        Constructora constructoraMain = new Constructora();
                        System.out.print("Ingrese nombre de la constructora: ");
                        constructoraMain.setNombreConstructora(entrada.nextLine());
                        System.out.print("Ingrese ID de la empresa: ");
                        constructoraMain.setIdEmpresaConstructora(entrada.nextLine());
                        if (gestor.buscadorEnArchivos("./datos/constructoras.txt", constructoraMain.getIdEmpresaConstructora())) {
                            System.out.println("Ya se encuentra registrado.");
                        } else {
                            gestor.agregarConstructora(constructoraMain);
                            gestor.serializarConstructoras();
                            gestor.vaciarListas();
                        }
                    }
                    case 5 -> {
                        //Variables usadas
                        String cedulaPropietario, nombreBarrio, nombreCiudad, idConstructora;
                        System.out.println("--------------- REGISTRO CASA ---------------");
                        Casa casaMain = new Casa();
                        //Buscar por numero de cedula de/ propietario
                        System.out.print("Digite la cedula del propietario: ");
                        cedulaPropietario = entrada.nextLine();
                        if (gestor.buscadorEnArchivos("./datos/propietarios.txt", cedulaPropietario)) {
                            casaMain.setPropietario((Propietario) gestor.obtenerObjetoArchivo("./datos/propietarios.txt", cedulaPropietario));
                        } else {
                            Propietario propietarioCasa = new Propietario();
                            System.out.println("-------------------------------------------------");
                            System.out.print("Ingrese los nombres: ");
                            propietarioCasa.setNombresPropietario(entrada.nextLine());
                            System.out.print("Ingrese los apellidos: ");
                            propietarioCasa.setApellidosPropietario(entrada.nextLine());
                            System.out.print("Ingrese la cedula o dni: ");
                            propietarioCasa.setIdentificacionPropietario(entrada.nextLine());
                            System.out.println("-------------------------------------------------");
                            gestor.agregarPropietario(propietarioCasa);
                            gestor.serializarPropietarios();
                        }
                        //Buscar por el Id de la contructora
                        System.out.print("Ingrese el ID de la constructora: ");
                        idConstructora = entrada.nextLine();
                        if (gestor.buscadorEnArchivos("./datos/constructoras.txt", idConstructora)) {
                            casaMain.setConstructora((Constructora) gestor.obtenerObjetoArchivo("./datos/constructoras.txt", idConstructora));
                        } else {
                            Constructora constructoraCasa = new Constructora();
                            System.out.println("-------------------------------------------------");
                            System.out.print("Ingrese nombre de la constructora: ");
                            constructoraCasa.setNombreConstructora(entrada.nextLine());
                            System.out.print("Ingrese ID de la empresa: ");
                            constructoraCasa.setIdEmpresaConstructora(entrada.nextLine());
                            System.out.println("-------------------------------------------------");
                            gestor.agregarConstructora(constructoraCasa);
                            gestor.serializarConstructoras();
                        }
                        //Buscar por el nombre de la ciudad
                        System.out.print("Ingrese nombre de la ciudad: ");
                        nombreCiudad = entrada.nextLine();
                        if (gestor.buscadorEnArchivos("./datos/ciudades.txt", nombreCiudad)) {
                            casaMain.setCiudad((Ciudad) gestor.obtenerObjetoArchivo("./datos/ciudades.txt", nombreCiudad));
                        } else {
                            Ciudad ciudadCasa = new Ciudad();
                            System.out.println("-------------------------------------------------");
                            System.out.print("Ingrese el nombre de la ciudad: ");
                            ciudadCasa.setNombreCiudad(entrada.nextLine());
                            System.out.print("Ingrese el nombre de la provincia: ");
                            ciudadCasa.setNombreProvincia(entrada.nextLine());
                            System.out.println("-------------------------------------------------");
                            gestor.agregarCiudad(ciudadCasa);
                            gestor.serializarCiudades();
                        }
                        //Buscar por el nombre del barrio
                        System.out.print("Ingrese el nombre del barrio: ");
                        nombreBarrio = entrada.nextLine();
                        if (gestor.buscadorEnArchivos("./datos/barrios.txt", nombreBarrio)) {
                            casaMain.setBarrio((Barrio) gestor.obtenerObjetoArchivo("./datos/barrios.txt", nombreBarrio));
                        } else {
                            Barrio barrioCasa = new Barrio();
                            System.out.println("-------------------------------------------------");
                            System.out.print("Ingrese nombre del barrio: ");
                            barrioCasa.setNombreBarrio(entrada.nextLine());
                            System.out.print("Ingrese referencia del barrio: ");
                            barrioCasa.setReferenciaBarrio(entrada.nextLine());
                            System.out.println("-------------------------------------------------");
                            gestor.agregarBarrio(barrioCasa);
                            gestor.serializarBarrios();
                        }
                        //Demas datos esenciales
                        System.out.print("Ingrese el precio por metro cuadrado: ");
                        casaMain.setPrecioMetroCuadrado(entrada.nextDouble());
                        System.out.print("Ingrese el numero de metros cuadrados: ");
                        casaMain.setNumeroMetrosCuadrados(entrada.nextDouble());
                        System.out.print("Ingrese el numero de cuartos: ");
                        casaMain.setNumeroCuartos(entrada.nextInt());
                        casaMain.calcularCostoFinal();
                        gestor.agregarCasa(casaMain);
                        gestor.serializarCasas();
                        gestor.vaciarListas();
                    }
                    case 6 -> {
                        //Variables usadas
                        String cedulaPropietario, nombreBarrio, nombreCiudad, idConstructora;
                        System.out.println("--------------- REGISTRO DEPARTAMENTO ---------------");
                        Departamento departamentoMain = new Departamento();
                        //Buscar por numero de cedula de/ propietario
                        System.out.print("Digite la cedula del propietario: ");
                        cedulaPropietario = entrada.nextLine();
                        if (gestor.buscadorEnArchivos("./datos/propietarios.txt", cedulaPropietario)) {
                            departamentoMain.setPropietario((Propietario) gestor.obtenerObjetoArchivo("./datos/propietarios.txt", cedulaPropietario));
                        } else {
                            Propietario propietarioDepartamento = new Propietario();
                            System.out.println("-------------------------------------------------");
                            System.out.print("Ingrese los nombres: ");
                            propietarioDepartamento.setNombresPropietario(entrada.nextLine());
                            System.out.print("Ingrese los apellidos: ");
                            propietarioDepartamento.setApellidosPropietario(entrada.nextLine());
                            System.out.print("Ingrese la cedula o dni: ");
                            propietarioDepartamento.setIdentificacionPropietario(entrada.nextLine());
                            System.out.println("-------------------------------------------------");
                            gestor.agregarPropietario(propietarioDepartamento);
                            gestor.serializarPropietarios();
                        }
                        //Buscar por el Id de la contructora
                        System.out.print("Ingrese el ID de la constructora: ");
                        idConstructora = entrada.nextLine();
                        if (gestor.buscadorEnArchivos("./datos/constructoras.txt", idConstructora)) {
                            departamentoMain.setConstructora((Constructora) gestor.obtenerObjetoArchivo("./datos/constructoras.txt", idConstructora));
                        } else {
                            Constructora constructoraDepartamento = new Constructora();
                            System.out.println("-------------------------------------------------");
                            System.out.print("Ingrese nombre de la constructora: ");
                            constructoraDepartamento.setNombreConstructora(entrada.nextLine());
                            System.out.print("Ingrese ID de la empresa: ");
                            constructoraDepartamento.setIdEmpresaConstructora(entrada.nextLine());
                            System.out.println("-------------------------------------------------");
                            gestor.agregarConstructora(constructoraDepartamento);
                            gestor.serializarConstructoras();
                        }
                        //Buscar por el nombre de la ciudad
                        System.out.print("Ingrese nombre de la ciudad: ");
                        nombreCiudad = entrada.nextLine();
                        if (gestor.buscadorEnArchivos("./datos/ciudades.txt", nombreCiudad)) {
                            departamentoMain.setCiudad((Ciudad) gestor.obtenerObjetoArchivo("./datos/ciudades.txt", nombreCiudad));
                        } else {
                            Ciudad ciudadDepartamento = new Ciudad();
                            System.out.println("-------------------------------------------------");
                            System.out.print("Ingrese el nombre de la ciudad: ");
                            ciudadDepartamento.setNombreCiudad(entrada.nextLine());
                            System.out.print("Ingrese el nombre de la provincia: ");
                            ciudadDepartamento.setNombreProvincia(entrada.nextLine());
                            System.out.println("-------------------------------------------------");
                            gestor.agregarCiudad(ciudadDepartamento);
                            gestor.serializarCiudades();
                        }
                        //Buscar por el nombre del barrio
                        System.out.print("Ingrese el nombre del barrio: ");
                        nombreBarrio = entrada.nextLine();
                        if (gestor.buscadorEnArchivos("./datos/barrios.txt", nombreBarrio)) {
                            departamentoMain.setBarrio((Barrio) gestor.obtenerObjetoArchivo("./datos/barrios.txt", nombreBarrio));
                        } else {
                            Barrio barrioDepartamento = new Barrio();
                            System.out.println("-------------------------------------------------");
                            System.out.print("Ingrese nombre del barrio: ");
                            barrioDepartamento.setNombreBarrio(entrada.nextLine());
                            System.out.print("Ingrese referencia del barrio: ");
                            barrioDepartamento.setReferenciaBarrio(entrada.nextLine());
                            System.out.println("-------------------------------------------------");
                            gestor.agregarBarrio(barrioDepartamento);
                            gestor.serializarBarrios();
                        }
                        System.out.print("Ingrese el nombre del edificio: ");
                        departamentoMain.setNombreEdificio(entrada.nextLine());
                        System.out.print("Ingrese ubicacion del departamento en el edifico: ");
                        departamentoMain.setUbicacionDepartamento(entrada.nextLine());
                        System.out.print("Ingrese el precio por metro cuadrado: ");
                        departamentoMain.setPrecioMetroCuadrado(entrada.nextDouble());
                        System.out.print("Ingrese el numero de metros cuadrados: ");
                        departamentoMain.setNumeroMetrosCuadrados(entrada.nextDouble());
                        System.out.print("Ingrese valor de Alicuota Mensual: ");
                        departamentoMain.setValorAlicuotaMensual(entrada.nextDouble());
                        departamentoMain.calcularCostoFinal();
                        gestor.agregarDepartamento(departamentoMain);
                        gestor.serializarDepartamentos();
                        gestor.vaciarListas();
                    }
                    case 7 -> {
                        System.out.println();
                        System.out.println("Volviendo al menu principal");
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Opcion invalida");
                    }
                }
            }

            if (opcionMenu_1 == 2) {
                Interfaz.menu_terciario();
                opcionMenu_3 = entrada.nextInt();

                switch (opcionMenu_3) {
                    case 1 -> {
                        gestor.deserializarPropietarios();
                        gestor.imprimirPropietarios();
                        gestor.vaciarListas();
                    }
                    case 2 -> {
                        gestor.deserializarBarrios();
                        gestor.imprimirBarrios();
                        gestor.vaciarListas();
                    }
                    case 3 -> {
                        gestor.deserializarCiudades();
                        gestor.imprimirCiudades();
                        gestor.vaciarListas();
                    }
                    case 4 -> {
                        gestor.deserializarConstructoras();
                        gestor.imprimirConstructoras();
                        gestor.vaciarListas();
                    }
                    case 5 -> {
                        gestor.deserializarCasas();
                        gestor.imprimirCasas();
                        gestor.vaciarListas();
                    }
                    case 6 -> {
                        gestor.deserializarDepartamentos();
                        gestor.imprimirDepartamentos();
                        gestor.vaciarListas();
                    }
                    case 7 -> {
                        System.out.println();
                        System.out.println("Volviendo al menu principal");
                    }
                    default -> {
                        System.out.println();
                        System.out.println("Opcion invalida");
                    }
                }
            }

            if (opcionMenu_1 == 3) {
                System.out.println("Fin del Programa");
                bandera_1 = false;
            }

        } while (bandera_1);
    }
}
