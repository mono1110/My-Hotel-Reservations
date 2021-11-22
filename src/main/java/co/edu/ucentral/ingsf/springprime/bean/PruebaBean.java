package co.edu.ucentral.ingsf.springprime.bean;


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
public class PruebaBean {

    @Autowired
    private DataService dataService;

    @PostConstruct
    public void init() {

    }

    public String prueba(){
        return "principal";
    }

}
