package com.caliatumano.models;

public class Respuesta {

    private String id;
    private String respuesta;
    private String pre_id;
    private String detalle;
    private int bandera;

    public Respuesta(String id, String respuesta, String pre_id, String detalle, int bandera) {
        this.id = id;
        this.respuesta = respuesta;
        this.pre_id = pre_id;
        this.detalle = detalle;
        this.bandera = bandera;
    }

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getPre_id() {
        return pre_id;
    }

    public void setPre_id(String pre_id) {
        this.pre_id = pre_id;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
