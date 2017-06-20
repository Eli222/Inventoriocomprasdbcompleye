package codigohernancho.app.prueba.com.inventariodecompras.sqlite;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.UUID;

import codigohernancho.app.prueba.com.inventariodecompras.sqlite.ContratoInventario.ProductoEntrada;

/**
 * Created by urreal on 26/05/2017.
 */

public class Producto {

    public String id;
    public String nombre;
    public String descripcion;
    public String fechaCreacion;
    public String cantidad;
    public String imgProd;
    public Integer estado;

    public Producto(String nombre, String descripcion, String fechaCreacion, String cantidad, String imgProd, Integer estado) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.cantidad = cantidad;
        this.imgProd = imgProd;
        this.estado = estado;
    }

    public  Producto(Cursor cursor){
        id=cursor.getString(cursor.getColumnIndex(ProductoEntrada.ID));
        nombre=cursor.getString(cursor.getColumnIndex(ProductoEntrada.NOMBRE));
        descripcion=cursor.getString(cursor.getColumnIndex(ProductoEntrada.DESCRIPCION));
        fechaCreacion=cursor.getString(cursor.getColumnIndex(ProductoEntrada.FECHA_CREACION));
        cantidad=cursor.getString(cursor.getColumnIndex(ProductoEntrada.CANTIDAD));
        imgProd=cursor.getString(cursor.getColumnIndex(ProductoEntrada.IMG_PROD));
        estado=cursor.getInt(cursor.getColumnIndex(ProductoEntrada.ESTADO));
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(ProductoEntrada.ID, id);
        values.put(ProductoEntrada.NOMBRE, nombre);
        values.put(ProductoEntrada.DESCRIPCION, descripcion);
        values.put(ProductoEntrada.FECHA_CREACION, fechaCreacion);
        values.put(ProductoEntrada.CANTIDAD, cantidad);
        values.put(ProductoEntrada.IMG_PROD, imgProd);
        values.put(ProductoEntrada.ESTADO, estado);
        return values;
    }

    public  String getId(){return id;}
    public  String getNombre(){return nombre;}
    public  String getDescripcion() {return descripcion;}
    public  String getFechaCreacion() {return fechaCreacion;}
    public  String getCantidad() {return  cantidad;}
    public  String getImgProd() {return imgProd;}
    public  Integer getEstado() {return estado;}

}