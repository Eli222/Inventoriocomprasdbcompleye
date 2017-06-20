package codigohernancho.app.prueba.com.inventariodecompras.gui.productos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import codigohernancho.app.prueba.com.inventariodecompras.gui.detalle_producto.FragmentoProductos;
import codigohernancho.app.prueba.com.inventariodecompras.R;

/**
 * Created by urreal on 05/06/2017.
 */

public class ActividadProductos extends AppCompatActivity {
    public static final String EXTRA_PRODUCTO_ID = "extra_producto_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productos_actividad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FragmentoProductos fragment = (FragmentoProductos)
                getSupportFragmentManager().findFragmentById(R.id.lawyers_container);
        if (fragment == null) {
            fragment = FragmentoProductos.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.lawyers_container, fragment)
                    .commit();
        }
    }
}
