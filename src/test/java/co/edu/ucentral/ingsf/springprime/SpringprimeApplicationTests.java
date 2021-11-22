package co.edu.ucentral.ingsf.springprime;

import co.edu.ucentral.ingsf.springprime.bd.ManejadorConexion;
import co.edu.ucentral.ingsf.springprime.dto.Habitacion;
import co.edu.ucentral.ingsf.springprime.dto.Hotel;
import co.edu.ucentral.ingsf.springprime.dto.Reserva;
import co.edu.ucentral.ingsf.springprime.dto.Usuario;
import co.edu.ucentral.ingsf.springprime.operaciones.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringprimeApplicationTests {

    @Test
    void contextLoads() {
    }

    @DisplayName("Pruebas de conexion ")
    @Test
    public void testPruebasConexion(){
        ManejadorConexion c = new ManejadorConexion();
        Connection con = c.conectarseSQLite();
//        System.out.println("CONEXION: "+con);
        assertNotNull(con);
    }

    @DisplayName("Pruebas de conexion Postgres")
    @Test
    public void testPruebasConexionPostgres(){
        ManejadorConexion c = new ManejadorConexion();
        Connection con = c.conectarsePostgres();
//        System.out.println("CONEXION: "+con);
        assertNotNull(con);
    }

    @DisplayName("prueba crear usuario ")
    @Test
    public void testPruebaCrearUsuario(){
        OperacionesUsuarios oper = new OperacionesUsuarios();
        Usuario u = new Usuario();
        u.setNombreUsuario("Daniel");
        u.setContrasenia("123456789");
        u.setEsAdmin(true);
        boolean rta= oper.crear(u);
//        System.out.println(u);
        assertTrue(rta);
    }

    @DisplayName("Consulta All ")
    @Test
    public void consultaAll(){
        OperacionesUsuarios oper = new OperacionesUsuarios();
        List<Usuario> v = oper.consultar();
        for (Usuario dato:v) {
            System.out.println(dato);

        }
        assertTrue(v.size()>0);

    }

    @DisplayName("prueba crear Usuario Postgress ")
    @Test
    public void testPruebaCrearUsuarioPostgress(){
        OperacionesUsuarioPostgres oper = new OperacionesUsuarioPostgres();
        Usuario u = new Usuario();
        u.setNombreUsuario("Daniel");
        u.setContrasenia("123456789");
        u.setEsAdmin(true);
        boolean rta= oper.crear(u);
//        System.out.println(u);
        assertTrue(rta);
    }

    @DisplayName("prueba Consulta All usuarios postgress ")
    @Test
    public void consultaAllUsuariosPostgres(){
        OperacionesUsuarioPostgres oper = new OperacionesUsuarioPostgres();
        List<Usuario> v = oper.consultar();
        for (Usuario dato:v) {
            System.out.println(dato);

        }

        assertTrue(v.size()>0);

    }

    @DisplayName("Consulta usuario por nombreUsuario ok")
    @Test
    public void consultaokpkUsuario(){
        OperacionesUsuarioPostgres oper = new OperacionesUsuarioPostgres();
        String pk = "Usuario1";
        Usuario u = oper.consulta(pk);
//        assertNotNull(u);
        System.out.println(u);

    }

    @DisplayName("prueba Consulta All hoteles postgress ")
    @Test
    public void consultaAllHotelesPostgres(){
        OperacionesHotelesPostgres oper = new OperacionesHotelesPostgres();
        List<Hotel> v = oper.consultar();
        for (Hotel dato:v) {
            System.out.println(dato);

        }

        assertTrue(v.size()>0);

    }

    @DisplayName("prueba Consulta All habitaciones postgress ")
    @Test
    public void consultaAllHabitacionesPostgres(){
        OperacionesHabitacionesPostgres oper = new OperacionesHabitacionesPostgres();
        List<Habitacion> v = oper.consultar();
        for (Habitacion dato:v) {
            System.out.println(dato);

        }

        assertTrue(v.size()>0);

    }

    @DisplayName("prueba get lista")
    @Test
    public void pruebaGetLista(){
        List<String> listaHotelesCmb = new ArrayList<String>();

        OperacionesHotelesPostgres oper = new OperacionesHotelesPostgres();

        List<Hotel> listaHoteles= oper.consultar();

//        Hotel h = (Hotel) listaHoteles.get(0);

        for (Hotel ho: listaHoteles) {
            listaHotelesCmb.add(ho.getId()+". "+ho.getNombre());
        }

//        System.out.println(h.getId()+" ."+h.getNombre());
        System.out.println(listaHotelesCmb);

    }


    @DisplayName("prueba crear Reserva Postgress ")
    @Test
    public void testPruebaCrearReservaPostgress(){
        OperacionesReservasPostgres op = new OperacionesReservasPostgres();
        Reserva r = new Reserva();
        r.setDe_la_fecha(new Date());
        r.setA_la_fecha(new Date());
        r.setIdHotel("1. Pueb");
        r.setCodigoHabitacion("h4");
        r.setNombre("Pedro");
        r.setCedula(4422);


        boolean rta= op.crear(r);
        System.out.println(r);
        assertTrue(rta);
    }

}
