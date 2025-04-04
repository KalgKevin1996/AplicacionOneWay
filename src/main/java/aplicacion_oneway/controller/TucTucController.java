package aplicacion_oneway.controller;

import aplicacion_oneway.dao.implement.TucTucDAOImpl;
import aplicacion_oneway.model.TucTuc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class TucTucController {
    private final TucTucDAOImpl tucTucDAO;

    // El Controlador ahora necesita recibir la conexión, siguiendo el patrón del DAO
    public TucTucController(Connection conexion) {
        this.tucTucDAO = new TucTucDAOImpl(conexion);
    }

    public String crearTucTuc(String marca, String modelo, String numeroPlaca, String numeroMotor,
                              String numeroChasis, int anioFabricacion, String color, Date fechaAdquisicion,
                              String estado, String observaciones, int propietarioId) {
        // Validaciones de datos
        if (marca == null || marca.trim().isEmpty()) {
            return "Error: La marca del TucTuc es obligatoria.";
        }
        if (modelo == null || modelo.trim().isEmpty()) {
            return "Error: El modelo del TucTuc es obligatorio.";
        }
        if (numeroPlaca == null || numeroPlaca.trim().isEmpty()) {
            return "Error: El número de placa del TucTuc es obligatorio.";
        }
        if (anioFabricacion <= 0) {
            return "Error: El año de fabricación debe ser un valor positivo.";
        }
        if (fechaAdquisicion == null) {
            return "Error: La fecha de adquisición es obligatoria.";
        }
        if (propietarioId <= 0) {
            return "Error: El ID del propietario debe ser un valor positivo.";
        }
        // Puedes agregar más validaciones para otros campos

        TucTuc tucTuc = new TucTuc();
        tucTuc.setMarca(marca);
        tucTuc.setModelo(modelo);
        tucTuc.setNumeroPlaca(numeroPlaca);
        tucTuc.setNumeroMotor(numeroMotor);
        tucTuc.setNumeroChasis(numeroChasis);
        tucTuc.setAnioFabricacion(anioFabricacion);
        tucTuc.setColor(color);
        tucTuc.setFechaAdquisicion(fechaAdquisicion);
        tucTuc.setEstado(estado);
        tucTuc.setObservaciones(observaciones);
        tucTuc.setPropietarioId(propietarioId);

        try {
            tucTucDAO.crearTucTuc(tucTuc);
            return null; // Indica éxito
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al crear el TucTuc en la base de datos: " + e.getMessage();
        }
    }

    public TucTuc obtenerTucTucPorId(int idTucTuc) {
        if (idTucTuc <= 0) {
            System.err.println("Advertencia: Se intentó obtener un TucTuc con un ID no válido.");
            return null;
        }
        try {
            return tucTucDAO.obtenerTucTucPorId(idTucTuc);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TucTuc> obtenerTodosLosTucTucs() {
        try {
            return tucTucDAO.obtenerTodosLosTucTucs();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // O una lista vacía
        }
    }

    public String actualizarTucTuc(int idTucTuc, String marca, String modelo, String numeroPlaca, String numeroMotor,
                                   String numeroChasis, int anioFabricacion, String color, Date fechaAdquisicion,
                                   String estado, String observaciones, int propietarioId) {
        // Validaciones de datos
        if (idTucTuc <= 0) {
            return "Error: El ID del TucTuc debe ser un valor positivo.";
        }
        if (marca == null || marca.trim().isEmpty()) {
            return "Error: La marca del TucTuc es obligatoria.";
        }
        if (modelo == null || modelo.trim().isEmpty()) {
            return "Error: El modelo del TucTuc es obligatorio.";
        }
        if (numeroPlaca == null || numeroPlaca.trim().isEmpty()) {
            return "Error: El número de placa del TucTuc es obligatorio.";
        }
        if (anioFabricacion <= 0) {
            return "Error: El año de fabricación debe ser un valor positivo.";
        }
        if (fechaAdquisicion == null) {
            return "Error: La fecha de adquisición es obligatoria.";
        }
        if (propietarioId <= 0) {
            return "Error: El ID del propietario debe ser un valor positivo.";
        }
        // Puedes agregar más validaciones

        TucTuc tucTuc = new TucTuc();
        tucTuc.setIdTucTuc(idTucTuc);
        tucTuc.setMarca(marca);
        tucTuc.setModelo(modelo);
        tucTuc.setNumeroPlaca(numeroPlaca);
        tucTuc.setNumeroMotor(numeroMotor);
        tucTuc.setNumeroChasis(numeroChasis);
        tucTuc.setAnioFabricacion(anioFabricacion);
        tucTuc.setColor(color);
        tucTuc.setFechaAdquisicion(fechaAdquisicion);
        tucTuc.setEstado(estado);
        tucTuc.setObservaciones(observaciones);
        tucTuc.setPropietarioId(propietarioId);

        try {
            tucTucDAO.actualizarTucTuc(tucTuc);
            return null; // Indica éxito
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al actualizar el TucTuc en la base de datos: " + e.getMessage();
        }
    }

    public String eliminarTucTuc(int idTucTuc) {
        if (idTucTuc <= 0) {
            return "Error: El ID del TucTuc debe ser un valor positivo.";
        }
        try {
            tucTucDAO.eliminarTucTuc(idTucTuc);
            return null; // Indica éxito
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar el TucTuc de la base de datos: " + e.getMessage();
        }
    }

    public List<TucTuc> buscarTucTucsPorMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            System.err.println("Advertencia: Se intentó buscar TucTucs por una marca nula o vacía.");
            return null; // O una lista vacía
        }
        try {
            return tucTucDAO.buscarTucTucsPorMarca(marca);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // O una lista vacía
        }
    }

    public List<TucTuc> buscarTucTucsPorModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            System.err.println("Advertencia: Se intentó buscar TucTucs por un modelo nulo o vacío.");
            return null; // O una lista vacía
        }
        try {
            return tucTucDAO.buscarTucTucsPorModelo(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // O una lista vacía
        }
    }

    public List<TucTuc> buscarTucTucsPorPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            System.err.println("Advertencia: Se intentó buscar TucTucs por una placa nula o vacía.");
            return null; // O una lista vacía
        }
        try {
            return tucTucDAO.buscarTucTucsPorPlaca(placa);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // O una lista vacía
        }
    }

    public List<TucTuc> buscarTucTucsPorPropietario(int propietarioId) {
        if (propietarioId <= 0) {
            System.err.println("Advertencia: Se intentó buscar TucTucs por un ID de propietario no válido.");
            return null; // O una lista vacía
        }
        try {
            return tucTucDAO.buscarTucTucsPorPropietario(propietarioId);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // O una lista vacía
        }
    }
}