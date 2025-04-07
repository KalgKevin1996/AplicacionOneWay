package aplicacion_oneway.view;

import aplicacion_oneway.controller.ConductorController;
import aplicacion_oneway.model.Conductor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PanelTablaConductores extends JPanel {

    private ConductorController conductorController;
    private JTable tablaConductores;
    private DefaultTableModel modeloTabla;

    public PanelTablaConductores(ConductorController controller) {
        this.conductorController = controller;
        setLayout(new BorderLayout());

        String[] columnas = {"ID", "Nombre", "Apellido", "DPI", "Licencia", "Fecha Nacimiento",
                "Dirección", "Teléfono", "Fecha Contratación", "Estado", "Observaciones",
                "Foto Conductor", "Foto DPI", "Foto Licencia"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaConductores = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaConductores);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void cargarConductores() {
        modeloTabla.setRowCount(0);
        List<Conductor> conductores = conductorController.obtenerTodosLosConductores();

        if (conductores != null) {
            for (Conductor conductor : conductores) {
                Object[] fila = {
                        conductor.getId(),
                        conductor.getNombre(),
                        conductor.getApellido(),
                        conductor.getNumeroDpi(),
                        conductor.getNumeroLicencia(),
                        conductor.getFechaNacimiento(),
                        conductor.getDireccion(),
                        conductor.getTelefono(),
                        conductor.getFechaContratacion(),
                        conductor.getEstado(),
                        conductor.getObservaciones(),
                        conductor.getFotoConductor(),
                        conductor.getFotoDpi(),
                        conductor.getFotoLicencia()
                };
                modeloTabla.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error al cargar la lista de conductores.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}