package aplicacion_oneway.view;

import aplicacion_oneway.controller.ConductorController;
import aplicacion_oneway.model.Conductor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionConductores extends JFrame {

    private ConductorController conductorController;
    private PanelFormularioConductor formularioPanel;
    private PanelTablaConductores tablaPanel;

    public VentanaGestionConductores() {
        conductorController = new ConductorController();
        formularioPanel = new PanelFormularioConductor(conductorController, this);
        tablaPanel = new PanelTablaConductores(conductorController);

        setTitle("Gestión de Conductores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        add(formularioPanel, BorderLayout.NORTH);
        add(tablaPanel, BorderLayout.CENTER);

        tablaPanel.cargarConductores(); // Cargar la lista inicial

        pack();
        setLocationRelativeTo(null);
    }

    public void actualizarTablaConductores() {
        tablaPanel.cargarConductores();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaGestionConductores().setVisible(true));
    }
}