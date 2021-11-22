package co.edu.ucentral.ingsf.springprime.dto;

import java.io.Serializable;

import java.util.Date;

public class Reserva implements Serializable {
    private int id;
    private Date de_la_fecha;
    private Date a_la_fecha;
    private String idHotel;
    private String codigoHabitacion;
    private String nombre;
    private int cedula;

    public Reserva() {
    }

    public Reserva(int id, Date de_la_fecha, Date a_la_fecha, String idHotel, String codigoHabitacion, String nombre, int cedula) {
        this.id = id;
        this.de_la_fecha = de_la_fecha;
        this.a_la_fecha = a_la_fecha;
        this.idHotel = idHotel;
        this.codigoHabitacion = codigoHabitacion;
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDe_la_fecha() {
        return de_la_fecha;
    }

    public void setDe_la_fecha(Date de_la_fecha) {
        this.de_la_fecha = de_la_fecha;
    }

    public Date getA_la_fecha() {
        return a_la_fecha;
    }

    public void setA_la_fecha(Date a_la_fecha) {
        this.a_la_fecha = a_la_fecha;
    }

    public String getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(String idHotel) {
        this.idHotel = idHotel;
    }

    public String getCodigoHabitacion() {
        return codigoHabitacion;
    }

    public void setCodigoHabitacion(String codigoHabitacion) {
        this.codigoHabitacion = codigoHabitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", de_la_fecha=" + de_la_fecha +
                ", a_la_fecha=" + a_la_fecha +
                ", idHotel=" + idHotel +
                ", codigoHabitacion='" + codigoHabitacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cedula=" + cedula +
                '}';
    }
}
