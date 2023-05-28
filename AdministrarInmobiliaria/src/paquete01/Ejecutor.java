package paquete01;


import paquete07.Interfaz;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejecutor {
    public static void main(String[] args) {
        //Variables utilizadas
        Scanner entrada = new Scanner(System.in);
        int opcionPrimaria,opcionSecundaria;

        /*Inicio del Programa*/
        opcionPrimaria = -1;
        opcionSecundaria = -1;

        while (opcionPrimaria != 3) {
            do {
                try {
                    Interfaz.menu_principal();
                    opcionPrimaria = entrada.nextInt();
                    if (opcionPrimaria <= 0 || opcionPrimaria > 3) {
                        Interfaz.manejoErrores(2);
                    }
                } catch (InputMismatchException e) {
                    Interfaz.manejoErrores(1);
                    entrada.nextLine();
                }
            } while (opcionPrimaria <= 0 || opcionPrimaria > 3);

            switch (opcionPrimaria) {
                case 1 -> {
                    do {
                        try {
                            Interfaz.menu_secundario();
                            opcionSecundaria = entrada.nextInt();
                            if (opcionSecundaria <= 0 || opcionSecundaria > 3) {
                                Interfaz.manejoErrores(2);
                            }
                        } catch (InputMismatchException e) {
                            Interfaz.manejoErrores(1);
                            entrada.nextLine();
                        }
                    } while (opcionSecundaria <= 0 || opcionSecundaria > 6);
                    //Codigo faltante
                }
                case 2 -> {
                    do {
                        try {
                            Interfaz.menu_terciario();
                            opcionSecundaria = entrada.nextInt();
                            if (opcionSecundaria <= 0 || opcionSecundaria > 3) {
                                Interfaz.manejoErrores(2);
                            }
                        } catch (InputMismatchException e) {
                            Interfaz.manejoErrores(1);
                            entrada.nextLine();
                        }
                    } while (opcionSecundaria <= 0 || opcionSecundaria > 6);
                    //Codigo faltante
                }
                case 3 -> {
                    System.out.println();
                    System.out.println("FIN DEL PROGRAMA");
                }
            }
        }
    }
}
