package co.edu.ucentral.ingsf.springprime.bean;

import co.edu.ucentral.ingsf.springprime.dto.Reserva;
import co.edu.ucentral.ingsf.springprime.operaciones.OperacionesReservasPostgres;
import co.edu.ucentral.ingsf.springprime.servicios.DataService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class listarReservasBean  implements Serializable {


    private List<Reserva> reservas;

    @Autowired
    private DataService dataService;

    @PostConstruct
    public void init() {
        OperacionesReservasPostgres opR = new OperacionesReservasPostgres();

        reservas =opR.consultar();

    }

    public listarReservasBean(){
        OperacionesReservasPostgres opR = new OperacionesReservasPostgres();

        reservas =opR.consultar();

    }



}
