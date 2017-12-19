

<%@page import="hotel.controlador.TipoClientesControlador"%>
<%@page import="hotel.modelo.TipoClientes"%>
<%@page import="org.json.simple.JSONObject" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id_tipocliente=Integer.parseInt(request.getParameter("id_tipocliente"));
    
    String tipo="error";
        String mensaje="Datos no eliminados";
        
    TipoClientes tipocliente=new TipoClientes();
    tipocliente.setId_tipocliente(id_tipocliente);
   
  
    if(TipoClientesControlador.eliminar(tipocliente)){
        tipo="success";
        mensaje="Datos eliminados correctamente";
    };
    JSONObject obj=new JSONObject();
    obj.put("tipo",tipo);
    obj.put("mensaje",String.valueOf(mensaje));
    out.print(obj);
    out.flush();
    %>
