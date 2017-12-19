

<%@page import="hotel.controlador.ClientesControlador"%>
<%@page import="hotel.modelo.Clientes"%>
<%@page import="org.json.simple.JSONObject"%>

<%
    int id_cliente = 0;
    if (request.getParameter("id_cliente") != "") {
        id_cliente = Integer.parseInt(request.getParameter("id_cliente"));

    }
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    Clientes cliente = new Clientes();
    cliente.setId_cliente(id_cliente);

    cliente = ClientesControlador.buscarId(cliente);
    if (id_cliente != 0) {
        tipo = "success";
        mensaje = "Datos encontrados";
        nuevo = "false";
    }
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);

    obj.put("id_cliente", cliente.getId_cliente());
    obj.put("nombre_cliente", cliente.getNombre_cliente());
    obj.put("nacimiento_cliente", String.valueOf(cliente.getNacimiento_cliente()));
    obj.put("email_cliente", cliente.getEmail_cliente());
    obj.put("web_cliente", cliente.getWeb_cliente());
    obj.put("id_ciudad", cliente.getCiudad().getId_ciudad());
    obj.put("nombre_ciudad", cliente.getCiudad().getNombre_ciudad());
    obj.put("id_tipocliente", cliente.getTipocliente().getId_tipocliente());
    obj.put("nombre_tipocliente", cliente.getTipocliente().getNombre_tipocliente());

    obj.put("ruc_cliente", cliente.getRuc_cliente());
    obj.put("dv_cliente", cliente.getDv_cliente());
    obj.put("ci_cliente", cliente.getCi_cliente());
    obj.put("tellaboral_cliente", cliente.getTellaboral_cliente());
    obj.put("telfijo_cliente", cliente.getTelfijo_cliente());
    obj.put("telmov_cliente", cliente.getTelmov_cliente());
    obj.put("direccion_cliente", cliente.getDireccion_cliente());
    

    out.print(obj);
    out.flush();
%>