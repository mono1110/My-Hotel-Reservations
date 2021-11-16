package co.edu.ucentral.ingsf.springprime.dto;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombreUsuario;
    private String contrasenia;
    private boolean esAdmin;

    public Usuario(String nombreUsuario, String contrasenia, boolean esAdmin) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.esAdmin = esAdmin;
    }

    public Usuario() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", esAdmin=" + esAdmin +
                '}';
    }
}
