package aplicacion_oneway.controller;

import aplicacion_oneway.dao.implement.PropietarioDAOImpl;
import aplicacion_oneway.model.Propietario;

import java.time.LocalDate;
import java.util.List;

public class PropietarioController {
    private final PropietarioDAOImpl propietarioDAO;

    public PropietarioController() {
        this.propietarioDAO = new PropietarioDAOImpl();
    }

    public String crearPropietario(int id, String nombre, String apellido, String direccion, String telefono,
                                   String correoElectronico, LocalDate fechaRegistro,String observaciones ) {
        // Validaciones de datos
        if (nombre == null || nombre.trim().isEmpty()) {
            return "Error: El nombre del propietario es obligatorio.";
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            return "Error: El apellido del propietario es obligatorio.";
        }
        if (fechaRegistro == null) {
            return "Error: La fecha de registro es obligatoria.";
        }
        // Puedes agregar más validaciones (formato de DPI, teléfono, correo, etc.)

        Propietario propietario = new Propietario(id, nombre, apellido,direccion, telefono, correoElectronico, fechaRegistro, observaciones);
        try {
            propietarioDAO.insertar(propietario);
            return null; // Indica éxito
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al crear el propietario en la base de datos: " + e.getMessage();
        }
    }

    public Propietario obtenerPropietarioPorId(int id) {
        try {
            return propietarioDAO.obtenerPorId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Propietario> obtenerTodosLosPropietarios() {
        try {
            return propietarioDAO.obtenerTodos();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // O una lista vacía
        }
    }

    public String actualizarPropietario(int id, String nombre, String apellido, String direccion, String telefono,
                                        String correoElectronico, LocalDate fechaRegistro,String observaciones ) {
        // Validaciones de datos
        if (id <= 0) {
            return "Error: El ID del propietario debe ser un valor positivo.";
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            return "Error: El nombre del propietario es obligatorio.";
        }
        if (apellido == null || apellido.trim().isEmpty()) {
            return "Error: El apellido del propietario es obligatorio.";
        }
        // Puedes agregar más validaciones

        Propietario propietario = new Propietario(id, nombre, apellido,direccion, telefono, correoElectronico, fechaRegistro, observaciones);
        try {
            propietarioDAO.actualizar(propietario);
            return null; // Indica éxito
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al actualizar el propietario en la base de datos: " + e.getMessage();
        }
    }

    public String eliminarPropietario(int id) {
        if (id <= 0) {
            return "Error: El ID del propietario debe ser un valor positivo.";
        }
        try {
            propietarioDAO.eliminar(id);
            return null; // Indica éxito
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar el propietario de la base de datos: " + e.getMessage();
        }
    }



}