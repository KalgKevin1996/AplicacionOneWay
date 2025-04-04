package aplicacion_oneway.controller;

import aplicacion_oneway.dao.implement.ConductorDAOImpl;
import aplicacion_oneway.model.Conductor;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

public class ConductorController {
    private final ConductorDAOImpl conductorDAO;

    public ConductorController() {
        this.conductorDAO = new ConductorDAOImpl();
    }

    public void crearConductor(int id, String nombre, String apellido, String numeroDpi,
                               String numeroLicencia, LocalDate fechaNacimiento, String direccion,
                               String telefono, LocalDate fechaContratacion, String estado,
                               String observaciones, String fotoConductor, String fotoDpi,
                               String fotoLicencia) {
        Conductor conductor = new Conductor(id, nombre, apellido, numeroDpi, numeroLicencia,
                fechaNacimiento != null ? Date.valueOf(fechaNacimiento) : null,
                direccion, telefono,
                fechaContratacion != null ? Date.valueOf(fechaContratacion) : null,
                estado, observaciones, fotoConductor, fotoDpi, fotoLicencia);
        conductorDAO.crearConductor(conductor);
    }

    public Conductor obtenerConductorPorId(int id) {
        return conductorDAO.obtenerConductorPorId(id);
    }

    public List<Conductor> obtenerTodosLosConductores() {
        return conductorDAO.obtenerTodosLosConductores();
    }

    public void actualizarConductor(int id, String nombre, String apellido, String numeroDpi,
                                    String numeroLicencia, LocalDate fechaNacimiento, String direccion,
                                    String telefono, LocalDate fechaContratacion, String estado,
                                    String observaciones, String fotoConductor, String fotoDpi,
                                    String fotoLicencia) {
        Conductor conductor = new Conductor(id, nombre, apellido, numeroDpi, numeroLicencia,
                fechaNacimiento != null ? Date.valueOf(fechaNacimiento) : null,
                direccion, telefono,
                fechaContratacion != null ? Date.valueOf(fechaContratacion) : null,
                estado, observaciones, fotoConductor, fotoDpi, fotoLicencia);
        conductorDAO.actualizarConductor(conductor);
    }

    public void eliminarConductor(int id) {
        conductorDAO.eliminarConductor(id);
    }

    public List<Conductor> buscarConductoresPorNombre(String nombre) {
        return conductorDAO.buscarConductoresPorNombre(nombre);
    }

    public List<Conductor> buscarConductoresPorApellido(String apellido) {
        return conductorDAO.buscarConductoresPorApellido(apellido);
    }

    public List<Conductor> buscarConductoresPorDpi(String dpi) {
        return conductorDAO.buscarConductoresPorDpi(dpi);
    }
}