package aplicacion_oneway.dao;

import aplicacion_oneway.model.TucTuc;
import java.util.List;

public interface TucTucDAO {

    // Métodos CRUD
    void crearTucTuc(TucTuc tucTuc);
    TucTuc obtenerTucTucPorId(int idTucTuc);
    List<TucTuc> obtenerTodosLosTucTucs();
    void actualizarTucTuc(TucTuc tucTuc);
    void eliminarTucTuc(int idTucTuc);

    // Métodos adicionales (opcionales)
    List<TucTuc> buscarTucTucsPorMarca(String marca);
    List<TucTuc> buscarTucTucsPorModelo(String modelo);
    List<TucTuc> buscarTucTucsPorPlaca(String placa);
    List<TucTuc> buscarTucTucsPorPropietario(int propietarioId);
    // ... otros métodos de búsqueda según tus necesidades
}