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
public class Agua extends Planeta {

    public Agua(int porcentajeMuerte) {
        //nombre, tipoGuerrero,dueno
        super("Agua", "Nemo", null, porcentajeMuerte);
    }

    public Agua(String dueno, int porcentajeMuerte) {
        //nombre,  tipoGuerrero,dueno
        super("Agua", "Nemo", dueno, porcentajeMuerte);
    }
}
