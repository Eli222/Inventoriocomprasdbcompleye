package codigohernancho.app.prueba.com.inventariodecompras.modelo;

import java.util.Date;

/**
 * Created by urreal on 26/05/2017.
 */

public class Entrada {

    public String idEntrada;
    public Date fecha;
    public Float cantEntrada;

    public Entrada(String idEntrada, Date fecha, Float cantEntrada) {
        this.idEntrada = idEntrada;
        this.fecha = fecha;
        this.cantEntrada = cantEntrada;
    }
}