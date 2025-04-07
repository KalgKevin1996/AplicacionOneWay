package aplicacion_oneway.view;

import aplicacion_oneway.controller.ConductorController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class PanelFormularioConductor extends JPanel {

    private ConductorController conductorController;
    private VentanaGestionConductores ventanaPadre;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDpi;
    private JTextField txtLicencia;
    private JTextField txtFechaNacimiento;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtFechaContratacion;
    private JTextField txtEstado;
    private JTextArea txtObservaciones;
    private JTextField txtFotoConductor;
    private JTextField txtFotoDpi;
    private JTextField txtFotoLicencia;

    private JButton btnGuardar;
    private JButton btnNuevo;

    public PanelFormularioConductor(ConductorController controller, VentanaGestionConductores padre) {
        this.conductorController = controller;
        this.ventanaPadre = padre;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("ID:"), gbc);
        gbc.gridy++;
        add(new JLabel("Nombre:"), gbc);
        gbc.gridy++;
        add(new JLabel("Apellido:"), gbc);
        gbc.gridy++;
        add(new JLabel("DPI:"), gbc);
        gbc.gridy++;
        add(new JLabel("Licencia:"), gbc);
        gbc.gridy++;
        add(new JLabel("Fecha Nacimiento (YYYY-MM-DD):"), gbc);
        gbc.gridy++;
        add(new JLabel("Dirección:"), gbc);
        gbc.gridy++;
        add(new JLabel("Teléfono:"), gbc);
        gbc.gridy++;
        add(new JLabel("Fecha Contratación (YYYY-MM-DD):"), gbc);
        gbc.gridy++;
        add(new JLabel("Estado:"), gbc);
        gbc.gridy++;
        add(new JLabel("Observaciones:"), gbc);
        gbc.gridy++;
        add(new JLabel("Foto Conductor:"), gbc);
        gbc.gridy++;
        add(new JLabel("Foto DPI:"), gbc);
        gbc.gridy++;
        add(new JLabel("Foto Licencia:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        txtId = new JTextField(10);
        txtId.setEnabled(false);
        add(txtId, gbc);
        gbc.gridy++;
        txtNombre = new JTextField(20);
        add(txtNombre, gbc);
        gbc.gridy++;
        txtApellido = new JTextField(20);
        add(txtApellido, gbc);
        gbc.gridy++;
        txtDpi = new JTextField(20);
        add(txtDpi, gbc);
        gbc.gridy++;
        txtLicencia = new JTextField(20);
        add(txtLicencia, gbc);
        gbc.gridy++;
        txtFechaNacimiento = new JTextField(15);
        add(txtFechaNacimiento, gbc);
        gbc.gridy++;
        txtDireccion = new JTextField(30);
        add(txtDireccion, gbc);
        gbc.gridy++;
        txtTelefono = new JTextField(15);
        add(txtTelefono, gbc);
        gbc.gridy++;
        txtFechaContratacion = new JTextField(15);
        add(txtFechaContratacion, gbc);
        gbc.gridy++;
        txtEstado = new JTextField(10);
        add(txtEstado, gbc);
        gbc.gridy++;
        txtObservaciones = new JTextArea(5, 20);
        JScrollPane scrollObservaciones = new JScrollPane(txtObservaciones);
        add(scrollObservaciones, gbc);
        gbc.gridy++;
        txtFotoConductor = new JTextField(30);
        add(txtFotoConductor, gbc);
        gbc.gridy++;
        txtFotoDpi = new JTextField(30);
        add(txtFotoDpi, gbc);
        gbc.gridy++;
        txtFotoLicencia = new JTextField(30);
        add(txtFotoLicencia, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnNuevo = new JButton("Nuevo");
        btnGuardar = new JButton("Guardar");
        panelBotones.add(btnNuevo);
        panelBotones.add(btnGuardar);
        add(panelBotones, gbc);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarConductor();
            }
        });

        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
            }
        });
    }

    private void guardarConductor() {
        try {
            int id = 0; // El ID se genera en la base de datos
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String dpi = txtDpi.getText();
            String licencia = txtLicencia.getText();
            LocalDate fechaNacimiento = parseLocalDate(txtFechaNacimiento.getText());
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            LocalDate fechaContratacion = parseLocalDate(txtFechaContratacion.getText());
            String estado = txtEstado.getText();
            String observaciones = txtObservaciones.getText();
            String fotoConductor = txtFotoConductor.getText();
            String fotoDpi = txtFotoDpi.getText();
            String fotoLicencia = txtFotoLicencia.getText();

            conductorController.crearConductor(id, nombre, apellido, dpi, licencia,
                    fechaNacimiento, direccion, telefono, fechaContratacion, estado, observaciones,
                    fotoConductor, fotoDpi, fotoLicencia);

            JOptionPane.showMessageDialog(this, "Conductor guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
            ventanaPadre.actualizarTablaConductores();

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato de la fecha (YYYY-MM-DD).", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDpi.setText("");
        txtLicencia.setText("");
        txtFechaNacimiento.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtFechaContratacion.setText("");
        txtEstado.setText("");
        txtObservaciones.setText("");
        txtFotoConductor.setText("");
        txtFotoDpi.setText("");
        txtFotoLicencia.setText("");
    }

    private LocalDate parseLocalDate(String dateString) {
        if (dateString == null || dateString.trim().isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto (YYYY-MM-DD).", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}