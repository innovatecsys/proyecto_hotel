

<%@page import="hotel.controlador.TipoHabitacionesControlador"%>
<%@page import="hotel.modelo.TipoHabitaciones"%>
<%@page import="org.json.simple.JSONObject"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id_tipohabitacion=Integer.parseInt(request.getParameter("id_tipohabitacion"));
    String nombre_tipohabitacion=request.getParameter("nombre_tipohabitacion");
    
    String tipo="error";
    TipoHabitaciones tipohabitacion=new TipoHabitaciones();
    tipohabitacion.setId_tipohabitacion(id_tipohabitacion);
    tipohabitacion.setNombre_tipohabitacion(nombre_tipohabitacion);
    String mensaje="Datos no Modificados";
    if(TipoHabitacionesControlador.modificar(tipohabitacion)){
        tipo="success";
        mensaje="Datos modificados correctamente";
    };
    JSONObject obj=new JSONObject();
    obj.put("tipo",tipo);
    obj.put("mensaje",String.valueOf(mensaje));
    out.print(obj);
    out.flush();
    %>
