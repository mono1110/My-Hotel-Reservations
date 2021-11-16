package co.edu.ucentral.ingsf.springprime;

import co.edu.ucentral.ingsf.springprime.bd.ManejadorConexion;
import co.edu.ucentral.ingsf.springprime.dto.Usuario;
import co.edu.ucentral.ingsf.springprime.operaciones.OperacionesUsuarioPostgres;
import co.edu.ucentral.ingsf.springprime.operaciones.OperacionesUsuarios;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.Connection;
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

}
