package aplicacion_oneway.dao.implement;

import aplicacion_oneway.dao.TucTucDAO;
import aplicacion_oneway.model.TucTuc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TucTucDAOImpl implements TucTucDAO {

    // Atributos para la conexión a la base de datos
    private Connection conexion;

    // Constructor que recibe la conexión a la base de datos
    public TucTucDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void crearTucTuc(TucTuc tucTuc) {
        String sql = "INSERT INTO tuctuc (Marca, Modelo, Numero_Placa, Numero_Motor, Numero_Chasis, " +
                "Anio_Fabricacion, Color, Fecha_Adquisicion, Estado, Observaciones, Propietario_ID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, tucTuc.getMarca());
            statement.setString(2, tucTuc.getModelo());
            statement.setString(3, tucTuc.getNumeroPlaca());
            statement.setString(4, tucTuc.getNumeroMotor());
            statement.setString(5, tucTuc.getNumeroChasis());
            statement.setInt(6, tucTuc.getAnioFabricacion());
            statement.setString(7, tucTuc.getColor());
            statement.setDate(8, new java.sql.Date(tucTuc.getFechaAdquisicion().getTime()));
            statement.setString(9, tucTuc.getEstado());
            statement.setString(10, tucTuc.getObservaciones());
            statement.setInt(11, tucTuc.getPropietarioId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores (deberías hacer algo mejor que solo imprimir la excepción)
        }
    }

    @Override
    public TucTuc obtenerTucTucPorId(int idTucTuc) {
        String sql = "SELECT * FROM tuctuc WHERE ID_TucTuc = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idTucTuc);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return mapResultSetToTucTuc(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
        return null;
    }

    @Override
    public List<TucTuc> obtenerTodosLosTucTucs() {
        String sql = "SELECT * FROM tuctuc";
        List<TucTuc> tucTucs = new ArrayList<>();
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                tucTucs.add(mapResultSetToTucTuc(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
        return tucTucs;
    }

    @Override
    public void actualizarTucTuc(TucTuc tucTuc) {
        String sql = "UPDATE tuctuc SET Marca = ?, Modelo = ?, Numero_Placa = ?, Numero_Motor = ?, Numero_Chasis = ?, Anio_Fabricacion = ?, Color = ?, Fecha_Adquisicion = ?, Estado = ?, Observaciones = ?, Propietario_ID = ? WHERE ID_TucTuc = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, tucTuc.getMarca());
            statement.setString(2, tucTuc.getModelo());
            statement.setString(3, tucTuc.getNumeroPlaca());
            statement.setString(4, tucTuc.getNumeroMotor());
            statement.setString(5, tucTuc.getNumeroChasis());
            statement.setInt(6, tucTuc.getAnioFabricacion());
            statement.setString(7, tucTuc.getColor());
            statement.setDate(8, new java.sql.Date(tucTuc.getFechaAdquisicion().getTime()));
            statement.setString(9, tucTuc.getEstado());
            statement.setString(10, tucTuc.getObservaciones());
            statement.setInt(11, tucTuc.getPropietarioId());
            statement.setInt(12, tucTuc.getIdTucTuc());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
    }

    @Override
    public void eliminarTucTuc(int idTucTuc) {
        String sql = "DELETE FROM tuctuc WHERE ID_TucTuc = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idTucTuc);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
    }

    @Override
    public List<TucTuc> buscarTucTucsPorMarca(String marca) {
        String sql = "SELECT * FROM tuctuc WHERE Marca LIKE ?";
        List<TucTuc> tucTucs = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, "%" + marca + "%"); // Usamos LIKE para buscar coincidencias parciales
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tucTucs.add(mapResultSetToTucTuc(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
        return tucTucs;
    }

    @Override
    public List<TucTuc> buscarTucTucsPorModelo(String modelo) {
        String sql = "SELECT * FROM tuctuc WHERE Modelo LIKE ?";
        List<TucTuc> tucTucs = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, "%" + modelo + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tucTucs.add(mapResultSetToTucTuc(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
        return tucTucs;
    }

    @Override
    public List<TucTuc> buscarTucTucsPorPlaca(String placa) {
        String sql = "SELECT * FROM tuctuc WHERE Numero_Placa LIKE ?";
        List<TucTuc> tucTucs = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, "%" + placa + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tucTucs.add(mapResultSetToTucTuc(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
        return tucTucs;
    }

    @Override
    public List<TucTuc> buscarTucTucsPorPropietario(int propietarioId) {
        String sql = "SELECT * FROM tuctuc WHERE Propietario_ID = ?";
        List<TucTuc> tucTucs = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, propietarioId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tucTucs.add(mapResultSetToTucTuc(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }
        return tucTucs;
    }

    // Método auxiliar para mapear un ResultSet a un objeto TucTuc
    private TucTuc mapResultSetToTucTuc(ResultSet resultSet) throws SQLException {
        TucTuc tucTuc = new TucTuc();
        tucTuc.setIdTucTuc(resultSet.getInt("ID_TucTuc"));
        tucTuc.setMarca(resultSet.getString("Marca"));
        tucTuc.setModelo(resultSet.getString("Modelo"));
        tucTuc.setNumeroPlaca(resultSet.getString("Numero_Placa"));
        tucTuc.setNumeroMotor(resultSet.getString("Numero_Motor"));
        tucTuc.setNumeroChasis(resultSet.getString("Numero_Chasis"));
        tucTuc.setAnioFabricacion(resultSet.getInt("Anio_Fabricacion"));
        tucTuc.setColor(resultSet.getString("Color"));
        tucTuc.setFechaAdquisicion(resultSet.getDate("Fecha_Adquisicion"));
        tucTuc.setEstado(resultSet.getString("Estado"));
        tucTuc.setObservaciones(resultSet.getString("Observaciones"));
        tucTuc.setPropietarioId(resultSet.getInt("Propietario_ID"));
        return tucTuc;
    }
}