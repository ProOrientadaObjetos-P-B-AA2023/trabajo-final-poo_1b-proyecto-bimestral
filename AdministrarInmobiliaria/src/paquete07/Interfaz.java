package paquete07;

public class Interfaz {
    public static void menu_principal() {
        System.out.println("             ┌────────────────────────────────┐");
        System.out.println("             │              MENU              │");
        System.out.println("             │────────────────────────────────│");
        System.out.println("             │  1) Registro de datos          │");
        System.out.println("             │  2) Listado de datos           │");
        System.out.println("             │  3) Salir                      │");
        System.out.println("             └────────────────────────────────┘");
        System.out.print("-Ingrese una opcion: ");
    }

    public static void menu_secundario() {
        System.out.println("             ┌────────────────────────────────┐");
        System.out.println("             │       REGISTRO DE DATOS        │");
        System.out.println("             │────────────────────────────────│");
        System.out.println("             │  1) Propietario                │");
        System.out.println("             │  2) Barrio                     │");
        System.out.println("             │  3) Constructora               │");
        System.out.println("             │  4) Casa                       │");
        System.out.println("             │  5) Departamento               │");
        System.out.println("             │  6) Regresar                   │");
        System.out.println("             └────────────────────────────────┘");
        System.out.print("-Ingrese una opcion: ");
    }

    public static void menu_terciario() {
        System.out.println("             ┌────────────────────────────────┐");
        System.out.println("             │        LISTADO DE DATOS        │");
        System.out.println("             │────────────────────────────────│");
        System.out.println("             │  1) Propietarios               │");
        System.out.println("             │  2) Barrios                    │");
        System.out.println("             │  3) Constructoras              │");
        System.out.println("             │  4) Casas                      │");
        System.out.println("             │  5) Departamentos              │");
        System.out.println("             │  6) Regresar                   │");
        System.out.println("             └────────────────────────────────┘");
        System.out.print("-Ingrese una opcion: ");
    }

    public static void manejoErrores(int tipoError) {
        switch (tipoError) {
            case 1 -> {
                System.out.println("┌────────────────────────────────────────┐");
                System.out.println("│ ERROR (No ingrese letras ni simbolos.) │");
                System.out.println("└────────────────────────────────────────┘");
            }
            case 2 -> {
                System.out.println("┌──────────────────────────────────────┐");
                System.out.println("│ ERROR (Escoga una opcion disponible) │");
                System.out.println("└──────────────────────────────────────┘");
            }
            default -> System.out.println("ERROR CON MANEJO DE ERRORES");
        }
    }

}
