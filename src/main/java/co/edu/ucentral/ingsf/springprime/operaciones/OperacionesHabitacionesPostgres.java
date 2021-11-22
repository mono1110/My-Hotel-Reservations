package co.edu.ucentral.ingsf.springprime.operaciones;

import co.edu.ucentral.ingsf.springprime.bd.ManejadorConexion;
import co.edu.ucentral.ingsf.springprime.dto.Habitacion;
import co.edu.ucentral.ingsf.springprime.dto.Hotel;
import co.edu.ucentral.ingsf.springprime.dto.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OperacionesHabitacionesPostgres implements Operacion<Habitacion> {

    private final String sqlConsultaALL= " SELECT * FROM public.\"Habitaciones\"; ";

    @Override
    public boolean crear(Habitacion dato) {
        return false;
    }

    @Override
    public boolean modificar(Habitacion dato) {
        return false;
    }

    @Override
    public boolean borrar(Habitacion dato) {
        return false;
    }

    @Override
    public Habitacion consulta(String pk) {
        return null;
    }

    @Override
    public List<Habitacion> consultar() {

        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarsePostgres();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlConsultaALL);

                ResultSet resultado = ps.executeQuery();
                List<Habitacion> datos = new ArrayList<>();
                while (resultado.next()){
                    Habitacion elhabitacion = new Habitacion();
                    elhabitacion.setCodigo(resultado.getString("codigo"));
                    elhabitacion.setCapacidadMaxima(resultado.getInt("capacidadMaxima"));
                    elhabitacion.setPrecio(resultado.getInt("precio"));
                    elhabitacion.setImagen(resultado.getString("imagen"));
                    elhabitacion.setIdHotel(resultado.getInt("idHotel"));
                    datos.add(elhabitacion);
                }
                return datos;

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return new ArrayList<>();
    }
}
