
<%@page import="hotel.controlador.HabitacionesControlador"%>
<%@page import="hotel.modelo.Habitaciones"%>
<%@page import="org.json.simple.JSONObject"%>

<%
    
   
    int id_habitacion = 0;
    if (request.getParameter("id_habitacion") != "") {
        id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));
    }
    String tipo = "error";
    String mensaje = "Datos no encontrados.";
    String nuevo = "true";
    Habitaciones habitacion = new Habitaciones();
   
    
    habitacion.setId_habitacion(id_habitacion);
    

    habitacion = HabitacionesControlador.buscarId(habitacion);
    if (habitacion.getId_habitacion() != 0) {
        tipo = "success";
        mensaje = "Datos encontrados";
        nuevo = "false";
    }
 
    
    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", mensaje);
    obj.put("nuevo", nuevo);

    obj.put("id_habitacion", habitacion.getId_habitacion());
    obj.put("nombre_habitacion", habitacion.getNombre_habitacion());
    obj.put("costo_habitacion", habitacion.getCosto_habitacion());
    obj.put("minadulto_habitacion", habitacion.getMinadulto_habitacion());
    obj.put("maxadulto_habitacion", habitacion.getMaxadulto_habitacion());
    obj.put("id_tipohabitacion", habitacion.getTipohabitacion().getId_tipohabitacion());
    obj.put("nombre_tipohabitacion", habitacion.getTipohabitacion().getNombre_tipohabitacion());
    obj.put("obs_habitacion", habitacion.getObs_habitacion());
   
    out.print(obj);
    out.flush();
%>