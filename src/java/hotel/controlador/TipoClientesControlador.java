/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controlador;

import hotel.modelo.TipoClientes;
import hotel.utiles.Conexion;
import hotel.utiles.Utiles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Administrator
 */
public class TipoClientesControlador {

    public static boolean agregar(TipoClientes tipocliente) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into tipoclientes(nombre_tipocliente) "
                    + "values('" + tipocliente.getNombre_tipocliente() + "')";
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }

    public static TipoClientes buscarId(TipoClientes tipocliente) {
        if (Conexion.conectar()) {
            String sql = "select * from tipoclientes where id_tipocliente='" + tipocliente.getId_tipocliente() + "'";
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    tipocliente.setNombre_tipocliente(rs.getString("nombre_tipocliente"));
                } else {
                    tipocliente.setId_tipocliente(0);
                    tipocliente.setNombre_tipocliente("");
                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return tipocliente;
    }

    public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from tipoclientes where upper(nombre_tipocliente) like '%" + nombre.toUpperCase() + "%'"
                        + " order by id_tipocliente offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_tipocliente") + "</td>"
                                + "<td>" + rs.getString("nombre_tipocliente") + "</td>"
                                + "</tr>";
                    }
                    if (tabla.equals("")) {
                        tabla = "<tr><td colspan=2>No existen registros...</td></tr>";
                    }
                    ps.close();
                    valor = tabla;
                } catch (SQLException ex) {
                    System.err.println("Error:" + ex);
                }
                Conexion.cerrar();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        Conexion.cerrar();
        return valor;
    }
    
    public static boolean eliminar(TipoClientes tipocliente){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="delete from tipoclientes where id_tipocliente="+tipocliente.getId_tipocliente();
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }
    public static boolean modificar(TipoClientes tipocliente){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="update tipoclientes set nombre_tipocliente='"+tipocliente.getNombre_tipocliente()+"'"
                    +" where id_tipocliente="+tipocliente.getId_tipocliente();
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }

}
