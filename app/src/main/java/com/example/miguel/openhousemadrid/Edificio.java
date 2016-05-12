package com.example.miguel.openhousemadrid;

import java.io.Serializable;

/**
 * Created by Santos on 22/04/2016.
 */
public class Edificio implements Serializable {

    private String nombre;
    private int img;
    private String descripción;
    private String horario;
    private String direccion;
    private String comoLlegar;
    private String tipoEdif;
    private String construccion;
    private String minus;
    private String inscrip;
    private String web;


    public Edificio(String nombre, int img, String descripción, String horario, String direccion,
                    String comoLlegar, String tipoEdif, String construccion, String minus,
                    String inscrip, String web) {

        this.nombre = nombre;
        this.img = img;
        this.descripción = descripción;
        this.horario = horario;
        this.direccion = direccion;
        this.comoLlegar = comoLlegar;
        this.tipoEdif = tipoEdif;
        this.construccion = construccion;
        this.minus = minus;
        this.inscrip = inscrip;
        this.web = web;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComoLlegar() {
        return comoLlegar;
    }

    public void setComoLlegar(String comoLlegar) {
        this.comoLlegar = comoLlegar;
    }

    public String getTipoEdif() {
        return tipoEdif;
    }

    public void setTipoEdif(String tipoEdif) {
        this.tipoEdif = tipoEdif;
    }

    public String getConstruccion() {
        return construccion;
    }

    public void setConstruccion(String construccion) {
        this.construccion = construccion;
    }

    public String getMinus() {
        return minus;
    }

    public void setMinus(String minus) {
        this.minus = minus;
    }

    public String getInscrip() {
        return inscrip;
    }

    public void setInscrip(String inscrip) {
        this.inscrip = inscrip;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }


}
