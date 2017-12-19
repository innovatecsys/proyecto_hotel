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
public class Habitaciones {
    
    private int id_habitacion;
    private String nombre_habitacion;
    private TipoHabitaciones tipohabitacion;
    private int minadulto_habitacion;
    private String obs_habitacion;
    private int maxadulto_habitacion;
    private int costo_habitacion;

    public Habitaciones() {
    }

    public Habitaciones(int id_habitacion, String nombre_habitacion, TipoHabitaciones tipohabitacion, int minadulto_habitacion, String obs_habitacion, int maxadulto_habitacion, int costo_habitacion) {
        this.id_habitacion = id_habitacion;
        this.nombre_habitacion = nombre_habitacion;
        this.tipohabitacion = tipohabitacion;
        this.minadulto_habitacion = minadulto_habitacion;
        this.obs_habitacion = obs_habitacion;
        this.maxadulto_habitacion = maxadulto_habitacion;
        this.costo_habitacion = costo_habitacion;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getNombre_habitacion() {
        return nombre_habitacion;
    }

    public void setNombre_habitacion(String nombre_habitacion) {
        this.nombre_habitacion = nombre_habitacion;
    }

    public TipoHabitaciones getTipohabitacion() {
        return tipohabitacion;
    }

    public void setTipohabitacion(TipoHabitaciones tipohabitacion) {
        this.tipohabitacion = tipohabitacion;
    }

    public int getMinadulto_habitacion() {
        return minadulto_habitacion;
    }

    public void setMinadulto_habitacion(int minadulto_habitacion) {
        this.minadulto_habitacion = minadulto_habitacion;
    }

    public String getObs_habitacion() {
        return obs_habitacion;
    }

    public void setObs_habitacion(String obs_habitacion) {
        this.obs_habitacion = obs_habitacion;
    }

    public int getMaxadulto_habitacion() {
        return maxadulto_habitacion;
    }

    public void setMaxadulto_habitacion(int maxadulto_habitacion) {
        this.maxadulto_habitacion = maxadulto_habitacion;
    }

    public int getCosto_habitacion() {
        return costo_habitacion;
    }

    public void setCosto_habitacion(int costo_habitacion) {
        this.costo_habitacion = costo_habitacion;
    }
    
    
    
    
}
