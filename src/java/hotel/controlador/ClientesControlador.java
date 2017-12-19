/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.controlador;

import hotel.modelo.Ciudades;
import hotel.modelo.Clientes;
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
public class ClientesControlador {

    public static boolean agregar(Clientes cliente) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "insert into clientes(nombre_cliente,id_tipocliente,nacimiento_cliente,ruc_cliente,dv_cliente,ci_cliente,telmov_cliente,telfijo_cliente,tellaboral_cliente,direccion_cliente,email_cliente,web_cliente,id_ciudad) "
                    + "values('" + cliente.getNombre_cliente() + "','"
                    + cliente.getTipocliente().getId_tipocliente() + "','"
                    + cliente.getNacimiento_cliente() + "','"
                    + cliente.getRuc_cliente() + "','"
                    + cliente.getDv_cliente() + "','"
                    + cliente.getCi_cliente() + "','"
                    + cliente.getTelmov_cliente() + "','"
                    + cliente.getTelfijo_cliente() + "','"
                    + cliente.getTellaboral_cliente() + "','"
                    + cliente.getDireccion_cliente() + "','"
                    + cliente.getEmail_cliente() + "','"
                    + cliente.getWeb_cliente() + "','"
                    + cliente.getCiudad().getId_ciudad() + "')";

            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }

    public static Clientes buscarId(Clientes cliente) {
        if (Conexion.conectar()) {
            String sql = "select * from clientes c "
                    + " left join ciudades ci on ci.id_ciudad=c.id_ciudad  "
                    + " left join tipoclientes ti on ti.id_tipocliente=c.id_tipocliente  "
                    + " where id_cliente= '" + cliente.getId_cliente() + "'";

            System.out.println("sql" + sql);
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    cliente.setNombre_cliente(rs.getString("nombre_cliente"));
                    cliente.setNacimiento_cliente(rs.getDate("nacimiento_cliente"));

                    cliente.setRuc_cliente(rs.getInt("ruc_cliente"));
                    cliente.setDv_cliente(rs.getInt("dv_cliente"));
                    cliente.setDireccion_cliente(rs.getString("direccion_cliente"));

                    TipoClientes tipocliente = new TipoClientes();
                    tipocliente.setId_tipocliente(rs.getInt("id_tipocliente"));
                    tipocliente.setNombre_tipocliente(rs.getString("nombre_tipocliente"));
                    cliente.setTipocliente(tipocliente);

                    cliente.setCi_cliente(rs.getInt("ci_cliente"));
                    cliente.setTelmov_cliente(rs.getString("telmov_cliente"));
                    cliente.setTelfijo_cliente(rs.getString("telfijo_cliente"));
                    cliente.setTellaboral_cliente(rs.getString("tellaboral_cliente"));
                    cliente.setWeb_cliente(rs.getString("web_cliente"));
                    cliente.setEmail_cliente(rs.getString("email_cliente"));

                    Ciudades ciudad = new Ciudades();
                    ciudad.setId_ciudad(rs.getInt("id_ciudad"));
                    ciudad.setNombre_ciudad(rs.getString("nombre_ciudad"));
                    cliente.setCiudad(ciudad);

                } else {
                    cliente.setId_cliente(0);
                    cliente.setNombre_cliente("");
                    cliente.setRuc_cliente(0);
                    cliente.setDv_cliente(0);
                    java.sql.Date nacimiento_cliente = new java.sql.Date(new java.util.Date().getTime());
                    cliente.setNacimiento_cliente(nacimiento_cliente);

                    cliente.setCi_cliente(0);
                    cliente.setTelmov_cliente("");
                    cliente.setTelfijo_cliente("");
                    cliente.setTellaboral_cliente("");
                    cliente.setDireccion_cliente("");
                    cliente.setWeb_cliente("");
                    cliente.setEmail_cliente("");

                    TipoClientes tipocliente = new TipoClientes();
                    tipocliente.setId_tipocliente(1);
                    tipocliente.setNombre_tipocliente("Empresa");
                    cliente.setTipocliente(tipocliente);

                    Ciudades ciudad = new Ciudades();
                    ciudad.setId_ciudad(0);
                    ciudad.setNombre_ciudad("");
                    cliente.setCiudad(ciudad);

                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return cliente;
    }

    public static String buscarNombre(String nombre, int pagina) {
        int offset = (pagina - 1) * Utiles.REGISTROS_PAGINA;
        String valor = "";
        if (Conexion.conectar()) {
            try {
                String sql = "select * from clientes c "
                        + " left join ciudades ci on ci.id_ciudad=c.id_ciudad  "
                        + " left join tipoclientes ti on ti.id_tipocliente=c.id_tipocliente  "
                        + "where upper(c.nombre_cliente) like '%" + nombre.toUpperCase() + "%'"
                        + "order by c.id_cliente offset " + offset + "limit " + Utiles.REGISTROS_PAGINA;
                System.out.println("--->" + sql);
                try (PreparedStatement ps = Conexion.getConn().prepareStatement(sql)) {
                    ResultSet rs = ps.executeQuery();
                    String tabla = "";
                    while (rs.next()) {
                        tabla += "<tr>"
                                
                        
                                + "<td>" + rs.getInt("id_cliente") + "</td>"
                                
                                
                                + "<td>" + rs.getString("nombre_cliente") + "</td>"
                                + "<td>" + rs.getInt("ruc_cliente") +"-"+rs.getInt("dv_cliente") +"</td>"
                          
                               
                                + "<td>" + rs.getString("nombre_ciudad") + "</td>"
                               
                                + "</tr>";
                    }
                    if (tabla.equals("")) {
                        tabla = "<tr><td colspan=6>No existen registros...</td></tr>";
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

    public static boolean modificar(Clientes cliente) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "update clientes set nombre_cliente='" + cliente.getNombre_cliente()
                    + "',id_ciudad=" + cliente.getCiudad().getId_ciudad() + ""
                    + ",direccion_cliente='" + cliente.getDireccion_cliente() + ""
                    + "',ruc_cliente=" + cliente.getRuc_cliente() + ""
                    + ",ci_cliente=" + cliente.getCi_cliente() + ""
                    + ",telmov_cliente='" + cliente.getTelmov_cliente() + "'"
                    + ",telfijo_cliente='" + cliente.getTelfijo_cliente() + "'"
                    + ",tellaboral_cliente='" + cliente.getTellaboral_cliente() + "'"
                    + ",web_cliente='" + cliente.getWeb_cliente() + "'"
                    + ",email_cliente='" + cliente.getEmail_cliente() + ""
                    + "' where id_cliente=" + cliente.getId_cliente();
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

    public static boolean eliminar(Clientes cliente) {
        boolean valor = false;
        if (Conexion.conectar()) {
            String sql = "delete from clientes where id_cliente=" + cliente.getId_cliente();
            try {
                Conexion.getSt().executeUpdate(sql);
                valor = true;
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return valor;
    }

    public static Clientes buscarCedula(int id) {
        Clientes cliente = null;
        if (Conexion.conectar()) {
            String sql = "select* from clientes where ci_cliente='" + id + "'";

            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    cliente = new Clientes();
                    cliente.setCi_cliente(0);

                }

            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return cliente;
    }

    public static Clientes buscarVerificador(int id) {
        Clientes cliente = null;
        if (Conexion.conectar()) {

            String sql = "select procedimentodv(" + id + ") as digito";

            System.out.println("sql digito " + sql);
            try {
                ResultSet rs = Conexion.getSt().executeQuery(sql);
                if (rs.next()) {
                    cliente = new Clientes();

                    cliente.setDv_cliente(rs.getInt("digito"));

                } else {
                    cliente = new Clientes();
                    cliente.setDv_cliente(0);

                }
            } catch (SQLException ex) {
                System.err.println("Error:" + ex);
            }
        }
        return cliente;
    }

}
