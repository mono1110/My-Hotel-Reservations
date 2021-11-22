package co.edu.ucentral.ingsf.springprime.bean;

import co.edu.ucentral.ingsf.springprime.dto.Usuario;
import co.edu.ucentral.ingsf.springprime.operaciones.OperacionesUsuarioPostgres;
import co.edu.ucentral.ingsf.springprime.servicios.DataService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
public class LoginAdminBean implements Serializable {

    private String nombreUsuario;
    private String contrasenia;

    @Autowired
    private DataService dataService;

    @PostConstruct
    public void init() {

    }

    public String validarUsuarioAdm(){
        OperacionesUsuarioPostgres op = new OperacionesUsuarioPostgres();
        String pk=nombreUsuario;
        Usuario u = op.consulta(pk);

//        System.out.println(u);
        if (u != null && u.getContrasenia().equals(contrasenia) && u.isEsAdmin()) {
            return "adminTransicion";
        }else {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Ocurrió un error, verifique los datos" ));

            return "";
        }
    }
}
