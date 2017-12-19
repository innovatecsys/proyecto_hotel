


<%@page import="hotel.modelo.TipoClientes"%>
<%@page import="hotel.utiles.Utiles"%>
<%@page import="hotel.controlador.ClientesControlador"%>
<%@page import="hotel.modelo.Ciudades"%>
<%@page import="hotel.modelo.Clientes"%>
<%@page import="org.json.simple.JSONObject"%>

<%
    int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
    String nombre_cliente = request.getParameter("nombre_cliente");
   
    int id_ciudad = Integer.parseInt(request.getParameter("id_ciudad"));
    String direccion_cliente = request.getParameter("direccion_cliente");
    int ruc_cliente = Integer.parseInt(request.getParameter("ruc_cliente"));
    int dv_cliente = Integer.parseInt(request.getParameter("dv_cliente"));
    int ci_cliente = Integer.parseInt(request.getParameter("ci_cliente"));
    int id_tipocliente = Integer.parseInt(request.getParameter("id_tipocliente"));
    
     String sfecha_nacimiento = request.getParameter("nacimiento_cliente");
    java.sql.Date nacimiento_cliente = Utiles.stringToSqlDate(sfecha_nacimiento);
    
    String telmov_cliente = request.getParameter("telmov_cliente");
    String telfijo_cliente = request.getParameter("telfijo_cliente");
    String tellaboral_cliente = request.getParameter("tellaboral_cliente");
    String web_cliente = request.getParameter("web_cliente");
    String email_cliente = request.getParameter("email_cliente");
    
   // int telefono_cliente = Integer.parseInt(request.getParameter("telefono_cliente"));
    
    //String telefono_cliente = request.getParameter("telefono_cliente");
    
    
   
    String tipo = "error";
    String mensaje = "Datos no agregados.";
    
    Clientes cliente = new Clientes();
    cliente.setId_cliente(id_cliente);
    cliente.setNombre_cliente(nombre_cliente);
  
    cliente.setDireccion_cliente(direccion_cliente);
    cliente.setRuc_cliente(ruc_cliente);
    cliente.setDv_cliente(dv_cliente);
    cliente.setCi_cliente(ci_cliente);
    cliente.setTelmov_cliente(telmov_cliente);
    cliente.setNacimiento_cliente(nacimiento_cliente);
    cliente.setEmail_cliente(email_cliente);
    cliente.setTelfijo_cliente(telfijo_cliente);
    cliente.setTellaboral_cliente(tellaboral_cliente);
    cliente.setWeb_cliente(web_cliente);
   
    TipoClientes tipocliente =new TipoClientes();
    tipocliente.setId_tipocliente(id_tipocliente);
    cliente.setTipocliente(tipocliente);
    
    Ciudades ciudad = new Ciudades();
    ciudad.setId_ciudad(id_ciudad);
    cliente.setCiudad(ciudad);
    
    if (ClientesControlador.agregar(cliente)) {
        tipo = "success";
        mensaje = "Datos agregados";
    }
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    out.print(obj);
    out.flush();
%>