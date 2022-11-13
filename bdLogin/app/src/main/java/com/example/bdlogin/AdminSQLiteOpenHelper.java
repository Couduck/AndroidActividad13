package com.example.bdlogin;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        //Creación de la tabla para nuestra base de datos
        baseDeDatos.execSQL("create table tblUsers(username text primary key, phoneNumber number, email text, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase baseDeDatos, int i, int i1) {

    }
}