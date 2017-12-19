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
public class TipoHabitaciones {
    private int id_tipohabitacion;
    private String nombre_tipohabitacion;

    public TipoHabitaciones() {
    }

    public TipoHabitaciones(int id_tipohabitacion, String nombre_tipohabitacion) {
        this.id_tipohabitacion = id_tipohabitacion;
        this.nombre_tipohabitacion = nombre_tipohabitacion;
    }

    public int getId_tipohabitacion() {
        return id_tipohabitacion;
    }

    public void setId_tipohabitacion(int id_tipohabitacion) {
        this.id_tipohabitacion = id_tipohabitacion;
    }

    public String getNombre_tipohabitacion() {
        return nombre_tipohabitacion;
    }

    public void setNombre_tipohabitacion(String nombre_tipohabitacion) {
        this.nombre_tipohabitacion = nombre_tipohabitacion;
    }
    
    
}
