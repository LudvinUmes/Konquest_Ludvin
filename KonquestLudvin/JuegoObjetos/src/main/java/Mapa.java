
import Planeta.Planeta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author baquiax
 */
public class Mapa {

    private Planeta[][] mapa;
    private final int filas;
    private final int columnas;
    private Planeta[] jugador1;
    private Planeta[] jugador2;

    //Constructor
    /**
     * Constructor
     *
     * @param mapa Matriz de mapas
     * @param filas la matriz es definida por filas
     * @param columnas la matriz es definida por columnas
     */
    public Mapa(Planeta[][] mapa, int filas, int columnas) {
        this.mapa = mapa;
        this.filas = filas;
        this.columnas = columnas;
    }

    //Geters y Seters
    public Planeta[][] getMapa() {
        return mapa;
    }

    public Planeta[] getJugador1() {
        return jugador1;
    }

    public Planeta[] getJugador2() {
        return jugador2;
    }

    public void setMapa(Planeta[][] mapa) {
        this.mapa = mapa;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setJugador1(Planeta[] jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(Planeta[] jugador2) {
        this.jugador2 = jugador2;
    }

}
