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
public class Organico extends Planeta {

    public Organico(int porcentajeMuerte) {
        //nombre, tipoGuerrero
        super("Organico", "Groot", null, porcentajeMuerte);
    }

    public Organico(String dueno, int porcentajeMuerte) {
        //nombre, tipoGuerrero
        super("Organico", "Groot", dueno, porcentajeMuerte);
    }

}
