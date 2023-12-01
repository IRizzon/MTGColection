package com.example.magiccolection.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.magiccolection.Controller.CardsController;
import com.example.magiccolection.Model.Cards;
import com.example.magiccolection.R;


public class CollectionActivity extends AppCompatActivity {

    CardsController cardControl;

    Cards cards;

    EditText idName;
    EditText idType;
    EditText idColor;
    EditText idRarity;

    Button BtnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        cardControl = new CardsController(CollectionActivity.this);
        cards = new Cards();

        idName = findViewById(R.id.idName);
        idType = findViewById(R.id.idType);
        idColor = findViewById(R.id.idColor);
        idRarity = findViewById(R.id.idRarity);

        BtnAdd = findViewById(R.id.idBtnAdd);

        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cards.setName(idName.getText().toString());
                cards.setType(idType.getText().toString());
                cards.setColor(idColor.getText().toString());
                cards.setRarity(idRarity.getText().toString());

                cardControl.Adicionar(cards);

            }
        });

    }
}