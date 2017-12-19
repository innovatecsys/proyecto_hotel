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
public class Departamentos {
    private int id_departamento;
    private String nombre_departamento;
    private Paises pais;

    public Departamentos() {
    }

    public Departamentos(int id_departamento, String nombre_departamento, Paises pais) {
        this.id_departamento = id_departamento;
        this.nombre_departamento = nombre_departamento;
        this.pais = pais;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }
    
    
}
