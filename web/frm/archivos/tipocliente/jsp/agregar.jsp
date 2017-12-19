

<%@page import="org.json.simple.JSONObject"%>
<%@page import="hotel.controlador.TipoClientesControlador"%>
<%@page import="hotel.modelo.TipoClientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id_tipocliente=Integer.parseInt(request.getParameter("id_tipocliente"));
    String nombre_tipocliente=request.getParameter("nombre_tipocliente");
    TipoClientes tipocliente=new TipoClientes();
    tipocliente.setId_tipocliente(id_tipocliente);
    tipocliente.setNombre_tipocliente(nombre_tipocliente);
    String mensaje="Datos no Agregados";
    if(TipoClientesControlador.agregar(tipocliente)){
        mensaje="Datos agregados correctamente";
    };
    JSONObject obj=new JSONObject();
    obj.put("mensaje",String.valueOf(mensaje));
    out.print(obj);
    out.flush();
    %>
