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
public class Tierra extends Planeta {

    public Tierra(int porcentajeMuerte) {
        //nombre, tipoGuerrero
        super("Tierra", "Mole", null, porcentajeMuerte);
    }

    public Tierra(String dueno, int porcentajeMuerte) {
        super("Tierra", "Mole", dueno, porcentajeMuerte);
    }
}
