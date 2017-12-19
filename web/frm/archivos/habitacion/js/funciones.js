function agregarHabitacion() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/agregar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            limpiarCampos();
            $("#id_habitacion").focus();
            $("#id_habitacion").select();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos.");
        },
        complete: function (objeto, exito, error) {
            $("#id_habitacion").focus();
        }
    });
}
function buscarIdHabitacion() {
    var datosFormulario = $("#formPrograma").serialize();
    //alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarId.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#id_habitacion").val(json.id_habitacion);
            $("#nombre_habitacion").val(json.nombre_habitacion);
            $("#costo_habitacion").val(json.costo_habitacion);
            $("#minadulto_habitacion").val(json.minadulto_habitacion);
            $("#maxadulto_habitacion").val(json.maxadulto_habitacion);
            $("#id_tipohabitacion").val(json.id_tipohabitacion);
            $("#nombre_tipohabitacion").val(json.nombre_tipohabitacion);
            $("#obs_habitacion").val(json.obs_habitacion);
           

            if (json.nuevo === "true") {
                $("#botonAgregar").prop('disabled', false);
                $("#botonModificar").prop('disabled', true);
                $("#botonEliminar").prop('disabled', true);
                $("#nombre_habitacion").focus();


                siguienteCampo("#id_habitacion", "#botonAgregar", false);
            } else {
                $("#botonAgregar").prop('disabled', true);
                $("#botonModificar").prop('disabled', false);
                $("#botonEliminar").prop('disabled', false);
                //  $("#id_cliente").prop('disabled',true);

                siguienteCampo("#id_habitacion", "#botonAgregar", false);
            }
        },
        error: function (e) {
            $("#mensajes").html("No se pudo recuperar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}
function buscarNombreHabitacion() {
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarNombre.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            $("#contenidoBusqueda").css("display", "none");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusqueda").html(json.contenido);
            $("#contenidoBusqueda").fadeIn("slow");
            $("tbody tr").on("click", function () {
                var id = $(this).find("td:first").html();
                $("#panelBuscar").html("");
                $("#id_habitacion").val(id);
                $("#nombre_habitacion").focus();
                buscarIdHabitacion();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
            });
        },
        error: function (e) {
            $("#mensajes").html("No se pudo buscar registros.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });

}
function modificarHabitacion() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/modificar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            limpiarCampos();
        },
        error: function (e) {
            $("#mensajes").html("No se pudo modificar los datos error" + e.status);
        },
        complete: function (objeto, exito, error) {
            limpiarCampos();

            if (exito === "success") {

            }
        }
    });
}
function eliminarHabitacion() {
    var datosFormulario = $("#formPrograma").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/eliminar.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al servidor...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
        },
        error: function (e) {
            $("#mensajes").html("No se pudo eliminar los datos error" + e.status);
        },
        complete: function (objeto, exito, error) {
            limpiarCampos();
            $("#id_habitacion").focus();
            $("#id_habitacion").select();
            if (exito === "success") {

            }
        }
    });
}
function limpiarCampos() {
    $("#id_habitacion").val("0");
    $("#nombre_habitacion").val("");
    $("#costo_habitacion").val("0");
    $("#precioventa_habitacion").val("0");
    $("#min_stock").val("0");
    $("#max_stock").val("0");
    $("#iva_habitacion").val("0");
    $("#id_categoria").val("0");
    $("#nombre_categoria").val("");
    $("#id_marca").val("0");
    $("#nombre_marca").val("");
    $("#id_habitacion").focus(0);
}
function buscarIdCategoria() {
    var datosFormulario = $("#formPrograma").serialize();
    //alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarIdCategoria.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#id_categoria").val(json.id_categoria);
            $("#nombre_categoria").val(json.nombre_categoria);
            if (json.nuevo === "true") {
                $("#botonAgregar").prop('disable', false);
                $("#botonModificar").prop('disable', false);
                $("#botonEliminar").prop('disable', false);
                siguienteCampo("#nombre_categoria", "#botonmodificar", true);

            }
        },
        error: function (e) {
            $("#mensajes").html("No se pudo recuperar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}
function buscarNombreCategoria() {
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarNombreCategoria.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            $("#contenidoBusqueda").css("display", "none");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusqueda").html(json.contenido);
            $("#contenidoBusqueda").fadeIn("slow");
            $("tbody tr").on("click", function () {
                var id = $(this).find("td:first").html();
                $("#panelBuscar").html("");
                $("#id_categoria").val(id);
                $("#nombre_categoria").focus();
                buscarIdCategoria();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
            });
        },
        error: function (e) {
            $("#mensajes").html("No se pudo buscar registros.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });

}
function buscarIdMarca() {
    var datosFormulario = $("#formPrograma").serialize();
    //alert(datosFormulario);
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarIdMarca.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#id_marca").val(json.id_marca);
            $("#nombre_marca").val(json.nombre_marca);
            if (json.nuevo === "true") {
                $("#botonAgregar").prop('disable', false);
                $("#botonModificar").prop('disable', false);
                $("#botonEliminar").prop('disable', false);
                siguienteCampo("#nombre_marca", "#botonmodificar", true);

            }
        },
        error: function (e) {
            $("#mensajes").html("No se pudo recuperar los datos.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });
}
function buscarNombreMarca() {
    var datosFormulario = $("#formBuscar").serialize();
    $.ajax({
        type: 'POST',
        url: 'jsp/buscarNombreMarca.jsp',
        data: datosFormulario,
        dataType: 'json',
        beforeSend: function (objeto) {
            $("#mensajes").html("Enviando datos al Servidor ...");
            $("#contenidoBusqueda").css("display", "none");
        },
        success: function (json) {
            $("#mensajes").html(json.mensaje);
            $("#contenidoBusqueda").html(json.contenido);
            $("#contenidoBusqueda").fadeIn("slow");
            $("tbody tr").on("click", function () {
                var id = $(this).find("td:first").html();
                $("#panelBuscar").html("");
                $("#id_marca").val(id);
                $("#nombre_marca").focus();
                buscarIdMarca();
                $("#buscar").fadeOut("slow");
                $("#panelPrograma").fadeIn("slow");
            });
        },
        error: function (e) {
            $("#mensajes").html("No se pudo buscar registros.");
        },
        complete: function (objeto, exito, error) {
            if (exito === "success") {
            }
        }
    });

}
function soloLetras(e) {
    key = e.keyCode || e.which;
    tecla = String.fromCharCode(key).toLowerCase();
    letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
    especiales = "8-37-39-46";

    tecla_especial = false;
    for (var i in especiales) {
        if (key === especiales[i]) {
            tecla_especial = true;
            break;
        }
    }

    if (letras.indexOf(tecla) === -1 && !tecla_especial) {
        return false;
    }
}
function soloNumeros(e) {
    var key = window.Event ? e.which : e.keyCode();
    return (key >= 48 && key <= 57);
}


function validarFormularioHabitacion() {

    var valor = true;
    var id = $("#id_habitacion").val();

    var nom = $("#nombre_habitacion").val();
    var costo = $("#costo_habitacion").val();
    var venta = $("#precioventa_habitacion").val();
    var iva = $("#iva_habitacion").val();
    var min = $("#min_stock").val();
    var max = $("#max_stock").val();
    var idmar = $("#id_marca").val();
    var idcat = $("#id_categoria").val();


    if (id === "") {
        valor = false;
        $("#id_habitacion").val("");
        $("#id_habitacion").focus();
        $("#mensajes").html("Id No puede estar Vacio.");

    } else {

        if (nom === "") {
            valor = false;

            $("#nombre_habitacion").val("");
            $("#nombre_habitacion").focus();
            $("#mensajes").html("Nombre no puede estar vacio.");

        } else {

            if (costo === "0") {
                valor = false;

                $("#costo_habitacion").val("");
                $("#costo_habitacion").focus();
                $("#mensajes").html("Costo no puede estar en 0.");

            } else {
                if (venta === "0") {
                    valor = false;

                    $("#precioventa_habitacion").val("");
                    $("#precioventa_habitacion").focus();
                    $("#mensajes").html("Precio de Venta no puede estar en 0.");
                } else {

                    if (iva === "") {
                        valor = false;

                        $("#iva_habitacion").val("");
                        $("#iva_habitacion").focus();
                        $("#mensajes").html("IVA no puede estar vacio.");

                    } else {
                        if (min === "0") {
                            valor = false;

                            $("#min_stock").val("");
                            $("#min_stock").focus();
                            $("#mensajes").html("Stock Minimo no puede estar en 0.");


                        } else {

                            if (max === "0") {
                                valor = false;

                                $("#max_stock").val("");
                                $("#max_stock").focus();
                                $("#mensajes").html("Stock Maximo no puede estar en 0.");


                            } else {

                                if (idmar === "0") {
                                    valor = false;

                                    $("#id_marca").val("");
                                    $("#id_marca").focus();
                                    $("#mensajes").html("Marca no puede estar en 0.");


                                } else {
                                    if (idcat === "0") {
                                        valor = false;

                                        $("#id_categoria").val("");
                                        $("#id_categoria").focus();
                                        $("#mensajes").html("Categoria no puede estar en 0.");

                                    }




                                }


                            }
                        }
                    }


                }
            }
        }
    }
    return valor;
}