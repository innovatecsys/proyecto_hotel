/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controlador;

import hotel.modelo.Habitaciones;
import hotel.modelo.TipoHabitaciones;
import hotel.utiles.Conexion;
import hotel.utiles.Utiles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class HabitacionesControlador {

    public static boolean agregar(Habitaciones habitacion) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into habitaciones(nombre_habitacion,id_tipohabitacion,minadulto_habitacion,obs_habitacion,maxadulto_habitacion,costo_habitacion) "
                    + "values('" + habitacion.getNombre_habitacion() + "','"
                    + habitacion.getTipohabitacion().getId_tipohabitacion() + "','"
                    + habitacion.getMinadulto_habitacion() + "','"
                    + habitacion.getObs_habitacion() + "','"
                    + habitacion.getMaxadulto_habitacion() + "','"
                    + habitacion.getCosto_habitacion() + "')";
            try {
                Conexion.getSt().executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
                ResultSet keyset = Conexion.getSt().getGeneratedKeys();
                if (keyset.next()) {
                    int id_habitacion = keyset.getInt(1);
                    habitacion.setId_habitacion(id_habitacion);

                }
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }

    public static Habitaciones buscarId(Habitaciones habitacion) {
        if (Conexion.conectar()) {
            String sql = "select * from habitaciones h, tipohabitaciones th  "
                    + " where h.id_tipohabitacion=th.id_tipohabitacion  and "
                    + "h.id_habitacion='" + habitacion.getId_habitacion() + "'";

            System.out.println("sql" + sql);
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    habitacion.setNombre_habitacion(rs.getString("nombre_habitacion"));
                    habitacion.setCosto_habitacion(rs.getInt("costo_habitacion"));
                    habitacion.setMaxadulto_habitacion(rs.getInt("maxadulto_habitacion"));
                    habitacion.setMinadulto_habitacion(rs.getInt("minadulto_habitacion"));
                    habitacion.setObs_habitacion(rs.getString("obs_habItacion"));

                    TipoHabitaciones tipohabitacion = new TipoHabitaciones();
                    tipohabitacion.setId_tipohabitacion(rs.getInt("id_tipohabitacion"));
                    tipohabitacion.setNombre_tipohabitacion(rs.getString("nombre_tipohabitacion"));
                    habitacion.setTipohabitacion(tipohabitacion);

                } else {
                    habitacion.setId_habitacion(0);
                    habitacion.setNombre_habitacion("");
                    habitacion.setCosto_habitacion(0);
                    habitacion.setMaxadulto_habitacion(0);
                    habitacion.setMinadulto_habitacion(0);
                    habitacion.setObs_habitacion("");
                    
                  

                    TipoHabitaciones tipohabitacion = new TipoHabitaciones();
                    tipohabitacion.setId_tipohabitacion(0);
                    tipohabitacion.setNombre_tipohabitacion("");
                    habitacion.setTipohabitacion(tipohabitacion);

                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return habitacion;

    }

    public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from habitaciones h "
                        + "left join tipohabitaciones th  on th.id_tipohabitacion=h.id_tipohabitacion "
                      
                     
                        + "where upper(h.nombre_habitacion) like '%" + nombre.toUpperCase() + "%'"
                        + "order by h.id_habitacion offset " + offset + "limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                + "<td>" + rs.getString("id_habitacion") + "</td>"
                                + "<td>" + rs.getString("nombre_habitacion") + "</td>"
                                + "<td>" + rs.getString("nombre_tipohabitacion") + "</td>"
                         
                             
                                + "</tr>";
                    }
                    if (tabla.equals("")) {
                        tabla = "<tr><td colspan=2>No existen registros...</td></tr>";
                    }
                    ps.close();
                    valor = tabla;
                } catch (SQLException ex) {
                    System.err.println("Error: " + ex);
                }
                Conexion.cerrar();
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
            }
        }
        Conexion.cerrar();
        return valor;
    }

    public static boolean modificar(Habitaciones habitacion) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update habitaciones set nombre_habitacion='" + habitacion.getNombre_habitacion()
                    + "',costo_habitacion='" + habitacion.getCosto_habitacion() + ""
                    + "',minadulto_habitacion='" +habitacion.getMinadulto_habitacion() + ""
                    + "',maxadulto_habitacion='" + habitacion.getMaxadulto_habitacion() + ""
                    + "',id_tipohabitacion='" + habitacion.getTipohabitacion().getId_tipohabitacion() + ""
                    + "',obs_habitacion='" + habitacion.getObs_habitacion() + ""
                
                    + "' where id_habitacion=" + habitacion.getId_habitacion();
            System.out.println(sql);
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }


    public static boolean eliminar(Habitaciones habitacion) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from habitaciones where id_habitacion=" + habitacion.getId_habitacion();
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }

}
