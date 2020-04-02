/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guerreros;

/**
 *
 * @author baquiax
 */
public class Guerrero {
    private final String nombre;
    private final double factorDeMuerte;
    private final int espacioEnNave;

    public Guerrero(String nombre, double factorDeMuerte, int espacioEnNave) {
        this.nombre = nombre;
        this.factorDeMuerte = factorDeMuerte;
        this.espacioEnNave = espacioEnNave;
    }

    public String getNombre() {
        return nombre;
    }

    public double getFactorDeMuerte() {
        return factorDeMuerte;
    }

    public int getEspacioEnNave() {
        return espacioEnNave;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Factor De Muerte:" + factorDeMuerte + ", Espacio En Nave:" + espacioEnNave;
    }
    
    
}
