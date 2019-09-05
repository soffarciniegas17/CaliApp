package com.caliatumano.models;

public class Usuario {

    private String codigo, usuario, clave;
    private int nivel, avatar;

    public Usuario(String codigo, String usuario, String clave, int nivel, int avatar) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
        this.avatar = avatar;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
