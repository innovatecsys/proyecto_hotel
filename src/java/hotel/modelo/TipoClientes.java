/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.modelo;

/**
 *
 * @author Administrator
 */
public class TipoClientes {
    
    private int id_tipocliente;
    private String nombre_tipocliente;

    public TipoClientes() {
    }

    public TipoClientes(int id_tipocliente, String nombre_tipocliente) {
        this.id_tipocliente = id_tipocliente;
        this.nombre_tipocliente = nombre_tipocliente;
    }

    public int getId_tipocliente() {
        return id_tipocliente;
    }

    public void setId_tipocliente(int id_tipocliente) {
        this.id_tipocliente = id_tipocliente;
    }

    public String getNombre_tipocliente() {
        return nombre_tipocliente;
    }

    public void setNombre_tipocliente(String nombre_tipocliente) {
        this.nombre_tipocliente = nombre_tipocliente;
    }
    
    
    
}
