package co.edu.ucentral.ingsf.springprime.operaciones;

import co.edu.ucentral.ingsf.springprime.bd.ManejadorConexion;
import co.edu.ucentral.ingsf.springprime.dto.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperacionesUsuarioPostgres implements Operacion<Usuario> {
    private final String sqlCrear= "INSERT INTO public.\"Usuarios\"(\"nombreUsuario\", contrasenia, \"esAdmin\") VALUES (?,?,?)";
    private final String sqlConsultaALL= " SELECT * FROM public.\"Usuarios\" ";

    private final String sqlConsultaPK= "SELECT * FROM public.\"Usuarios\" where \"nombreUsuario\"=?;";


    @Override
    public boolean crear(Usuario dato) {
        if (dato == null){
            return false;
        }else if (dato.getNombreUsuario() == null || dato.getContrasenia()==null){
            return false;

        }
        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarsePostgres();
        if (conexActiva != null){
//            System.out.println("Entra"+conexActiva);
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlCrear);

                ps.setString(1, dato.getNombreUsuario());
                ps.setString(2, dato.getContrasenia());
                ps.setBoolean(3, dato.isEsAdmin());

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
    public boolean modificar(Usuario dato) {
        return false;
    }

    @Override
    public boolean borrar(Usuario dato) {
        return false;
    }

    @Override
    public Usuario consulta(String pk) {

        if (pk == null){
            return null;
        }
        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarsePostgres();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlConsultaPK);

                ps.setString(1, pk);

                ResultSet resultado = ps.executeQuery();
                if (resultado.next()){
                    Usuario elusuario = new Usuario();
                    elusuario.setNombreUsuario(resultado.getString("nombreUsuario"));
                    elusuario.setContrasenia(resultado.getString("contrasenia"));
                    elusuario.setEsAdmin(resultado.getBoolean("esAdmin"));
                    return elusuario;
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                mc.desconexion(conexActiva);

            }
        }
        return null;

    }

    @Override
    public List<Usuario> consultar() {

        ManejadorConexion mc = new ManejadorConexion();
        Connection conexActiva = mc.conectarsePostgres();
        if (conexActiva != null){
            try {
                PreparedStatement ps = conexActiva.prepareStatement(sqlConsultaALL);

                ResultSet resultado = ps.executeQuery();
                List<Usuario> datos = new ArrayList<>();
                while (resultado.next()){
                    Usuario elusuario = new Usuario();
                    elusuario.setNombreUsuario(resultado.getString("nombreUsuario"));
                    elusuario.setContrasenia(resultado.getString("contrasenia"));
                    elusuario.setEsAdmin(resultado.getBoolean("esAdmin"));
                    datos.add(elusuario);
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
