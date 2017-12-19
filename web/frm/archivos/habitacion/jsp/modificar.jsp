<%@page import="javawebts.controladores.HabitacionesControlador"%>
<%@page import="javawebts.modelos.Marcas"%>
<%@page import="javawebts.modelos.Categorias"%>
<%@page import="javawebts.modelos.Habitaciones"%>
<%@page import="org.json.simple.JSONObject"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));
    String nombre_habitacion = request.getParameter("nombre_habitacion");
   int costo_habitacion = Integer.parseInt(request.getParameter("costo_habitacion"));
   int precioventa_habitacion = Integer.parseInt(request.getParameter("precioventa_habitacion"));
   int iva_habitacion = Integer.parseInt(request.getParameter("iva_habitacion"));
    int id_categoria = Integer.parseInt(request.getParameter("id_categoria"));
    int id_marca = Integer.parseInt(request.getParameter("id_marca"));

    String tipo = "error";
    Habitaciones habitacion = new Habitaciones();
    habitacion.setId_habitacion(id_habitacion);
    habitacion.setNombre_habitacion(nombre_habitacion);
    habitacion.setCosto_habitacion(costo_habitacion);
    habitacion.setPrecioventa_habitacion(precioventa_habitacion);
    habitacion.setIva_habitacion(iva_habitacion);
    Categorias categoria = new Categorias();
    categoria.setId_categoria(id_categoria);
    Marcas marca = new Marcas();
    marca.setId_marca(id_marca);
    habitacion.setCategoria(categoria);
    habitacion.setMarca(marca);

    String mensaje = "Datos no modificados";
    if (HabitacionesControlador.modificar(habitacion)) {
        tipo = "success";
        mensaje = "Datos modificados correctamente";
    };

    JSONObject obj = new JSONObject();
    obj.put("tipo", tipo);
    obj.put("mensaje", String.valueOf(mensaje));
    out.print(obj);
    out.flush();
%>
