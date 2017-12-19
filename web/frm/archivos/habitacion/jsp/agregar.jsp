
<%@page import="hotel.controlador.HabitacionesControlador"%>
<%@page import="hotel.modelo.TipoHabitaciones"%>
<%@page import="hotel.modelo.Habitaciones"%>
<%@page import="org.json.simple.JSONObject"%>

<%@page import="java.sql.ResultSet"%>
<%
    int id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));
    String nombre_habitacion = request.getParameter("nombre_habitacion");
    int costo_habitacion = Integer.parseInt(request.getParameter("costo_habitacion"));
    int minadulto_habitacion = Integer.parseInt(request.getParameter("minadulto_habitacion"));
    int maxadulto_habitacion = Integer.parseInt(request.getParameter("maxadulto_habitacion"));
     String obs_habitacion = request.getParameter("obs_habitacion");
    int id_tipohabitacion = Integer.parseInt(request.getParameter("id_tipohabitacion"));

String tipo = "error";
String mensaje = "Datos no agregados.";

TipoHabitaciones tipohabitacion=new TipoHabitaciones();
tipohabitacion.setId_tipohabitacion(id_tipohabitacion);


Habitaciones habitacion = new Habitaciones();
habitacion.setId_habitacion(id_habitacion);
habitacion.setNombre_habitacion(nombre_habitacion);
habitacion.setCosto_habitacion(costo_habitacion);
habitacion.setMaxadulto_habitacion(maxadulto_habitacion);
habitacion.setMinadulto_habitacion(minadulto_habitacion);
habitacion.setObs_habitacion(obs_habitacion);
habitacion.setTipohabitacion(tipohabitacion);


if (HabitacionesControlador.agregar(habitacion)){
    tipo = "success";
    mensaje = "Datos agregados";
}



        

JSONObject obj = new JSONObject();
obj.put("tipo", tipo);
obj.put("mensaje", mensaje);

 obj.put("id_habitacion", String.valueOf(habitacion.getId_habitacion()));
 System.out.println(habitacion.getId_habitacion());
      
out.print(obj);
out.flush();
%>