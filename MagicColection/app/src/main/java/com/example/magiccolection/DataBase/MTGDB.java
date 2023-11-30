package com.example.magiccolection.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MTGDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "mtg_db";

    private static final int DB_Version = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public MTGDB(Context context){
        super(context, DB_NAME, null, DB_Version);

        db = getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabela = "CREATE TABLE collection(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeCarta TEXT, " +
                "corCarta TEXT, " +
                "tipoCarta TEXT, " +
                "raridade TEXT)";

        db.execSQL(sqlTabela);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void saveCard(String tabela, ContentValues dados){

        db.insert(tabela, null , dados);

    }
}
