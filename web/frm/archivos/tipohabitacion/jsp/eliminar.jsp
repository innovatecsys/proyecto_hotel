

<%@page import="hotel.controlador.TipoHabitacionesControlador"%>
<%@page import="hotel.modelo.TipoHabitaciones"%>
<%@page import="org.json.simple.JSONObject" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id_tipohabitacion=Integer.parseInt(request.getParameter("id_tipohabitacion"));
    
    String tipo="error";
        String mensaje="Datos no eliminados";
        
    TipoHabitaciones tipohabitacion=new TipoHabitaciones();
    tipohabitacion.setId_tipohabitacion(id_tipohabitacion);
   
  
    if(TipoHabitacionesControlador.eliminar(tipohabitacion)){
        tipo="success";
        mensaje="Datos eliminados correctamente";
    };
    JSONObject obj=new JSONObject();
    obj.put("tipo",tipo);
    obj.put("mensaje",String.valueOf(mensaje));
    out.print(obj);
    out.flush();
    %>
