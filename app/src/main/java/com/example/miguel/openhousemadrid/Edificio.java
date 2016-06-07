package com.example.miguel.openhousemadrid;

import java.io.Serializable;

/**
 * Created by Santos on 22/04/2016.
 */
public class Edificio implements Serializable {

    private int id;
    private String activo;
    private String comollegar;
    private String construccion;
    private String descripcion;
    private String direccion;
    private String fotografia;
    private String latitud;
    private String longitud;
    private String minus;
    private String nombre;
    private String tipoedif;
    private String web;
    private String horario;

    public Edificio() {
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getComollegar() {
        return comollegar;
    }

    public void setComollegar(String comollegar) {
        this.comollegar = comollegar;
    }

    public String getConstruccion() {
        return construccion;
    }

    public void setConstruccion(String construccion) {
        this.construccion = construccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getMinus() {
        return minus;
    }

    public void setMinus(String minus) {
        this.minus = minus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoedif() {
        return tipoedif;
    }

    public void setTipoedif(String tipoedif) {
        this.tipoedif = tipoedif;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
