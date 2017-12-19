



<%@page import="org.json.simple.JSONObject"%>
<%@page import="hotel.controlador.TipoClientesControlador"%>
<%@page import="java.sql.ResultSet"%>
<%
    String nombre_tipocliente=request.getParameter("bnombre_tipocliente");
    int pagina=Integer.parseInt(request.getParameter("bpagina"));
    
    String mensaje="Busqueda exitosa";
    String contenido=TipoClientesControlador.buscarNombre(nombre_tipocliente,pagina);
    JSONObject obj=new JSONObject();
    obj.put("mensaje",mensaje);
    obj.put("contenido",contenido);
    out.print(obj);
    out.flush();
%>
