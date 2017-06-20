package codigohernancho.app.prueba.com.inventariodecompras;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CREAR extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editSKU;
    EditText editNombre;
    EditText editMarca;
    EditText editUnidad;
    EditText editFoto;
    EditText editAlerta_Min_Stock_SP;
    EditText editAlerta_Max_Stock_SP;
    EditText editAlerta_Low_Consump_Quantity_SP;
    EditText editAlerta_Low_Consump_Time_Dias_SP;
    EditText editAlerta_Inactivity_Time_Dias_SP;
    EditText editAlerta_Expiration_Dias_Before_SP;
    EditText editMonitor_Alertas;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        myDB = new DatabaseHelper(this);

        editSKU = (EditText) findViewById(R.id.editText_SKU);
        editNombre = (EditText) findViewById(R.id.editText_Nombre);
        editMarca = (EditText) findViewById(R.id.editText_Marca);
        editUnidad = (EditText) findViewById(R.id.editText_Unidad);
        //  editFoto = (EditText) findViewById(R.id.editText_Foto);
        editAlerta_Min_Stock_SP = (EditText) findViewById(R.id.editText_Alerta_Min_Stock);
        editAlerta_Max_Stock_SP = (EditText) findViewById(R.id.editText_Alerta_Max_Stock);
        editAlerta_Low_Consump_Quantity_SP = (EditText) findViewById(R.id.editText_Alerta_Low_Consump_Quantity_SP);
        editAlerta_Low_Consump_Time_Dias_SP = (EditText) findViewById(R.id.editText_Alerta_Low_Consump_Time_Dias_SP);
        editAlerta_Inactivity_Time_Dias_SP = (EditText) findViewById(R.id.editText_Alerta_Inactivity_Time_Dias_SP);
        editAlerta_Expiration_Dias_Before_SP = (EditText) findViewById(R.id.editText_Alerta_Expiration_Dias_Before_SP);
        editMonitor_Alertas = (EditText) findViewById(R.id.editText_Nombre);
        btnAddData = (Button) findViewById(R.id.button_Insert_Data);
        AddData();
    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insertData(
                                Integer.parseInt(editSKU.getText().toString()),
                                editNombre.getText().toString(),
                                editMarca.getText().toString(),
                                editUnidad.getText().toString(),
                                Integer.parseInt(editAlerta_Min_Stock_SP.getText().toString()),
                                Integer.parseInt(editAlerta_Max_Stock_SP.getText().toString()),
                                Integer.parseInt(editAlerta_Low_Consump_Quantity_SP.getText().toString()),
                                Integer.parseInt(editAlerta_Low_Consump_Time_Dias_SP.getText().toString()),
                                Integer.parseInt(editAlerta_Inactivity_Time_Dias_SP.getText().toString()),
                                Integer.parseInt(editAlerta_Expiration_Dias_Before_SP.getText().toString()));
                        if(isInserted == true)
                            Toast.makeText(CREAR.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(CREAR.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}