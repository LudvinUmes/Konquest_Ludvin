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
public class Radioactivo extends Planeta {

    public Radioactivo(int porcentajeMuerte) {
        //nombre,  tipoGuerrero
        super("Radioactivo", "Fusion Guy", null, porcentajeMuerte);
    }

    public Radioactivo(String dueno, int porcentajeMuerte) {
        //nombre,  tipoGuerrero
        super("Radioactivo", "Fusion Guy", dueno, porcentajeMuerte);
    }

}
