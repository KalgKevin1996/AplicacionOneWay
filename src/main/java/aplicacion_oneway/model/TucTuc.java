package aplicacion_oneway.model;

import java.time.LocalDate;

public class TucTuc {
    private int idTucTuc;
    private String marca;
    private String modelo;
    private String numeroPlaca;
    private String numeroMotor;
    private String numeroChasis;
    private LocalDate fechaFabricacion;
    private String color;
    private LocalDate fechaAdquisicion;
    private String estado;
    private String observaciones;
    private int propietarioId;

    public TucTuc() {

    }

    public TucTuc(int idTucTuc, String marca, String modelo, String numeroPlaca, String numeroMotor, String numeroChasis,
                  LocalDate fechaFabricacion, String color, LocalDate fechaAdquisicion, String estado,
                  String observaciones, int propietarioId) {
        this.idTucTuc = idTucTuc;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroPlaca = numeroPlaca;
        this.numeroMotor = numeroMotor;
        this.numeroChasis = numeroChasis;
        this.fechaFabricacion = fechaFabricacion;
        this.color = color;
        this.fechaAdquisicion = fechaAdquisicion;
        this.estado = estado;
        this.observaciones = observaciones;
        this.propietarioId = propietarioId;
    }

    public int getIdTucTuc() {
        return idTucTuc;
    }

    public void setIdTucTuc(int idTucTuc) {
        this.idTucTuc = idTucTuc;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }

    @Override
    public String toString() {
        return "TucTuc{" +
                "idTucTuc=" + idTucTuc +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numeroPlaca='" + numeroPlaca + '\'' +
                ", numeroMotor='" + numeroMotor + '\'' +
                ", numeroChasis='" + numeroChasis + '\'' +
                ", fechaFabricacion=" + fechaFabricacion +
                ", color='" + color + '\'' +
                ", fechaAdquisicion=" + fechaAdquisicion +
                ", estado='" + estado + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", propietarioId=" + propietarioId +
                '}';
    }
}
