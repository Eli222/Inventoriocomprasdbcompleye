package codigohernancho.app.prueba.com.inventariodecompras;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import codigohernancho.app.prueba.com.inventariodecompras.gui.detalle_producto.FragmentoProductos;
import codigohernancho.app.prueba.com.inventariodecompras.gui.productos.ActividadProductos;


public class DrawerMenu
        extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    public static final String EXTRA_PRODUCTO_ID = "extra_producto_id";

    Button leerCodigo;
    EditText codNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        leerCodigo = (Button) findViewById(R.id.button2);
        leerCodigo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Context context = getApplicationContext();
                CharSequence text = "Enfoque la cámara hacia un Código de Barras";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Intent intent1 = new Intent(DrawerMenu.this,ESCANEAR.class);
                startActivity(intent1);
            }
                                });

        codNombre = (EditText) findViewById(R.id.codbarras);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent=getIntent();//Traemos el codigo de la activity escanear.
        Bundle extras=intent.getExtras();

        if(extras!=null){//Validamos que el codigo no venga vacio.
            String codigo=extras.getString("CODIGO");
            codNombre.setText(codigo);
        }


    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.crear) {
                Intent intent1 = new Intent(DrawerMenu.this,CREAR.class);
                startActivity(intent1);
            // Handle the camera action
        } else
            if (id == R.id.entradas) {
                Intent intent1 = new Intent(DrawerMenu.this,ENTRADAS.class);
                startActivity(intent1);

        } else if (id == R.id.salidas) {
                Intent intent1 = new Intent(DrawerMenu.this,SALIDAS.class);
                startActivity(intent1);

        } else if (id == R.id.alertas) {
                Intent intent1 = new Intent(DrawerMenu.this,ALERTAS.class);
                startActivity(intent1);

        } else if (id == R.id.informes) {
                Intent intent1 = new Intent(DrawerMenu.this,INFORMES.class);
                startActivity(intent1);

        } else if (id == R.id.configuracion) {
                Intent intent1 = new Intent(DrawerMenu.this, ActividadProductos.class);
                startActivity(intent1);

        } else if (id == R.id.usuarios) {
                Context context = getApplicationContext();
                CharSequence text = "Opción Usuarios no Configurada";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
    }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}

