



<%@page import="org.json.simple.JSONObject"%>
<%@page import="hotel.controlador.TipoHabitacionesControlador"%>
<%@page import="java.sql.ResultSet"%>
<%
    String nombre_tipohabitacion=request.getParameter("bnombre_tipohabitacion");
    int pagina=Integer.parseInt(request.getParameter("bpagina"));
    
    String mensaje="Busqueda exitosa";
    String contenido=TipoHabitacionesControlador.buscarNombre(nombre_tipohabitacion,pagina);
    JSONObject obj=new JSONObject();
    obj.put("mensaje",mensaje);
    obj.put("contenido",contenido);
    out.print(obj);
    out.flush();
%>
