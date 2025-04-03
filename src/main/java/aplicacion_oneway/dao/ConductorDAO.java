package aplicacion_oneway.dao;

import aplicacion_oneway.model.Conductor;

import java.util.List;

public interface ConductorDAO {
    //Metodos para crear (create), leer (read), actualizar (update) y eliminar (delete) Conductores
    void crearConductor(Conductor conductor);
    Conductor obtenerConductorPorId(int id);
    List<Conductor> obtenerTodosLosConductores();
    void actualizarConductor(Conductor conductor);
    void eliminarConductor(int id);

    //

}
