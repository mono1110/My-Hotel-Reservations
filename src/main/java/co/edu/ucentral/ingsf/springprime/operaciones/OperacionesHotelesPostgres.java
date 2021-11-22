package co.edu.ucentral.ingsf.springprime.operaciones;

import co.edu.ucentral.ingsf.springprime.bd.ManejadorConexion;
import co.edu.ucentral.ingsf.springprime.dto.Hotel;
import co.edu.ucentral.ingsf.springprime.dto.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class OperacionesHotelesPostgres implements Operacion<Hotel> {

    private final String sqlConsultaALL= " SELECT * FROM public.\"Hoteles\" ";

    private final String sqlConsultaPK= "SELECT * FROM public.\"Usuarios\" where \"nombreUsuario\"=?;";

    @Override
    public boolean crear(Hotel dato) {
        return false;
    }

    @Override
    public boolean modificar(Hotel dato) {
        return false;
    }

    @Override
    public boolean borrar(Hotel dato) {
        return false;
    }

    @Override
    public Hotel consulta(String pk) {
        return null;
    }

    @Override
    public List<Hotel> consultar() {

        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarsePostgres();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlConsultaALL);

                ResultSet resultado = ps.executeQuery();
                List<Hotel> datos = new ArrayList<>();
                while (resultado.next()){
                    Hotel elhotel = new Hotel();
                    elhotel.setId(resultado.getInt("id"));
                    elhotel.setNombre(resultado.getString("nombre"));
                    elhotel.setDireccion(resultado.getString("direccion"));
                    elhotel.setTelefono(resultado.getInt("telefono"));
                    datos.add(elhotel);
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
