package codigohernancho.app.prueba.com.inventariodecompras.gui.agregar_editar_producto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import codigohernancho.app.prueba.com.inventariodecompras.R;
import codigohernancho.app.prueba.com.inventariodecompras.gui.productos.ActividadProductos;

/**
 * Created by urreal on 05/06/2017.
 */

public class ActividadAgregarEditar extends AppCompatActivity{
    public static final int REQUEST_ADD_PRODUCTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_editar_actividad);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String productoId = getIntent().getStringExtra(ActividadProductos.EXTRA_PRODUCTO_ID);

        setTitle(productoId == null ? "Añadir producto" : "Editar producto");

        FragmentoAgregarEditar fragmentoAgregarEditar = (FragmentoAgregarEditar)
                getSupportFragmentManager().findFragmentById(R.id.add_edit_lawyer_container);
        if (fragmentoAgregarEditar == null) {
            fragmentoAgregarEditar = FragmentoAgregarEditar.newInstance(productoId);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.add_edit_lawyer_container, fragmentoAgregarEditar)
                    .commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
