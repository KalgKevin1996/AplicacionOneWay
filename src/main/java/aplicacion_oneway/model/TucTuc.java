package aplicacion_oneway.model;

import java.util.Date;

public class TucTuc {
    private int idTucTuc;
    private String marca;
    private String modelo;
    private String numeroPlaca;
    private String numeroMotor;
    private String numeroChasis;
    private int anioFabricacion;
    private String color;
    private Date fechaAdquisicion;
    private String estado;
    private String observaciones;
    private int propietarioId;

    // Constructores, getters y setters

    public TucTuc() {
    }

    public TucTuc(int idTucTuc, String marca, String modelo, String numeroPlaca, String numeroMotor, String numeroChasis, int anioFabricacion, String color, Date fechaAdquisicion, String estado, String observaciones, int propietarioId) {
        this.idTucTuc = idTucTuc;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroPlaca = numeroPlaca;
        this.numeroMotor = numeroMotor;
        this.numeroChasis = numeroChasis;
        this.anioFabricacion = anioFabricacion;
        this.color = color;
        this.fechaAdquisicion = fechaAdquisicion;
        this.estado = estado;
        this.observaciones = observaciones;
        this.propietarioId = propietarioId;
    }

    // Getters y setters para todos los atributos
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

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
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
}