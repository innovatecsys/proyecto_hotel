


<%@page import="hotel.controlador.ClientesControlador"%>
<%@page import="hotel.modelo.Clientes"%>
<%@page import="org.json.simple.JSONObject"%>

<%
    int ci_cliente = 0;
    if (request.getParameter("ci_cliente") != "") {
        ci_cliente = Integer.parseInt(request.getParameter("ci_cliente"));
    }
    
    
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
   
    
    
    Clientes cliente = ClientesControlador.buscarCedula(ci_cliente);
    if (cliente!= null) {
    
        tipo = "success";
        mensaje = "cedula ya existe";
        nuevo = "false";
    }else{
        
         tipo = "success";
        mensaje = "Agregar Cedula";
        nuevo = "true";
        cliente=new Clientes();
        cliente.setCi_cliente(ci_cliente);
        
    }
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);

    
    obj.put("ci_cliente", cliente.getCi_cliente());
   
    out.print(obj);
    out.flush();
%>