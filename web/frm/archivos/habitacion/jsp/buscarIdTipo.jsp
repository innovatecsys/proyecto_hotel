


<%@page import="hotel.controlador.TipoHabitacionesControlador"%>
<%@page import="hotel.modelo.TipoHabitaciones"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
  
    int id_tipohabitacion = 0;
    if (request.getParameter("id_tipohabitacion") != "") {
        id_tipohabitacion = Integer.parseInt(request.getParameter("id_tipohabitacion"));
    }
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    TipoHabitaciones tipohabitacion = new TipoHabitaciones();
    tipohabitacion.setId_tipohabitacion(id_tipohabitacion);

    tipohabitacion = TipoHabitacionesControlador.buscarId(tipohabitacion);
    if (tipohabitacion.getId_tipohabitacion() != 0) {
        tipo = "success";
        mensaje = "Datos encontrados";
        nuevo = "false";
    }
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);


    obj.put("id_tipohabitacion",tipohabitacion.getId_tipohabitacion());
    obj.put("nombre_tipohabitacion",tipohabitacion.getNombre_tipohabitacion());
    out.print(obj);
    out.flush();
%>
