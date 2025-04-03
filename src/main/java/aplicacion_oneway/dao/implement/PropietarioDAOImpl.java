package aplicacion_oneway.dao.implement;

import aplicacion_oneway.dao.PropietatioDAO;
import aplicacion_oneway.model.Propietario;
import aplicacion_oneway.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PropietarioDAOImpl implements PropietatioDAO {

    private Connection conexion;

    public PropietarioDAOImpl(){
        try {
            this.conexion = ConexionDB.conectar();
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos",e);
        }
    }

    @Override
    public Propietario insertar(Propietario propietario) {
        String sql = "INSERT INTO propietario (ID_Propietario, Nombre, Apellido, Direccion, Telefono, Correo_Electronico, Fecha_Registro, Observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, propietario.getIdPropietario());
            stmt.setString(2, propietario.getNombre());
            stmt.setString(3, propietario.getApellido());
            stmt.setString(4, propietario.getDireccion());
            stmt.setString(5, propietario.getTelefono());
            stmt.setString(6, propietario.getCorreoElectronico());
            stmt.setDate(7, propietario.getFechaRegistro() != null ? Date.valueOf(propietario.getFechaRegistro()) : null);
            stmt.setString(8, propietario.getObservaciones());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propietario;
    }

    @Override
    public Propietario obtenerPorId(int id) {
        String sql = "SELECT * FROM propietario WHERE ID_Propietario = ?";
        Propietario propietario = null;

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                propietario = new Propietario(
                        rs.getInt("ID_Propietario"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Direccion"),
                        rs.getString("Telefono"),
                        rs.getString("Correo_Electronico"),
                        rs.getDate("Fecha_Registro") != null ? rs.getDate("Fecha_Registro").toLocalDate() : null,
                        rs.getString("Observaciones")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propietario;
    }

    @Override
    public List<Propietario> obtenerTodos() {
        String sql = "SELECT * FROM propietario";
        List<Propietario> lista = new ArrayList<>();

        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Propietario propietario = new Propietario(
                        rs.getInt("ID_Propietario"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Direccion"),
                        rs.getString("Telefono"),
                        rs.getString("Correo_Electronico"),
                        rs.getDate("Fecha_Registro") != null ? rs.getDate("Fecha_Registro").toLocalDate() : null,
                        rs.getString("Observaciones")
                );
                lista.add(propietario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Propietario propietario) {
        String sql = "UPDATE propietario SET Nombre = ?, Apellido = ?, Direccion = ?, Telefono = ?, Correo_Electronico = ?, Fecha_Registro = ?, Observaciones = ? WHERE ID_Propietario = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, propietario.getNombre());
            stmt.setString(2, propietario.getApellido());
            stmt.setString(3, propietario.getDireccion());
            stmt.setString(4, propietario.getTelefono());
            stmt.setString(5, propietario.getCorreoElectronico());
            stmt.setDate(6, propietario.getFechaRegistro() != null ? Date.valueOf(propietario.getFechaRegistro()) : null);
            stmt.setString(7, propietario.getObservaciones());
            stmt.setInt(8, propietario.getIdPropietario());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM propietario WHERE ID_Propietario = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
