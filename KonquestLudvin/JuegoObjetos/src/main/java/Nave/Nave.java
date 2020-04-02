/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nave;

/**
 *
 * @author baquiax
 */
public class Nave {
    private final String nombre;
    private final int capacidad;
    private final double velocidad;
    private final int costoProducion;

    public Nave(String nombre, int capacidad, double velocidad, int costoProducion) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.velocidad = velocidad;
        this.costoProducion = costoProducion;
    }

}
