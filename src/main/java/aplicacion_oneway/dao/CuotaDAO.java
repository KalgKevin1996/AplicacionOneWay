package aplicacion_oneway.dao;

import aplicacion_oneway.model.Cuota;

import java.util.Date;
import java.util.List;

public interface CuotaDAO {
    Cuota obtenerCuotaPorId(int id);
    List<Cuota> obtenerTodasLasCuotas();
    void guardarCuota(Cuota cuota);
    void actualizarCuota(Cuota cuota);
    void eliminarCuota(int id);

    List<Cuota> obtenerCuotaPorFecha(java.sql.Date fecha);
}
