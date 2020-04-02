/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructor;
/**
 *
 * @author baquiax
 */
public class Constructor {
    private final String nombre;
    private final int tiempoConstruccion;
    private final int precioCompra;
    private final int precioVente;
    private final String naveConstruir;

    public Constructor(String nombre, int tiempoConstruccion, int precioCompra, int precioVente, String naveConstruir) {
        this.nombre = nombre;
        this.tiempoConstruccion = tiempoConstruccion;
        this.precioCompra = precioCompra;
        this.precioVente = precioVente;
        this.naveConstruir = naveConstruir;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoConstruccion() {
        return tiempoConstruccion;
    }

    public int getPrecioCompra() {
        return precioCompra;
    }

    public int getPrecioVente() {
        return precioVente;
    }

    public String getNaveConstruir() {
        return naveConstruir;
    }
    
}
