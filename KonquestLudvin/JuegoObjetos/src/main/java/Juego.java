
import Jugador.Jugador;
import Planeta.Agua;
import Planeta.Fuego;
import Planeta.Organico;
import Planeta.Planeta;
import Planeta.Radioactivo;
import Planeta.Tierra;
import java.util.Scanner;

/**
 *
 * @author baquiax
 */
public class Juego {

    public static final int PROBABILIBAD_DISTRIBUCION_TIERRA = 45;
    public static final int PROBABILIBAD_DISTRIBUCION_AGUA = 25;
    public static final int PROBABILIBAD_DISTRIBUCION_FUEGO = 15;
    public static final int PROBABILIBAD_DISTRIBUCION_ORGANICO = 10;
    public static final int PROBABILIBAD_DISTRIBUCION_RADIOACTI = 5;

    public static final String ANSI_RESET = "\u001B[0m";
    //Colores de letra
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    //Colores de fondo
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    static Jugador jugadores[] = new Jugador[2];
    Mapa mapas[] = new Mapa[1];

    //Inicio
    public void inicio() {
        System.out.println("Bienvenido a Konquest");
        menu();
    }

    //Menu
    public void menu() {
        String opcion;
        boolean salir = false;
        Scanner lectorEntrada = new Scanner(System.in);
        ingresarJugadores();
        while (!salir) {
            System.out.println("Elija la opción que desea realizar");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Crear Mapa");
            System.out.println("3. Imprimir Mapa");
            System.out.println("4. Salir");

            opcion = lectorEntrada.next();
            System.out.println("");
            switch (opcion) {
                case "1":
                    Planeta[] hola1 = (mapas[0].getJugador1());
                    hola1[0].imprimirMapa();
                    Planeta[] hola2 = (mapas[0].getJugador2());
                    hola2[0].imprimirMapa();
                    break;
                case "2":
                    System.out.println("agregar mapa");
                    mapas = agregarMapa(mapas);
                    break;
                case "3":
                    System.out.println("Ingrese el indice del mapa a imprimir");
                    int indice = lectorEntrada.nextInt();
                    imprimirMapa(mapas[indice - 1]);
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion Incorrecta, por favor vuelva a elegir");
            }
        }

    }

    //Ingresar Jugadores, solo 2 jugadores
    public void ingresarJugadores() {
        Scanner lector = new Scanner(System.in);

        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Ingrese el nombre del Jugador No. " + (i + 1));
            String nombre = lector.next();
            System.out.println("");
            Planeta[] planetaJugador = new Planeta[1];
            jugadores[i] = new Jugador(nombre, 0, 0, planetaJugador, "J" + (i + 1));
        }
    }

    //Agregar un mapa y crearlo
    public static Mapa[] agregarMapa(Mapa mapas[]) {
        System.out.println("hola");
        int filas = 0, columnas = 0;
        Scanner lector = new Scanner(System.in);
        while (filas <= 0) {
            System.out.println("Ingrese el numero de filas----");
            filas = lector.nextInt();
            if (filas <= 0) {
                System.out.println("El numero de filas es invalido\n");
                System.out.println("Por favor, intenetelo de nuevo");
            }

        }
        while (columnas <= 0) {
            System.out.println("Ingrese el numero de columnas | | | |");
            columnas = lector.nextInt();
            if (columnas <= 0) {
                System.out.println("El numero de columnas es ivalido");
                System.out.println("Por favor, intenetelo de nuevo");
            }
        }
        Planeta[][] mapa = new Planeta[filas][columnas];
        Mapa mapaAgregar = new Mapa(mapa, filas, columnas);
        boolean valido = false;
        int planetasAgregar = 0;
        while (!valido) {
            System.out.println("Cuantos Planetas desea agregar");
            planetasAgregar = lector.nextInt();
            if ((0 < planetasAgregar) && (planetasAgregar <= ((filas * columnas) - 2))) {
                valido = true;
            } else {
                System.out.println("El numero es invalido");
            }
        }

        System.out.println("Desea agregarlos manualmente");
        System.out.println("1. Si \n2. No");
        String eleccion = lector.next();
        if (eleccion.equals("1")) {
            mapaAgregar = agregarPlanetaManual(mapaAgregar, planetasAgregar);
        } else if (eleccion.equals("2")) {
            mapaAgregar = agregarPlanetafAletoriamente(mapaAgregar, planetasAgregar);
        }
        if (mapas[0] == null) {
            mapas[0] = mapaAgregar;
        } else {
            Mapa aux[] = new Mapa[mapas.length + 1];
            for (int i = 0; i < mapas.length; i++) {
                aux[i] = mapas[i];
            }
            aux[mapas.length] = mapaAgregar;
            mapas = aux;
        }
        return mapas;
    }

    public static Mapa agregarPlanetafAletoriamente(Mapa mapa, int planetasAgregar) {
        Mapa mapaRetorna = mapa;
        Planeta[][] mapaRetornar = mapaRetorna.getMapa();
        for (int i = 0; i < jugadores.length; i++) {
            boolean agregado = false;
            while (!agregado) {
                int k = generaNumeroAleatorio(0, (mapa.getFilas() - 1));
                int j = generaNumeroAleatorio(0, (mapa.getColumnas() - 1));
                if (mapaRetornar[k][j] == null) {
                    mapaRetornar[k][j] = tipoPlaneta();
                    if (i == 0) {
                        Planeta[] jugador1 = new Planeta[1];
                        jugador1[0] = mapaRetornar[k][j];
                        mapaRetorna.setJugador1(jugador1);
                    } else if (i == 1) {
                        Planeta[] jugador2 = new Planeta[1];
                        jugador2[0] = mapaRetornar[k][j];
                        mapaRetorna.setJugador2(jugador2);
                    }
                    mapaRetornar[k][j].setDueno(jugadores[i].getNumeroJugador());
                    agregado = true;
                }
            }
        }
        for (int i = 0; i < planetasAgregar; i++) {
            boolean agregado = false;
            while (!agregado) {
                int k = generaNumeroAleatorio(0, (mapa.getFilas() - 1));
                int j = generaNumeroAleatorio(0, (mapa.getColumnas() - 1));
                if (mapaRetornar[k][j] == null) {
                    mapaRetornar[k][j] = tipoPlaneta();
                    agregado = true;
                }
            }
        }
        mapaRetorna.setMapa(mapaRetornar);
        return mapaRetorna;
    }

    public static Planeta tipoPlaneta() {
        int tipoPlaneta = generaNumeroAleatorio(0, (PROBABILIBAD_DISTRIBUCION_TIERRA + PROBABILIBAD_DISTRIBUCION_AGUA
                + PROBABILIBAD_DISTRIBUCION_FUEGO + PROBABILIBAD_DISTRIBUCION_ORGANICO
                + PROBABILIBAD_DISTRIBUCION_RADIOACTI));
        Planeta planeta = null;
        if ((0 <= tipoPlaneta)
                && (tipoPlaneta < PROBABILIBAD_DISTRIBUCION_TIERRA)) {
            planeta = new Tierra(valorMuerte());
        } else if (PROBABILIBAD_DISTRIBUCION_TIERRA <= tipoPlaneta && tipoPlaneta
                < (PROBABILIBAD_DISTRIBUCION_TIERRA + PROBABILIBAD_DISTRIBUCION_AGUA)) {
            planeta = new Agua(valorMuerte());
        } else if ((PROBABILIBAD_DISTRIBUCION_TIERRA + PROBABILIBAD_DISTRIBUCION_AGUA) <= tipoPlaneta
                && (tipoPlaneta < (PROBABILIBAD_DISTRIBUCION_TIERRA + PROBABILIBAD_DISTRIBUCION_AGUA
                + PROBABILIBAD_DISTRIBUCION_FUEGO))) {
            planeta = new Fuego(valorMuerte());

        } else if ((tipoPlaneta <= (PROBABILIBAD_DISTRIBUCION_TIERRA + PROBABILIBAD_DISTRIBUCION_AGUA
                + PROBABILIBAD_DISTRIBUCION_FUEGO)) && (tipoPlaneta < (PROBABILIBAD_DISTRIBUCION_TIERRA
                + PROBABILIBAD_DISTRIBUCION_AGUA + PROBABILIBAD_DISTRIBUCION_FUEGO
                + PROBABILIBAD_DISTRIBUCION_ORGANICO))) {
            planeta = new Organico(valorMuerte());
        } else if ((tipoPlaneta <= (PROBABILIBAD_DISTRIBUCION_TIERRA + PROBABILIBAD_DISTRIBUCION_AGUA
                + PROBABILIBAD_DISTRIBUCION_FUEGO + PROBABILIBAD_DISTRIBUCION_ORGANICO))
                && (tipoPlaneta < (PROBABILIBAD_DISTRIBUCION_TIERRA + PROBABILIBAD_DISTRIBUCION_AGUA
                + PROBABILIBAD_DISTRIBUCION_FUEGO + PROBABILIBAD_DISTRIBUCION_ORGANICO
                + PROBABILIBAD_DISTRIBUCION_RADIOACTI))) {
            planeta = new Radioactivo(valorMuerte());
        }
        return planeta;
    }

    public static Mapa agregarPlanetaManual(Mapa mapa, int planetasAgregar) {
        Scanner lector = new Scanner(System.in);
        Mapa mapaRetorna = mapa;
        Planeta[][] mapaRetornar = mapaRetorna.getMapa();
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Ingresa el planeta del jugador No. " + (i + 1));
            System.out.println("Desea especificar los valores?\n1. Si"
                    + " \n2. No, usar valores predeterminados");
            String eleccionEspecificar = lector.next();
            if (eleccionEspecificar.equals("1")) {
                boolean agregado = false;
                while (!agregado) {
                    int k = pedirFila(mapaRetorna.getFilas());
                    int j = pedirColumna(mapaRetorna.getColumnas());
                    if (mapaRetornar[k][j] == null) {
                        mapaRetornar[k][j] = pedirPlanetaEspecificado(jugadores[i].getNombre());
                        if (i == 0) {
                            Planeta[] jugador1 = new Planeta[1];
                            jugador1[0] = mapaRetornar[k][j];
                            mapaRetorna.setJugador1(jugador1);
                        } else if (i == 1) {
                            Planeta[] jugador2 = new Planeta[1];
                            jugador2[0] = mapaRetornar[k][j];
                            mapaRetorna.setJugador2(jugador2);
                        }
                        mapaRetornar[k][j].setDueno(jugadores[i].getNumeroJugador());
                        agregado = true;
                    }
                }
            } else if (eleccionEspecificar.equals("2")) {
                boolean agregado = false;
                while (!agregado) {
                    int k = pedirFila(mapaRetorna.getFilas());
                    int j = pedirColumna(mapaRetorna.getColumnas());
                    if (mapaRetornar[k][j] == null) {
                        mapaRetornar[k][j] = pedirPlaneta();
                        if (i == 0) {
                            Planeta[] jugador1 = new Planeta[1];
                            jugador1[0] = mapaRetornar[k][j];
                            mapaRetorna.setJugador1(jugador1);
                        } else if (i == 1) {
                            Planeta[] jugador2 = new Planeta[1];
                            jugador2[0] = mapaRetornar[k][j];
                            mapaRetorna.setJugador2(jugador2);
                        }
                        mapaRetornar[k][j].setDueno(jugadores[i].getNumeroJugador());
                        agregado = true;
                    } else {
                        System.out.println("Espacio ocupado, ingrese de nuevo el planeta");
                    }
                }
            }

        }
        for (int i = 0; i < planetasAgregar; i++) {
            System.out.println("Ingreso de Planeta Neutral No. " + (i + 1));
            boolean agregado = false;
            while (!agregado) {
                int k = pedirFila(mapaRetorna.getFilas());
                int j = pedirColumna(mapaRetorna.getColumnas());
                if (mapaRetornar[k][j] == null) {
                    mapaRetornar[k][j] = pedirPlaneta();
                    agregado = true;
                } else {
                    System.out.println("Espacio ocupado, ingrese de nuevo el planeta");
                }
            }
        }
        return mapaRetorna;
    }

    public static int pedirFila(int limiteFila) {
        Scanner lector = new Scanner(System.in);
        int fila = 0;
        boolean filaValida = false;
        while (!filaValida) {
            System.out.println("Ingresa la fila");
            fila = lector.nextInt();
            if ((0 < fila) && (fila < limiteFila)) {
                filaValida = true;
            }
        }
        return fila;
    }

    public static int pedirColumna(int limiteColumna) {
        Scanner lector = new Scanner(System.in);
        int columna = 0;
        boolean columnaValida = false;
        while (!columnaValida) {
            System.out.println("Ingresa la Columna");
            columna = lector.nextInt();
            if ((0 < columna) && (columna < limiteColumna)) {
                columnaValida = true;
            }
        }
        return columna;
    }

    public static Planeta pedirPlanetaEspecificado(String nombreDueno) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingresa el nombre del Planeta");
        String nombrePlaneta = lector.next();
        System.out.println("Ingrese el porcentaje de muerte");
        int porcentajeMuerte = lector.nextInt();

        Planeta planetaEpecifico = new Planeta(nombrePlaneta, "Nemo",
                nombreDueno, porcentajeMuerte);
        return planetaEpecifico;
    }

    public static Planeta pedirPlaneta() {
        Scanner lector = new Scanner(System.in);

        boolean completado = false;
        Planeta planeta = null;

        while (!completado) {
            System.out.println("Ingrese el tipo de planeta que desea agreagar");
            System.out.println("1. Tierra");
            System.out.println("2. Agua");
            System.out.println("3. Fuego");
            System.out.println("4. Organico");
            System.out.println("5. Radioactivo");
            String tipoPlaneta = lector.next();
            switch (tipoPlaneta) {
                case "1":
                    planeta = new Tierra(valorMuerte());
                    completado = true;
                    break;
                case "2":
                    planeta = new Agua(valorMuerte());
                    completado = true;
                    break;
                case "3":
                    planeta = new Fuego(valorMuerte());
                    completado = true;
                    break;
                case "4":
                    planeta = new Organico(valorMuerte());
                    completado = true;
                    break;
                case "5":
                    planeta = new Radioactivo(valorMuerte());
                    completado = true;
                    break;
                default:
                    System.out.println("Numero equivocado, ingrese de nuevo");
            }
        }
        return planeta;
    }

    //ImprimirMapa
    public static void imprimirMapa(Mapa mapa) {
        Planeta[][] mapaImprimir = (mapa.getMapa());
        for (int k = 0; k < mapa.getColumnas(); k++) {
            System.out.print("     " + (k + 1) + "    ");
        }
        System.out.println("");
        for (int i = 0; i < mapa.getFilas(); i++) {
            for (int j = 0; j < mapa.getColumnas(); j++) {
                if (j == 0) {
                    System.out.print((i + 1) + "");
                }
                if (mapaImprimir[i][j] == null) {
                    System.out.print("|        |");
                } else {
                    mapaImprimir[i][j].imprimirMapa();
                }
                if (j == (mapa.getColumnas() - 1)) {
                    System.out.println("");
                }
            }
            System.out.println("");
        }

    }

    public static int valorMuerte() {
        return generaNumeroAleatorio(1, 9999);
    }

    //Genera un numero aleatorio entre un rango
    public static int generaNumeroAleatorio(int minimo, int maximo) {
        int numero = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return numero;
    }

}
