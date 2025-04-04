package aplicacion_oneway.dao.implement;

import aplicacion_oneway.dao.ConductorDAO;
import aplicacion_oneway.model.Conductor;
import aplicacion_oneway.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConductorDAOImpl implements ConductorDAO {
    private Connection conexion;

    public ConductorDAOImpl() {
        try {
            this.conexion = ConexionDB.conectar();
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }

    @Override
    public void crearConductor(Conductor conductor) {
        String sql = "INSERT INTO conductor (ID_Conductor, Nombre, Apellido, " +
                "Numero_DPI, Numero_Licencia, Fecha_Nacimiento, Direccion, " +
                "Telefono, Fecha_Contratacion, Estado, Observaciones, " +
                "Foto_Conductor, Foto_DPI, Foto_Licencia) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, conductor.getId());
            stmt.setString(2, conductor.getNombre());
            stmt.setString(3, conductor.getApellido());
            stmt.setString(4, conductor.getNumeroDpi());
            stmt.setString(5, conductor.getNumeroLicencia());
            stmt.setDate(6, conductor.getFechaNacimiento() != null ? Date.valueOf(conductor.getFechaNacimiento().toLocalDate()) : null);
            stmt.setString(7, conductor.getDireccion());
            stmt.setString(8, conductor.getTelefono());
            stmt.setDate(9, conductor.getFechaContratacion() != null ? Date.valueOf(conductor.getFechaContratacion().toLocalDate()) : null);
            stmt.setString(10, conductor.getEstado());
            stmt.setString(11, conductor.getObservaciones());
            stmt.setString(12, conductor.getFotoConductor());
            stmt.setString(13, conductor.getFotoDpi());
            stmt.setString(14, conductor.getFotoLicencia());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Conductor obtenerConductorPorId(int id) {
        String sql = "SELECT * FROM conductor WHERE ID_Conductor = ?";
        Conductor conductor = null;

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                conductor = new Conductor(
                        rs.getInt("ID_Conductor"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Numero_DPI"),
                        rs.getString("Numero_Licencia"),
                        rs.getDate("Fecha_Nacimiento") != null ? Date.valueOf(rs.getDate("Fecha_Nacimiento").toLocalDate()) : null,
                        rs.getString("Direccion"),
                        rs.getString("Telefono"),
                        rs.getDate("Fecha_Contratacion") != null ? Date.valueOf(rs.getDate("Fecha_Contratacion").toLocalDate()) : null,
                        rs.getString("Estado"),
                        rs.getString("Observaciones"),
                        rs.getString("Foto_Conductor"),
                        rs.getString("Foto_DPI"),
                        rs.getString("Foto_Licencia")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conductor;
    }

    @Override
    public List<Conductor> obtenerTodosLosConductores() {
        String sql = "SELECT * FROM conductor";
        List<Conductor> lista = new ArrayList<>();

        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Conductor conductor = new Conductor(
                        rs.getInt("ID_Conductor"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Numero_DPI"),
                        rs.getString("Numero_Licencia"),
                        rs.getDate("Fecha_Nacimiento") != null ? Date.valueOf(rs.getDate("Fecha_Nacimiento").toLocalDate()) : null,
                        rs.getString("Direccion"),
                        rs.getString("Telefono"),
                        rs.getDate("Fecha_Contratacion") != null ? Date.valueOf(rs.getDate("Fecha_Contratacion").toLocalDate()) : null,
                        rs.getString("Estado"),
                        rs.getString("Observaciones"),
                        rs.getString("Foto_Conductor"),
                        rs.getString("Foto_DPI"),
                        rs.getString("Foto_Licencia")
                );
                lista.add(conductor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizarConductor(Conductor conductor) {
        String sql = "UPDATE conductor SET Nombre = ?, Apellido = ?, Numero_DPI = ?, Numero_Licencia = ?, Fecha_Nacimiento = ?, Direccion = ?, Telefono = ?, Fecha_Contratacion = ?, Estado = ?, Observaciones = ?, Foto_Conductor = ?, Foto_DPI = ?, Foto_Licencia = ? WHERE ID_Conductor = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, conductor.getNombre());
            stmt.setString(2, conductor.getApellido());
            stmt.setString(3, conductor.getNumeroDpi());
            stmt.setString(4, conductor.getNumeroLicencia());
            stmt.setDate(5, conductor.getFechaNacimiento() != null ? Date.valueOf(conductor.getFechaNacimiento().toLocalDate()) : null);
            stmt.setString(6, conductor.getDireccion());
            stmt.setString(7, conductor.getTelefono());
            stmt.setDate(8, conductor.getFechaContratacion() != null ? Date.valueOf(conductor.getFechaContratacion().toLocalDate()) : null);
            stmt.setString(9, conductor.getEstado());
            stmt.setString(10, conductor.getObservaciones());
            stmt.setString(11, conductor.getFotoConductor());
            stmt.setString(12, conductor.getFotoDpi());
            stmt.setString(13, conductor.getFotoLicencia());
            stmt.setInt(14, conductor.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarConductor(int id) {
        String sql = "DELETE FROM conductor WHERE ID_Conductor = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Conductor> buscarConductoresPorNombre(String nombre) {
        return buscarConductores("Nombre", nombre);
    }

    @Override
    public List<Conductor> buscarConductoresPorApellido(String apellido) {
        return buscarConductores("Apellido", apellido);
    }

    @Override
    public List<Conductor> buscarConductoresPorDpi(String dpi) {
        return buscarConductores("Numero_DPI", dpi);
    }

    private List<Conductor> buscarConductores(String campo, String valor) {
        String sql = "SELECT * FROM conductor WHERE " + campo + " LIKE ?";
        List<Conductor> lista = new ArrayList<>();

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, "%" + valor + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Conductor conductor = new Conductor(
                        rs.getInt("ID_Conductor"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Numero_DPI"),
                        rs.getString("Numero_Licencia"),
                        rs.getDate("Fecha_Nacimiento") != null ? Date.valueOf(rs.getDate("Fecha_Nacimiento").toLocalDate()) : null,
                        rs.getString("Direccion"),
                        rs.getString("Telefono"),
                        rs.getDate("Fecha_Contratacion") != null ? Date.valueOf(rs.getDate("Fecha_Contratacion").toLocalDate()) : null,
                        rs.getString("Estado"),
                        rs.getString("Observaciones"),
                        rs.getString("Foto_Conductor"),
                        rs.getString("Foto_DPI"),
                        rs.getString("Foto_Licencia")
                );
                lista.add(conductor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
