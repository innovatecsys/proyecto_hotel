/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.modelo;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class Clientes {
 
    private int id_cliente;
    private String nombre_cliente;
    private int ruc_cliente;
    private int dv_cliente;
    private int ci_cliente;
    private String telmov_cliente;
    private String telfijo_cliente;
    private String tellaboral_cliente;
    private String direccion_cliente;
    private String email_cliente;
    private String web_cliente;
    private Ciudades ciudad;
    private TipoClientes tipocliente;
    private Date nacimiento_cliente;

    public Clientes() {
    }

    public Clientes(int id_cliente, String nombre_cliente, int ruc_cliente, int dv_cliente, int ci_cliente, String telmov_cliente, String telfijo_cliente, String tellaboral_cliente, String direccion_cliente, String email_cliente, String web_cliente, Ciudades ciudad, TipoClientes tipocliente, Date nacimiento_cliente) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.ruc_cliente = ruc_cliente;
        this.dv_cliente = dv_cliente;
        this.ci_cliente = ci_cliente;
        this.telmov_cliente = telmov_cliente;
        this.telfijo_cliente = telfijo_cliente;
        this.tellaboral_cliente = tellaboral_cliente;
        this.direccion_cliente = direccion_cliente;
        this.email_cliente = email_cliente;
        this.web_cliente = web_cliente;
        this.ciudad = ciudad;
        this.tipocliente = tipocliente;
        this.nacimiento_cliente = nacimiento_cliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getRuc_cliente() {
        return ruc_cliente;
    }

    public void setRuc_cliente(int ruc_cliente) {
        this.ruc_cliente = ruc_cliente;
    }

    public int getDv_cliente() {
        return dv_cliente;
    }

    public void setDv_cliente(int dv_cliente) {
        this.dv_cliente = dv_cliente;
    }

    public int getCi_cliente() {
        return ci_cliente;
    }

    public void setCi_cliente(int ci_cliente) {
        this.ci_cliente = ci_cliente;
    }

    public String getTelmov_cliente() {
        return telmov_cliente;
    }

    public void setTelmov_cliente(String telmov_cliente) {
        this.telmov_cliente = telmov_cliente;
    }

    public String getTelfijo_cliente() {
        return telfijo_cliente;
    }

    public void setTelfijo_cliente(String telfijo_cliente) {
        this.telfijo_cliente = telfijo_cliente;
    }

    public String getTellaboral_cliente() {
        return tellaboral_cliente;
    }

    public void setTellaboral_cliente(String tellaboral_cliente) {
        this.tellaboral_cliente = tellaboral_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getWeb_cliente() {
        return web_cliente;
    }

    public void setWeb_cliente(String web_cliente) {
        this.web_cliente = web_cliente;
    }

    public Ciudades getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudades ciudad) {
        this.ciudad = ciudad;
    }

    public TipoClientes getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(TipoClientes tipocliente) {
        this.tipocliente = tipocliente;
    }

    public Date getNacimiento_cliente() {
        return nacimiento_cliente;
    }

    public void setNacimiento_cliente(Date nacimiento_cliente) {
        this.nacimiento_cliente = nacimiento_cliente;
    }
    

   

    
}
