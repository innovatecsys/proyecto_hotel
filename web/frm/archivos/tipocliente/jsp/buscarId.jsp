


<%@page import="hotel.controlador.TipoClientesControlador"%>
<%@page import="hotel.modelo.TipoClientes"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.ResultSet"%>
<%
  
    int id_tipocliente = 0;
    if (request.getParameter("id_tipocliente") != "") {
        id_tipocliente = Integer.parseInt(request.getParameter("id_tipocliente"));
    }
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    TipoClientes tipocliente = new TipoClientes();
    tipocliente.setId_tipocliente(id_tipocliente);

    tipocliente = TipoClientesControlador.buscarId(tipocliente);
    if (tipocliente.getId_tipocliente() != 0) {
        tipo = "success";
        mensaje = "Datos encontrados";
        nuevo = "false";
    }
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);


    obj.put("id_tipocliente",tipocliente.getId_tipocliente());
    obj.put("nombre_tipocliente",tipocliente.getNombre_tipocliente());
    out.print(obj);
    out.flush();
%>
