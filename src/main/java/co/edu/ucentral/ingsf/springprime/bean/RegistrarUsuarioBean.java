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
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;


@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class RegistrarUsuarioBean implements Serializable {

    private String password1;
//    private String password2;
    private String nombreUsuario;

    @Autowired
    private DataService dataService;

    @PostConstruct
    public void init() {

    }

    public String guardar(){

        if(password1.length()>=8){
            OperacionesUsuarioPostgres op = new OperacionesUsuarioPostgres();
            Usuario u = new Usuario();

            u.setNombreUsuario(nombreUsuario);
            u.setContrasenia(password1);
            u.setEsAdmin(false);

            op.crear(u);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Guardado con éxito"));

            return "";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("La contraseña debe ser de mínimo 8 caracteres"));

            return "";
        }

    }

}
