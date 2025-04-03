package aplicacion_oneway.model;

import java.sql.Date;

public class Conductor {
    private int id;
    private String nombre;
    private String apellido;
    private String numeroDpi;
    private String numeroLicencia;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private Date fechaContratacion;
    private String estado;
    private String Observaciones;
    private String fotoConductor;
    private String fotoDpi;
    private String fotoLicencia;

    public Conductor() {

    }

    public Conductor(int id, String nombre, String apellido,
                     String numeroDpi, String numeroLicencia,
                     Date fechaNacimiento, String direccion,
                     String telefono, Date fechaContratacion,
                     String estado, String observaciones,
                     String fotoConductor, String fotoDpi,
                     String fotoLicencia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDpi = numeroDpi;
        this.numeroLicencia = numeroLicencia;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaContratacion = fechaContratacion;
        this.estado = estado;
        Observaciones = observaciones;
        this.fotoConductor = fotoConductor;
        this.fotoDpi = fotoDpi;
        this.fotoLicencia = fotoLicencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroDpi() {
        return numeroDpi;
    }

    public void setNumeroDpi(String numeroDpi) {
        this.numeroDpi = numeroDpi;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public String getFotoConductor() {
        return fotoConductor;
    }

    public void setFotoConductor(String fotoConductor) {
        this.fotoConductor = fotoConductor;
    }

    public String getFotoDpi() {
        return fotoDpi;
    }

    public void setFotoDpi(String fotoDpi) {
        this.fotoDpi = fotoDpi;
    }

    public String getFotoLicencia() {
        return fotoLicencia;
    }

    public void setFotoLicencia(String fotoLicencia) {
        this.fotoLicencia = fotoLicencia;
    }


    @Override
    public String toString() {
        return "Conductor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroDpi='" + numeroDpi + '\'' +
                ", numeroLicencia='" + numeroLicencia + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                ", estado='" + estado + '\'' +
                ", Observaciones='" + Observaciones + '\'' +
                ", fotoConductor='" + fotoConductor + '\'' +
                ", fotoDpi='" + fotoDpi + '\'' +
                ", fotoLicencia='" + fotoLicencia + '\'' +
                '}';
    }
}
