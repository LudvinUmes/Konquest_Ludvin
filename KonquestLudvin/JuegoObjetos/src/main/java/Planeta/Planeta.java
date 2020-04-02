/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planeta;

/**
 *
 * @author baquiax
 */
public class Planeta {

    //Reset
    public final String ANSI_RESET = "\u001B[0m";
    //Colores de fondo
    public final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private final String nombre;
    private final String tipoGuerrero;
    private String dueno;
    private int cantidadDienero; //Metodo
    private int guerrerosTurno; //metodo
    private final int porcentajeMuerte; //metodo

    /**
     * Constructor
     *
     * @param nombre nombre del planeta
     * @param tipoGuerrero El guerrero que el planeta puede generar
     * @param dueno Esto puede ser el nombre de un jugador, o neutro
     * @param porcentajeMuerte
     */
    public Planeta(String nombre, String tipoGuerrero, String dueno, int porcentajeMuerte) {
        this.nombre = nombre;
        this.tipoGuerrero = tipoGuerrero;
        this.dueno = dueno;
        this.porcentajeMuerte = porcentajeMuerte;
    }

    @Override
    public String toString() {
        return "Planeta" + "Nombre:" + nombre
                + "\n ,Tipo Guerrero:" + tipoGuerrero + ", Dueno: " + dueno + ", Cantidad Dienero:" + cantidadDienero + ","
                + "\n Guerreros Turno: " + guerrerosTurno + ", Porcentaje Muerte: " + porcentajeMuerte;
    }

    //Getters y seters
    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public void setCantidadDienero(int cantidadDienero) {
        this.cantidadDienero = cantidadDienero;
    }

    public void setGuerrerosTurno(int guerrerosTurno) {
        this.guerrerosTurno = guerrerosTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoGuerrero() {
        return tipoGuerrero;
    }

    public String getDueno() {
        return dueno;
    }

    public int getCantidadDienero() {
        return cantidadDienero;
    }

    public int getGuerrerosTurno() {
        return guerrerosTurno;
    }

    public int getPorcentajeMuerte() {
        return porcentajeMuerte;
    }
    
    //metodo para imprimirse en el mapa
    public void imprimirMapa() {
        if (dueno == null) {
            System.out.print(ANSI_GREEN_BACKGROUND + "|neutro  |" + ANSI_RESET);
        } else if (dueno.equals("J1")) {
            System.out.print(ANSI_CYAN_BACKGROUND + "|" + dueno + "      |" + ANSI_RESET);
        } else if (dueno.equalsIgnoreCase("J2")) {
            System.out.print(ANSI_YELLOW_BACKGROUND + "|" + dueno + "      |" + ANSI_RESET);
        }
    }
}
