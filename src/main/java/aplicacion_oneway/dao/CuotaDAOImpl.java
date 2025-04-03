package aplicacion_oneway.dao;

import java.sql.Connection;

import aplicacion_oneway.model.Cuota;
import aplicacion_oneway.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuotaDAOImpl implements CuotaDAO{
    private Connection conexion = null;

    public CuotaDAOImpl(){
        try {
            conexion = ConexionDB.conectar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cuota obtenerCuotaPorId(int id) {
        Cuota cuota = null;
        String sql = "SELECT * FROM cuota WHERE ID = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cuota = mapearCuota(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cuota;
    }

    @Override
    public List<Cuota> obtenerTodasLasCuotas() {
        List<Cuota> cuotas = new ArrayList<>();
        String sql = "SELECT * FROM cuota";

        try (PreparedStatement statement = conexion.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Cuota cuota = mapearCuota(resultSet);
                cuotas.add(cuota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cuotas;
    }

    @Override
    public void guardarCuota(Cuota cuota) {
        String sql = "INSERT INTO cuota (Monto_Cuota, Monto_Adicional, " +
                "Chofer_ID, TucTuc_ID, Fecha, Dia_Semana, Propietario_ID, " +
                "Comentario, Foto_Sobre) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setFloat(1, cuota.getMontoCuota());
            statement.setFloat(2, cuota.getMontoAdicional());
            statement.setInt(3, cuota.getChoferId());
            statement.setInt(4, cuota.getTucTucId());
            statement.setDate(5, cuota.getFecha());
            statement.setString(6, cuota.getDiaSemana());
            statement.setInt(7, cuota.getPropietarioId());
            statement.setString(8, cuota.getComentario());
            statement.setString(9, cuota.getFotoSobre());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizarCuota(Cuota cuota) {
        String sql = "UPDATE cuota SET Monto_Cuota = ?, Monto_Adicional = ?, " +
                "Chofer_ID = ?, TucTuc_ID = ?, Fecha = ?, Dia_Semana = ?, " +
                "Propietario_ID = ?, Comentario = ?, Foto_Sobre = ? WHERE ID = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setFloat(1, cuota.getMontoCuota());
            statement.setFloat(2, cuota.getMontoAdicional());
            statement.setInt(3, cuota.getChoferId());
            statement.setInt(4, cuota.getTucTucId());
            statement.setDate(5, cuota.getFecha());
            statement.setString(6, cuota.getDiaSemana());
            statement.setInt(7, cuota.getPropietarioId());
            statement.setString(8, cuota.getComentario());
            statement.setString(9, cuota.getFotoSobre());
            statement.setInt(10, cuota.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminarCuota(int id) {

        String sql = "DELETE FROM cuota WHERE ID = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cuota> obtenerCuotaPorFecha(Date fecha) {
        List<Cuota> cuotas = new ArrayList<>();
        String sql = "SELECT * FROM cuota WHERE Fecha = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setDate(1, fecha);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cuota cuota = mapearCuota(resultSet);
                cuotas.add(cuota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cuotas;
    }



    private Cuota mapearCuota(ResultSet resultSet) throws SQLException{
        Cuota cuota = new Cuota();
        cuota.setId(resultSet.getInt("ID"));
        cuota.setMontoCuota(resultSet.getFloat("Monto_Cuota"));
        cuota.setMontoAdicional(resultSet.getFloat("Monto_Adicional"));
        cuota.setChoferId(resultSet.getInt("Chofer_ID"));
        cuota.setTucTucId(resultSet.getInt("TucTuc_ID"));
        cuota.setFecha(resultSet.getDate("Fecha"));
        cuota.setDiaSemana(resultSet.getString("Dia_Semana"));
        cuota.setPropietarioId(resultSet.getInt("Propietario_ID"));
        cuota.setComentario(resultSet.getString("Comentario"));
        cuota.setFotoSobre(resultSet.getString("Foto_Sobre"));
        return cuota;
    }


}
