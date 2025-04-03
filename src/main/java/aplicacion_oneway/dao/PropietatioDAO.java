package aplicacion_oneway.dao;

import aplicacion_oneway.model.Propietario;

import java.util.List;

public interface PropietatioDAO {

    //Metodo para insertar un propietario en la base de datos
    Propietario insertar(Propietario propietario);

    //Metodo para obtener un propietario por su ID
    Propietario obtenerPorId(int id);

    //Metodo para obtener todos los propietarios
    List<Propietario>obtenerTodos();

    //Metodo para actualizar un propietario existente
    void actualizar(Propietario propietario);

    //Metodo para eliminar un propietario por su ID
    void eliminar(int id);
}
