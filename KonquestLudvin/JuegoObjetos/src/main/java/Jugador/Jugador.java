/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugador;

import Planeta.Planeta;

/**
 *
 * @author baquiax
 */
public class Jugador {

    private final String nombre;
    private int puntos;
    private int dineroGalactus;
    private Planeta[] planetas;
    private final String numeroJugador;

    public Jugador(String nombre, int puntos, int dineroGalactus,
            Planeta[] planetas, String numeroJugador) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.dineroGalactus = dineroGalactus;
        this.planetas = planetas;
        this.numeroJugador = numeroJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getDineroGalactus() {
        return dineroGalactus;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setDineroGalactus(int dineroGalactus) {
        this.dineroGalactus = dineroGalactus;
    }

    public Planeta[] getPlanetas() {
        return planetas;
    }

    public void setPlanetas(Planeta[] planetas) {
        this.planetas = planetas;
    }

    @Override
    public String toString() {
        return "Jugador" + nombre + ", puntos: " + puntos + ", Galactus." + dineroGalactus;
    }

    public String getNumeroJugador() {
        return numeroJugador;
    }

    public void agregarPlaneta(Planeta planetaAgregar) {
        if (this.planetas[0] == null) {
            this.planetas[0] = planetaAgregar;
        } else {
            Planeta aux[] = new Planeta[(this.planetas).length + 1];
            for (int i = 0; i < (this.planetas).length; i++) {
                aux[i] = (this.planetas)[i];
            }
            aux[(this.planetas).length] = planetaAgregar;
            this.planetas = aux;
        }
    }
}
