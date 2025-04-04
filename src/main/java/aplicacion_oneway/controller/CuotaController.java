package aplicacion_oneway.controller;

import aplicacion_oneway.dao.implement.CuotaDAOImpl;
import aplicacion_oneway.model.Cuota;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class CuotaController {
    private final CuotaDAOImpl cuotaDAO;

    public CuotaController() {
        this.cuotaDAO = new CuotaDAOImpl();
    }

    public String guardarCuota(float montoCuota, float montoAdicional, int choferId, int tucTucId,
                               Date fecha, String diaSemana, int propietarioId, String comentario,
                               String fotoSobre) {
        // Validaciones de datos
        if (montoCuota < 0) {
            return "Error: El monto de la cuota no puede ser negativo.";
        }
        if (choferId <= 0) {
            return "Error: El ID del chofer debe ser un valor positivo.";
        }
        if (tucTucId <= 0) {
            return "Error: El ID del TucTuc debe ser un valor positivo.";
        }
        if (fecha == null) {
            return "Error: La fecha de la cuota es obligatoria.";
        }
        if (diaSemana == null || diaSemana.trim().isEmpty()) {
            return "Error: El día de la semana es obligatorio.";
        }
        if (propietarioId <= 0) {
            return "Error: El ID del propietario debe ser un valor positivo.";
        }

        Cuota cuota = new Cuota();
        cuota.setMontoCuota(montoCuota);
        cuota.setMontoAdicional(montoAdicional);
        cuota.setChoferId(choferId);
        cuota.setTucTucId(tucTucId);
        cuota.setFecha(fecha);
        cuota.setDiaSemana(diaSemana);
        cuota.setPropietarioId(propietarioId);
        cuota.setComentario(comentario);
        cuota.setFotoSobre(fotoSobre);

        try {
            cuotaDAO.guardarCuota(cuota);
            return null; // Indica éxito
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al guardar la cuota en la base de datos: " + e.getMessage();
        }
    }

    public Cuota obtenerCuotaPorId(int id) {
        try {
            return cuotaDAO.obtenerCuotaPorId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Cuota> obtenerTodasLasCuotas() {
        try {
            return cuotaDAO.obtenerTodasLasCuotas();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // O una lista vacía
        }
    }

    public String actualizarCuota(int id, float montoCuota, float montoAdicional, int choferId, int tucTucId,
                                  Date fecha, String diaSemana, int propietarioId, String comentario,
                                  String fotoSobre) {
        // Validaciones de datos
        if (id <= 0) {
            return "Error: El ID de la cuota debe ser un valor positivo.";
        }
        if (montoCuota < 0) {
            return "Error: El monto de la cuota no puede ser negativo.";
        }
        if (choferId <= 0) {
            return "Error: El ID del chofer debe ser un valor positivo.";
        }
        if (tucTucId <= 0) {
            return "Error: El ID del TucTuc debe ser un valor positivo.";
        }
        if (fecha == null) {
            return "Error: La fecha de la cuota es obligatoria.";
        }
        if (diaSemana == null || diaSemana.trim().isEmpty()) {
            return "Error: El día de la semana es obligatorio.";
        }
        if (propietarioId <= 0) {
            return "Error: El ID del propietario debe ser un valor positivo.";
        }

        Cuota cuota = new Cuota();
        cuota.setId(id);
        cuota.setMontoCuota(montoCuota);
        cuota.setMontoAdicional(montoAdicional);
        cuota.setChoferId(choferId);
        cuota.setTucTucId(tucTucId);
        cuota.setFecha(fecha);
        cuota.setDiaSemana(diaSemana);
        cuota.setPropietarioId(propietarioId);
        cuota.setComentario(comentario);
        cuota.setFotoSobre(fotoSobre);

        try {
            cuotaDAO.actualizarCuota(cuota);
            return null; // Indica éxito
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al actualizar la cuota en la base de datos: " + e.getMessage();
        }
    }

    public String eliminarCuota(int id) {
        if (id <= 0) {
            return "Error: El ID de la cuota debe ser un valor positivo.";
        }
        try {
            cuotaDAO.eliminarCuota(id);
            return null; // Indica éxito
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al eliminar la cuota de la base de datos: " + e.getMessage();
        }
    }

    public List<Cuota> obtenerCuotaPorFecha(Date fecha) {
        if (fecha == null) {
            // Podrías considerar si retornar una lista vacía o un mensaje de error
            System.err.println("Advertencia: Se intentó obtener cuotas por una fecha nula.");
            return null; // O new ArrayList<>();
        }
        try {
            return cuotaDAO.obtenerCuotaPorFecha(fecha);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // O una lista vacía
        }
    }
}