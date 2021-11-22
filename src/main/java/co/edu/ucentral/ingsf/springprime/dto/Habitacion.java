package co.edu.ucentral.ingsf.springprime.dto;

import java.io.Serializable;

public class Habitacion implements Serializable {
    private String codigo;
    private int capacidadMaxima;
    private int precio;
    private String imagen;
    private int idHotel;

    public Habitacion() {
    }

    public Habitacion(String codigo, int capacidadMaxima, int precio, String imagen, int idHotel) {
        this.codigo = codigo;
        this.capacidadMaxima = capacidadMaxima;
        this.precio = precio;
        this.imagen = imagen;
        this.idHotel = idHotel;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "codigo='" + codigo + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", precio=" + precio +
                ", imagen='" + imagen + '\'' +
                ", idHotel=" + idHotel +
                '}';
    }
}
