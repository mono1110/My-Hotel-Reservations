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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class LoginUserBean implements Serializable{

    private String nombreUsuario;
    private String contrasenia;
//
    private UIComponent component;

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }

    public String doAction() {

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(component.getClientId(), new FacesMessage("Test msg"));

        return "";
    }
//
//    private String javaText;

    @Autowired
    private DataService dataService;

    @PostConstruct
    public void init() {

    }

    public String validarUsuarioExt(){
//        System.out.println("- - - - - - CLICK "+nombreUsuario+contrasenia);
        OperacionesUsuarioPostgres op = new OperacionesUsuarioPostgres();
        String pk=nombreUsuario;
        Usuario u = op.consulta(pk);

//        System.out.println(u);
        if (u != null && u.getContrasenia().equals(contrasenia) && !u.isEsAdmin()) {
            return "usuarioTransicion";
        }else {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Ocurrió un error, verifique los datos" ));

            return "";
        }

    }
}
