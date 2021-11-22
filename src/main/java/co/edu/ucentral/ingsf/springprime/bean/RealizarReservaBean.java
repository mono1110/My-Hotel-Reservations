package co.edu.ucentral.ingsf.springprime.bean;

import co.edu.ucentral.ingsf.springprime.dto.Habitacion;
import co.edu.ucentral.ingsf.springprime.dto.Hotel;
import co.edu.ucentral.ingsf.springprime.dto.Reserva;
import co.edu.ucentral.ingsf.springprime.operaciones.OperacionesHabitacionesPostgres;
import co.edu.ucentral.ingsf.springprime.operaciones.OperacionesHotelesPostgres;
import co.edu.ucentral.ingsf.springprime.operaciones.OperacionesReservasPostgres;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
@ManagedBean
@ViewScoped
@Getter
@Setter
@RequestScoped
public class RealizarReservaBean implements Serializable {

    List<String> listaHotelesCmb;
    List<String> listaHabitacionesCmb;

    List<String> items;

    List<Habitacion> pruebaHa;

    public List<String> getListaDias() {
        return listaHotelesCmb;
    }

    public List<String> getItems() {
        return items;
    }

    Date date1 ;

    public Date de_la_fecha;
    public Date a_la_fecha;
    public String hotel;
    public String habitacioncmb;
    public String nombre;
    public String cedula;

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public RealizarReservaBean(){

//
        listaHotelesCmb = new ArrayList<String>();
        OperacionesHotelesPostgres oper = new OperacionesHotelesPostgres();

        List<Hotel> listaHoteles= oper.consultar();


        for (Hotel ho: listaHoteles) {
            listaHotelesCmb.add(ho.getId()+". "+ho.getNombre());
        }
//

//
        listaHabitacionesCmb = new ArrayList<String>();
        OperacionesHabitacionesPostgres operha = new OperacionesHabitacionesPostgres();

        List<Habitacion> listaHabita= operha.consultar();


        for (Habitacion ha: listaHabita) {
            listaHabitacionesCmb.add(ha.getCodigo());
        }

//

        items = new ArrayList<>();
        pruebaHa = new ArrayList<>();

        OperacionesHabitacionesPostgres oper2 = new OperacionesHabitacionesPostgres();

        List<Habitacion> listaHabitaciones=oper2.consultar();
        pruebaHa =oper2.consultar();
        for (Habitacion ha: listaHabitaciones) {
            items.add("Código: "+ha.getCodigo()+"\n Capacidad Máxima:"+ha.getCapacidadMaxima()+"\n Precio"+ha.getPrecio());
        }

//        items.add("shirt");
//        items.add("skirt");
//        items.add("trouser");

//        listaHotelesCmb.add(listaHoteles.get(0));


//        listaDias.add("Martes");
//        listaDias.add("Miercoles");
//        listaDias.add("Jueves");
//        listaDias.add("Viernes");
//        listaDias.add("Sabado");
    }

    @Autowired
    private DataService dataService;

    @PostConstruct
    public void init() {

    }


    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }


    public String guardarDatos(){

        if(de_la_fecha!=null && a_la_fecha!=null && hotel!=null && habitacioncmb!=null && cedula!=null && nombre!=null) {

            OperacionesReservasPostgres op = new OperacionesReservasPostgres();

            Reserva r = new Reserva();

            r.setDe_la_fecha(de_la_fecha);
            r.setA_la_fecha(a_la_fecha);
            r.setIdHotel(hotel);
            r.setCodigoHabitacion(habitacioncmb);
            r.setCedula(Integer.parseInt(cedula));
            r.setNombre(nombre);

            op.crear(r);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Guardado con éxito"));

            return"";
        }else{
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Por favor rellene los campos"));

            return"";
        }
    }
}
