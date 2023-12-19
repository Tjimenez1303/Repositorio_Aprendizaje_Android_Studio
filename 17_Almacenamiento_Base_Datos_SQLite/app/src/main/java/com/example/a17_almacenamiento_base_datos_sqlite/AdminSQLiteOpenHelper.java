package com.example.a17_almacenamiento_base_datos_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Esto se va a ejecutar una sola vez, creando la tabla VEHICULOS
        db.execSQL("create table vehiculos (\n"+
                "patente text primary key, \n"+
                "marca text, \n"+
                "modelo integer, \n"+
                "precio real \t\n"+
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
