

<%@page import="javawebts.controladores.HabitacionesControlador"%>
<%@page import="javawebts.modelos.Habitaciones"%>
<%@page import="org.json.simple.JSONObject"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));

    String tipo = "error";
    String mensaje = "Datos no eliminados";

    Habitaciones habitacion = new Habitaciones();
    habitacion.setId_habitacion(id_habitacion);
    
    if (HabitacionesControlador.eliminar(habitacion)) {
        tipo = "success";
        mensaje = "Datos eliminados correctamente";
    };

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", String.valueOf(mensaje));
    out.print(obj);
    out.flush();
%>
