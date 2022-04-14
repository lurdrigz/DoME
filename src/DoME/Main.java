package DoME;

import java.util.Scanner;

public class Main {

    static Scanner kb;

    public static void main(String[] args) {

        kb = new Scanner(System.in);

        AppDoME DoME = new AppDoME();

        // Hardcodeado
        /*
        CD cd1 = DoME.agregarCD("American Idiot", "Green Day", 9, 57, 1);
        CD cd2 = DoME.agregarCD("Eternal Grey", "SuicideBoys", 11, 31, 1);
        CD cd3 = DoME.agregarCD("Warning", "Green Day", 11, 41, 1);

        System.out.println("\n ---- LISTANDO LOS DE GREEN DAY ----");
        DoME.listarCDsInterprete("Green Day");

        //System.out.println("\n --- QUITANDO EL SEGUNDO CD ----");
        //DoME.quitarUnCD("Eternal Grey", "SuicideBoys");

        System.out.println("\n --- PRESTANDO EL SEGUNDO CD ---");
        DoME.prestarUnElemento("CD", "American Idiot", "Green Day");
        DoME.listarCDsInterprete("Green Day");

        System.out.println("\n --- DEVOLVIENDO EL SEGUNDO CD ---");
        DoME.devolverUnElemento("CD", "American Idiot", "Green Day");
        DoME.listarCDsInterprete("Green Day");
        */

        // Con inputs
        int opcionPpal;
        System.out.println("Bienvenido :)");
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione una opción: 1. CD | 2. DVD | 3. Salir");
            opcionPpal = kb.nextInt();

            switch (opcionPpal) {
                case 1:
                    menuCD(DoME);
                    break;

                case 2:
                    menuDVD(DoME);
                    break;

                case 3:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }

        kb.close();
    }

    public static void menuDVD(AppDoME DoME) {
        String titulo, director;
        int duracion;
        boolean existencia;
        boolean continuar = true;

        while (continuar) {
            menuElemento(2);
            System.out.println("\n> Opción:");
            int opcion = kb.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese título del DVD: ");
                    kb.nextLine();
                    titulo = kb.nextLine();
                    System.out.println("Ingrese director: ");
                    director = kb.nextLine();
                    System.out.println("Ingrese minutos de duración: ");
                    duracion = kb.nextInt();
                    DoME.agregarDVDs(titulo, director, duracion, 1);
                    System.out.println("DVD agregado exitosamente.");
                    break;

                case 2:
                    System.out.println("Ingrese título del DVD: ");
                    kb.nextLine();
                    titulo = kb.nextLine();
                    System.out.println("Ingrese director:");
                    director = kb.nextLine();
                    DoME.quitarUnCD(titulo, director);
                    System.out.println("DVD quitado exitosamente.");
                    break;

                case 3:
                    System.out.println("Ingrese título a buscar:");
                    kb.nextLine();
                    titulo = kb.nextLine();
                    System.out.println("Ingrese director: ");
                    director = kb.nextLine();
                    existencia = DoME.buscarDVDPorTitulo_Director(titulo, director);
                    if (existencia) {
                        System.out.println("El DVD existe.");
                    } else {
                        System.out.println("El DVD no existe.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese director: ");
                    kb.nextLine();
                    director = kb.nextLine();
                    DoME.listarDVDsDirector(director);
                    break;

                case 5:
                    System.out.println("Ingrese nombre del DVD a prestar:");
                    kb.nextLine();
                    titulo = kb.nextLine();
                    System.out.println("Ingrese director: ");
                    director = kb.nextLine();
                    DoME.prestarUnElemento("DVD", titulo, director);
                    break;

                case 6:
                    System.out.println("Ingrese nombre del DVD a devolver: ");
                    kb.nextLine();
                    titulo = kb.nextLine();
                    System.out.println("Ingrese director: ");
                    director = kb.nextLine();
                    DoME.devolverUnElemento("DVD", titulo, director);
                    break;

                case 7:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    public static void menuCD(AppDoME DoME) {
        String titulo, interprete;
        int cdadTemas, duracion;
        boolean existencia;
        boolean continuar = true;

        while (continuar) {
            menuElemento(1);
            System.out.println("\n> Opción:");
            int opcion = kb.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese título del CD: ");
                    kb.nextLine();
                    titulo = kb.nextLine();
                    System.out.println("Ingrese intérprete: ");
                    interprete = kb.nextLine();
                    System.out.println("Ingrese cantidad de canciones: ");
                    cdadTemas = kb.nextInt();
                    System.out.println("Ingrese minutos de duración: ");
                    duracion = kb.nextInt();
                    DoME.agregarCD(titulo, interprete, cdadTemas, duracion, 1);
                    System.out.println("CD agregado exitosamente.");
                    break;

                case 2:
                    System.out.println("Ingrese título del CD: ");
                    kb.nextLine();
                    titulo = kb.nextLine();
                    System.out.println("Ingrese intérprete:");
                    interprete = kb.nextLine();
                    DoME.quitarUnCD(titulo, interprete);
                    System.out.println("CD quitado exitosamente.");
                    break;

                case 3:
                    System.out.println("Ingrese título a buscar:");
                    kb.nextLine();
                    titulo = kb.nextLine();
                    System.out.println("Ingrese intérprete: ");
                    interprete = kb.nextLine();
                    existencia = DoME.buscarCDPorTitulo_Interprete(titulo, interprete);
                    if (existencia) {
                        System.out.println("El CD existe.");
                    } else {
                        System.out.println("El CD no existe.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese intérprete: ");
                    kb.nextLine();
                    interprete = kb.nextLine();
                    DoME.listarCDsInterprete(interprete);
                    break;

                case 5:
                    System.out.println("Ingrese nombre del CD a prestar:");
                    kb.nextLine();
                    titulo = kb.nextLine();
                    System.out.println("Ingrese intérprete: ");
                    interprete = kb.nextLine();
                    DoME.prestarUnElemento("CD", titulo, interprete);
                    break;

                case 6:
                    System.out.println("Ingrese nombre del CD a devolver: ");
                    kb.nextLine();
                    titulo = kb.nextLine();
                    System.out.println("Ingrese intérprete: ");
                    interprete = kb.nextLine();
                    DoME.devolverUnElemento("CD", titulo, interprete);
                    break;

                case 7:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }

    }

    public static void menuElemento(int elemento) {
        System.out.println("\n1. Agregar");
        System.out.println("2. Quitar");
        if (elemento == 1) {
            System.out.println("3. Comprobar existencia de título e intérprete");
            System.out.println("4. Buscar CD por intérprete");
        } else if (elemento == 2) {
            System.out.println("3. Comprobar existencia de título y director");
            System.out.println("4. Buscar DVD por director");
        }
        System.out.println("5. Prestar");
        System.out.println("6. Devolver");
        System.out.println("7. Volver a menú principal");
    }

}
