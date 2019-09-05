package com.caliatumano.models;

import java.util.ArrayList;

public class Pregunta {

    private int pre_id;
    private String pregunta;
    private String categoria;
    private String estado;
    private ArrayList<Respuesta> listRespuesta;

    public Pregunta(int pre_id, String pregunta, String categoria, String estado, ArrayList<Respuesta> listRespuesta) {
        this.pre_id = pre_id;
        this.pregunta = pregunta;
        this.categoria = categoria;
        this.estado = estado;
        this.listRespuesta = listRespuesta;
    }

    public int getPre_id() {
        return pre_id;
    }

    public void setPre_id(int pre_id) {
        this.pre_id = pre_id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Respuesta> getListRespuesta() {
        return listRespuesta;
    }

    public void setListRespuesta(ArrayList<Respuesta> listRespuesta) {
        this.listRespuesta = listRespuesta;
    }
}
