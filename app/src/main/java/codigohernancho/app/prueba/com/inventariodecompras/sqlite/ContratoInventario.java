package codigohernancho.app.prueba.com.inventariodecompras.sqlite;

import android.provider.BaseColumns;

/**
 * Created by urreal on 25/05/2017.
 */

public class ContratoInventario{
    public static abstract class ProductoEntrada implements BaseColumns{
        public static  final String TABLE_NAME = "producto";

        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String DESCRIPCION = "descripcion";
        public static final String FECHA_CREACION = "fecha_creacion";
        public static final String CANTIDAD = "cantidad";
        public static final String IMG_PROD = "imgProd";
        public static final String ESTADO = "estado";
    }

}

