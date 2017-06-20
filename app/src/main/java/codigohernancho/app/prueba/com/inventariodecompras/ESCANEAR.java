package codigohernancho.app.prueba.com.inventariodecompras;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ESCANEAR extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView escanerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escanear);
        escanerView=new ZXingScannerView(this);
        setContentView(escanerView);
        escanerView.setResultHandler(this);
        escanerView.startCamera();
    }


    @Override
    protected void onPause() {
        super.onPause();
        escanerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Resultado del Scanner");
        builder.setMessage(result.getText());
        String codigo=result.getText().toString();
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        Intent intent1 = new Intent(ESCANEAR.this,DrawerMenu.class);
        intent1.putExtra("CODIGO", codigo);
        startActivity(intent1);
        escanerView.resumeCameraPreview(this);
    }


}
