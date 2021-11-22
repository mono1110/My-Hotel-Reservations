package co.edu.ucentral.ingsf.springprime.operaciones;

import co.edu.ucentral.ingsf.springprime.bd.ManejadorConexion;
import co.edu.ucentral.ingsf.springprime.dto.Habitacion;
import co.edu.ucentral.ingsf.springprime.dto.Hotel;
import co.edu.ucentral.ingsf.springprime.dto.Reserva;
import co.edu.ucentral.ingsf.springprime.dto.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperacionesReservasPostgres implements Operacion<Reserva> {

    private final String sqlCrear= "INSERT INTO public.\"Reservas\"(de_la_fecha, a_la_fecha, \"idHotel\", \"codigoHabitacion\", nombre, cedula) VALUES ( ?, ?, ?, ?, ?, ?)";
    private final String sqlConsultaALL= " SELECT * FROM public.\"Reservas\" ";


    @Override
    public boolean crear(Reserva dato) {
        if (dato == null){
            return false;
        }
        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarsePostgres();
        if (conexActiva != null){
//            System.out.println("Entra"+conexActiva);
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlCrear);

                ps.setDate(1, new java.sql.Date(dato.getDe_la_fecha().getTime()));
                ps.setDate(2, new java.sql.Date(dato.getA_la_fecha().getTime()));
                ps.setString(3, dato.getIdHotel());
                ps.setString(4, dato.getCodigoHabitacion());
                ps.setString(5,dato.getNombre());
                ps.setInt(6,dato.getCedula());

                int modificados = ps.executeUpdate();
//                System.out.println("MODIFICADOS:"+modificados);
                if (modificados >0 ){
                    return true;
                }

            } catch (SQLException throwables) {
//                log.error("Mensaje ", throwables);
                System.out.println(throwables);
            } finally {
                mc.desconexion(conexActiva);

            }
        }

        return false;
    }

    @Override
    public boolean modificar(Reserva dato) {
        return false;
    }

    @Override
    public boolean borrar(Reserva dato) {
        return false;
    }

    @Override
    public Reserva consulta(String pk) {
        return null;
    }

    @Override
    public List<Reserva> consultar() {

        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarsePostgres();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlConsultaALL);

                ResultSet resultado = ps.executeQuery();
                List<Reserva> datos = new ArrayList<>();
                while (resultado.next()){
                    Reserva elreserva = new Reserva();
                    elreserva.setId(resultado.getInt("id"));
                    elreserva.setDe_la_fecha(resultado.getDate("de_la_fecha"));
                    elreserva.setA_la_fecha(resultado.getDate("a_la_fecha"));
                    elreserva.setIdHotel(resultado.getString("idHotel"));
                    elreserva.setCodigoHabitacion(resultado.getString("codigoHabitacion"));
                    elreserva.setNombre(resultado.getString("nombre"));
                    elreserva.setCedula(resultado.getInt("cedula"));

                    datos.add(elreserva);
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
