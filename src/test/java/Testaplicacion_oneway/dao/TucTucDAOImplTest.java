package Testaplicacion_oneway.dao;

import aplicacion_oneway.dao.implement.CuotaDAOImpl;
import aplicacion_oneway.model.Cuota;
import aplicacion_oneway.util.ConexionDB;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CuotaDAOImplTest {

    @Mock
    private Connection conexion;

    @InjectMocks
    private CuotaDAOImpl cuotaDAO;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() throws SQLException {
        closeable = MockitoAnnotations.openMocks(this);
        conexion = ConexionDB.conectar();
        cuotaDAO = new CuotaDAOImpl();
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }

    @Test
    void obtenerCuotaPorId_debe_retornar_cuota_si_existe() throws SQLException {
        // Arrange
        int id = 1;
        Cuota cuotaEsperada = new Cuota();
        cuotaEsperada.setId(id);
        cuotaEsperada.setMontoCuota(100.0f);
        cuotaEsperada.setMontoAdicional(20.0f);
        cuotaEsperada.setChoferId(1);
        cuotaEsperada.setTucTucId(1);
        cuotaEsperada.setFecha(Date.valueOf("2023-10-27"));
        cuotaEsperada.setDiaSemana("Viernes");
        cuotaEsperada.setPropietarioId(1);
        cuotaEsperada.setComentario("Comentario");
        cuotaEsperada.setFotoSobre("foto.jpg");

        Cuota cuotaObtenida = cuotaDAO.obtenerCuotaPorId(id);

        // Assert
        assertNotNull(cuotaObtenida);
        assertEquals(cuotaEsperada.getId(), cuotaObtenida.getId());
        assertEquals(cuotaEsperada.getMontoCuota(), cuotaObtenida.getMontoCuota());
        assertEquals(cuotaEsperada.getMontoAdicional(), cuotaObtenida.getMontoAdicional());
        // ... Compara otros atributos
    }

    @Test
    void obtenerCuotaPorId_debe_retornar_null_si_no_existe() throws SQLException {
        // Arrange
        int id = 999; // ID que no existe

        // Act
        Cuota cuotaObtenida = cuotaDAO.obtenerCuotaPorId(id);

        // Assert
        assertNull(cuotaObtenida);
    }

    @Test
    void obtenerTodasLasCuotas_debe_retornar_lista_de_cuotas() throws SQLException {
        // Arrange

        // Act
        List<Cuota> cuotas = cuotaDAO.obtenerTodasLasCuotas();

        // Assert
        assertNotNull(cuotas);
        assertFalse(cuotas.isEmpty());
        // ... Compara el tamaño de la lista y los atributos de las cuotas
    }

    @Test
    void guardarCuota_debe_guardar_cuota_correctamente() throws SQLException {
        // Arrange
        Cuota cuota = new Cuota();
        cuota.setMontoCuota(100.0f);
        cuota.setMontoAdicional(20.0f);
        cuota.setChoferId(1);
        cuota.setTucTucId(1);
        cuota.setFecha(Date.valueOf("2023-10-27"));
        cuota.setDiaSemana("Viernes");
        cuota.setPropietarioId(1);
        cuota.setComentario("Comentario");
        cuota.setFotoSobre("foto.jpg");

        // Act
        cuotaDAO.guardarCuota(cuota);

        // Assert
        Cuota cuotaGuardada = cuotaDAO.obtenerCuotaPorId(1);
        assertNotNull(cuotaGuardada);
        assertEquals(cuota.getMontoCuota(), cuotaGuardada.getMontoCuota());
        // ... Compara otros atributos
    }

    @Test
    void actualizarCuota_debe_actualizar_cuota_correctamente() throws SQLException {
        // Arrange
        Cuota cuota = new Cuota();
        cuota.setId(1);
        cuota.setMontoCuota(150.0f);
        cuota.setMontoAdicional(30.0f);
        cuota.setChoferId(2);
        cuota.setTucTucId(2);
        cuota.setFecha(Date.valueOf("2023-10-28"));
        cuota.setDiaSemana("Sábado");
        cuota.setPropietarioId(2);
        cuota.setComentario("Nuevo comentario");
        cuota.setFotoSobre("nueva_foto.jpg");

        // Act
        cuotaDAO.actualizarCuota(cuota);

        // Assert
        Cuota cuotaActualizada = cuotaDAO.obtenerCuotaPorId(1);
        assertNotNull(cuotaActualizada);
        assertEquals(cuota.getMontoCuota(), cuotaActualizada.getMontoCuota());
        // ... Compara otros atributos
    }

    @Test
    void eliminarCuota_debe_eliminar_cuota_correctamente() throws SQLException {
        // Arrange
        int id = 1;

        // Act
        cuotaDAO.eliminarCuota(id);

        // Assert
        Cuota cuotaEliminada = cuotaDAO.obtenerCuotaPorId(id);
        assertNull(cuotaEliminada);
    }


    @Test
    void obtenerCuotaPorFecha_debe_retornar_lista_de_cuotas_por_fecha() throws SQLException {
        // Arrange
        Date fecha = Date.valueOf("2023-10-27");

        // Act
        List<Cuota> cuotas = cuotaDAO.obtenerCuotaPorFecha(fecha);

        // Assert
        assertNotNull(cuotas);
        assertFalse(cuotas.isEmpty());
        // ... Compara el tamaño de la lista y los atributos de las cuotas
    }
}