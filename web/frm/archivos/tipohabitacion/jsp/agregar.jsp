

<%@page import="org.json.simple.JSONObject"%>
<%@page import="hotel.controlador.TipoHabitacionesControlador"%>
<%@page import="hotel.modelo.TipoHabitaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id_tipohabitacion=Integer.parseInt(request.getParameter("id_tipohabitacion"));
    String nombre_tipohabitacion=request.getParameter("nombre_tipohabitacion");
    TipoHabitaciones tipohabitacion=new TipoHabitaciones();
    tipohabitacion.setId_tipohabitacion(id_tipohabitacion);
    tipohabitacion.setNombre_tipohabitacion(nombre_tipohabitacion);
    String mensaje="Datos no Agregados";
    if(TipoHabitacionesControlador.agregar(tipohabitacion)){
        mensaje="Datos agregados correctamente";
    };
    JSONObject obj=new JSONObject();
    obj.put("mensaje",String.valueOf(mensaje));
    out.print(obj);
    out.flush();
    %>
