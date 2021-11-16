package co.edu.ucentral.ingsf.springprime.bean;

import java.io.Serializable;

import co.edu.ucentral.ingsf.springprime.servicios.DataService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
public class IndexBean implements Serializable {
    private String cadena;
    private Integer conteo;

    @Autowired
    private DataService dataService;

    @PostConstruct
    public void init() {

    }
    public void validar(){
        System.out.println("xxxxx   xxxx");

        if (cadena.isEmpty()){
            conteo = 0;
        }else{
            conteo = cadena.length();
        }

    }
    public String ir(){
        System.out.println("- - - - - - CLICK "+cadena);
        if (cadena.equals("IR"))
            return "principal";
        else
            return "";
    }
    public String guardar(){
        dataService.crear("metodo");
        return "";

    }

}
