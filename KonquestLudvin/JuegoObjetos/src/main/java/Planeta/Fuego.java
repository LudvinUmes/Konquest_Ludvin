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
public class Fuego extends Planeta {

    public Fuego(int porcentajeMuerte) {
        //nombre, tipoGuerrero
        super("Fuego", "Magma", null, porcentajeMuerte);
    }

    public Fuego(String dueno, int porcentajeMuerte) {
        //nombre, probalidadDistribucion, tipoGuerrero
        super("Fuego", "Magma", dueno, porcentajeMuerte);
    }

}
