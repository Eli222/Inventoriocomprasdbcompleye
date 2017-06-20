package codigohernancho.app.prueba.com.inventariodecompras;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import codigohernancho.app.prueba.com.inventariodecompras.gui.agregar_editar_producto.ActividadAgregarEditar;
import codigohernancho.app.prueba.com.inventariodecompras.gui.detalle_producto.ActividadDetalleProducto;
import codigohernancho.app.prueba.com.inventariodecompras.gui.productos.ActividadProductos;
import codigohernancho.app.prueba.com.inventariodecompras.gui.productos.ProductosCursorAdapter;
import codigohernancho.app.prueba.com.inventariodecompras.sqlite.ContratoInventario.ProductoEntrada;
import codigohernancho.app.prueba.com.inventariodecompras.sqlite.OperacionesBaseDatos;

/**
 * Created by urreal on 05/06/2017.
 */

public class FragmentoProductos2 extends Fragment {

    public static final int REQUEST_UPDATE_DELETE_PRODUCT = 2;
    private OperacionesBaseDatos mOperacionesBaseDatos;

    private ListView mProductosLista;
    private ProductosCursorAdapter mProductosAdapter;
    private FloatingActionButton mBtnAgregar;

    public FragmentoProductos2(){
        // Required empty public constructor
    }

    public static FragmentoProductos2 newInstance() {return new FragmentoProductos2();}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento_productos, container, false);

        // Referencias UI
        mProductosLista = (ListView) root.findViewById(R.id.lawyers_list);
        mProductosAdapter = new ProductosCursorAdapter(getActivity(), null);
        mBtnAgregar = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        // Setup
        mProductosLista.setAdapter(mProductosAdapter);

        // Eventos
        mProductosLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor currentItem = (Cursor) mProductosAdapter.getItem(i);
                String currentProductoId = currentItem.getString(
                        currentItem.getColumnIndex(ProductoEntrada.ID));

                showDetailScreen(currentProductoId);
            }
        });
        mBtnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddScreen();
            }
        });


        getActivity().deleteDatabase(OperacionesBaseDatos.DATABASE_NAME);

        // Instancia de helper
        mOperacionesBaseDatos = new OperacionesBaseDatos(getActivity());

        // Carga de datos
        loadProductos();

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Activity.RESULT_OK == resultCode) {
            switch (requestCode) {
                case ActividadAgregarEditar.REQUEST_ADD_PRODUCTO:
                    showSuccessfullSavedMessage();
                    loadProductos();
                    break;
                case REQUEST_UPDATE_DELETE_PRODUCT:
                    loadProductos();
                    break;
            }
        }
    }

    private void loadProductos() {
        new ProductoLoadTask().execute();
    }

    private void showSuccessfullSavedMessage() {
        Toast.makeText(getActivity(),
                "Producto guardado correctamente", Toast.LENGTH_SHORT).show();
    }

    private void showAddScreen() {
        Intent intent = new Intent(getActivity(), ActividadAgregarEditar.class);
        startActivityForResult(intent, ActividadAgregarEditar.REQUEST_ADD_PRODUCTO);
    }

    private void showDetailScreen(String productoId) {
        Intent intent = new Intent(getActivity(), ActividadDetalleProducto.class);
        intent.putExtra(ActividadProductos.EXTRA_PRODUCTO_ID, productoId);
        startActivityForResult(intent, REQUEST_UPDATE_DELETE_PRODUCT);
    }

    private class ProductoLoadTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return mOperacionesBaseDatos.getAllProductos();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                mProductosAdapter.swapCursor(cursor);
            } else {
                // Mostrar empty state
            }
        }
    }

}
