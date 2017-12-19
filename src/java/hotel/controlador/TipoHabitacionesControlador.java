/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controlador;

import hotel.modelo.TipoHabitaciones;
import hotel.utiles.Conexion;
import hotel.utiles.Utiles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Administrator
 */
public class TipoHabitacionesControlador {

    public static boolean agregar(TipoHabitaciones tipohabitacion) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into tipohabitaciones(nombre_tipohabitacion) "
                    + "values('" + tipohabitacion.getNombre_tipohabitacion() + "')";
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }

    public static TipoHabitaciones buscarId(TipoHabitaciones tipohabitacion) {
        if (Conexion.conectar()) {
            String sql = "select * from tipohabitaciones where id_tipohabitacion='" + tipohabitacion.getId_tipohabitacion() + "'";
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    tipohabitacion.setNombre_tipohabitacion(rs.getString("nombre_tipohabitacion"));
                } else {
                    tipohabitacion.setId_tipohabitacion(0);
                    tipohabitacion.setNombre_tipohabitacion("");
                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return tipohabitacion;
    }

    public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from tipohabitaciones where upper(nombre_tipohabitacion) like '%" + nombre.toUpperCase() + "%'"
                        + " order by id_tipohabitacion offset " + offset + " limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_tipohabitacion") + "</td>"
                                + "<td>" + rs.getString("nombre_tipohabitacion") + "</td>"
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
    
    public static boolean eliminar(TipoHabitaciones tipohabitacion){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="delete from tipohabitaciones where id_tipohabitacion="+tipohabitacion.getId_tipohabitacion();
            try{
                Conexion.getSt().executeUpdate(sql);
                valor=true;
            }catch(SQLException ex){
                System.err.println("Error:"+ex);
            }
        }
        return valor;
    }
    public static boolean modificar(TipoHabitaciones tipohabitacion){
        boolean valor=false;
        if(Conexion.conectar()){
            String sql="update tipohabitaciones set nombre_tipohabitacion='"+tipohabitacion.getNombre_tipohabitacion()+"'"
                    +" where id_tipohabitacion="+tipohabitacion.getId_tipohabitacion();
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
