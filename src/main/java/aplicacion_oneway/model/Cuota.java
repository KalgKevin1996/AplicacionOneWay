package aplicacion_oneway.model;

import java.sql.Date;

public class Cuota {
    private int id;
    private float montoCuota;
    private float montoAdicional;
    private int choferId;
    private int tucTucId;
    private Date fecha;
    private String diaSemana;
    private int propietarioId;
    private String comentario;
    private String fotoSobre;

    //Constructores, getters y setters


    public Cuota() {
    }

    public Cuota(int id, float montoCuota, float montoAdicional,
                 int choferId, int tucTucId, Date fecha, String diaSemana,
                 int propietarioId, String comentario, String fotoSobre) {
        this.id = id;
        this.montoCuota = montoCuota;
        this.montoAdicional = montoAdicional;
        this.choferId = choferId;
        this.tucTucId = tucTucId;
        this.fecha = fecha;
        this.diaSemana = diaSemana;
        this.propietarioId = propietarioId;
        this.comentario = comentario;
        this.fotoSobre = fotoSobre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(float montoCuota) {
        this.montoCuota = montoCuota;
    }

    public float getMontoAdicional() {
        return montoAdicional;
    }

    public void setMontoAdicional(float montoAdicional) {
        this.montoAdicional = montoAdicional;
    }

    public int getChoferId() {
        return choferId;
    }

    public void setChoferId(int choferId) {
        this.choferId = choferId;
    }

    public int getTucTucId() {
        return tucTucId;
    }

    public void setTucTucId(int tucTucId) {
        this.tucTucId = tucTucId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFotoSobre() {
        return fotoSobre;
    }

    public void setFotoSobre(String fotoSobre) {
        this.fotoSobre = fotoSobre;
    }

    @Override
    public String toString() {
        return "Cuota{" +
                "id=" + id +
                ", montoCuota=" + montoCuota +
                ", montoAdicional=" + montoAdicional +
                ", choferId=" + choferId +
                ", tucTucId=" + tucTucId +
                ", fecha=" + fecha +
                ", diaSemana='" + diaSemana + '\'' +
                ", propietarioId=" + propietarioId +
                ", comentario='" + comentario + '\'' +
                ", fotoSobre='" + fotoSobre + '\'' +
                '}';
    }
}
