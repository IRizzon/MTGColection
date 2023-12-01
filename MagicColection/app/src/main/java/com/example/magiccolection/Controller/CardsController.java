package com.example.magiccolection.Controller;

import android.content.ContentValues;
import android.content.Context;

import com.example.magiccolection.DataBase.MTGDB;
import com.example.magiccolection.Model.Cards;
import com.example.magiccolection.View.CollectionActivity;

public class CardsController extends MTGDB {


    public CardsController(CollectionActivity collectionActivity) {
        super(collectionActivity);
    }

    public void Adicionar(Cards cards){

        ContentValues data = new ContentValues();

        data.put("nomeCarta", cards.getName());
        data.put("tipoCarta", cards.getType());
        data.put("corCarta", cards.getColor());
        data.put("raridade", cards.getRarity());

        saveCard("collection", data);

    }
}
