

<%@page import="hotel.controlador.HabitacionesControlador"%>
<%@page import="org.json.simple.JSONObject"%>

<%
    String nombre_habitacion = request.getParameter("bnombre_habitacion");
    int pagina = Integer.parseInt(request.getParameter("bpagina"));
    
 
    
    String mensaje = "Búsqueda exitosa.";
    String contenido = HabitacionesControlador.buscarNombre(nombre_habitacion, pagina );
    
    JSONObject obj = new JSONObject();
    obj.put("mensaje",mensaje);
    obj.put("contenido", contenido);
      System.out.println("--->" + contenido);
    out.println(obj);
    out.flush();
%>