package codigohernancho.app.prueba.com.inventariodecompras.modelo;

import java.util.Date;

/**
 * Created by urreal on 26/05/2017.
 */

public class Salida {

    public String idSalida;
    public Date fecha;
    public Float cantSalida;

    public Salida(String idSalida, Date fecha, Float cantSalida) {
        this.idSalida = idSalida;
        this.fecha = fecha;
        this.cantSalida = cantSalida;
    }
}