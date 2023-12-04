package com.example.magiccolection.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.magiccolection.Model.Cards;

import java.util.ArrayList;
import java.util.List;

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

    public void saveCard(String tabela, ContentValues data){

        db.insert(tabela, null , data);

    }

    public List<Cards> dataListener(){

        List<Cards> list = new ArrayList<>();

        Cards registro;

        String querySql = "SELECT * FROM collection";

        cursor = db.rawQuery(querySql, null);

        if(cursor.moveToFirst()){
            do {
                registro = new Cards();

                registro.setId(cursor.getInt(0));
                registro.setName(cursor.getString(1));
                registro.setColor(cursor.getString(2));
                registro.setType(cursor.getString(3));
                registro.setRarity(cursor.getString(4));
                list.add(registro);

            }while(cursor.moveToNext());
        }else{}

        return list;
    }
}
