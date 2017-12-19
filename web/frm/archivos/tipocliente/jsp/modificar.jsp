

<%@page import="hotel.controlador.TipoClientesControlador"%>
<%@page import="hotel.modelo.TipoClientes"%>
<%@page import="org.json.simple.JSONObject"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id_tipocliente=Integer.parseInt(request.getParameter("id_tipocliente"));
    String nombre_tipocliente=request.getParameter("nombre_tipocliente");
    
    String tipo="error";
    TipoClientes tipocliente=new TipoClientes();
    tipocliente.setId_tipocliente(id_tipocliente);
    tipocliente.setNombre_tipocliente(nombre_tipocliente);
    String mensaje="Datos no Modificados";
    if(TipoClientesControlador.modificar(tipocliente)){
        tipo="success";
        mensaje="Datos modificados correctamente";
    };
    JSONObject obj=new JSONObject();
    obj.put("tipo",tipo);
    obj.put("mensaje",String.valueOf(mensaje));
    out.print(obj);
    out.flush();
    %>
