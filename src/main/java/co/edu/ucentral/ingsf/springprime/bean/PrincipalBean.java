package co.edu.ucentral.ingsf.springprime.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import co.edu.ucentral.ingsf.springprime.servicios.DataService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class PrincipalBean implements Serializable {
    private String cadena;
    private Integer conteo;

//
    private List<String> images;


    @Autowired
    private DataService dataService;


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
//        if (cadena.equals("IR"))
        return "usuarios";
//        else
//            return "";
    }
    public String guardar(){
        dataService.crear("metodo");
        return "";

    }


//
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 4; i++) {
            images.add("img" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }



}

