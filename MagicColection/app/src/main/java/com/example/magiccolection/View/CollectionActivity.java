package com.example.magiccolection.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.magiccolection.Controller.CardsController;
import com.example.magiccolection.Model.Cards;
import com.example.magiccolection.R;

import java.util.List;


public class CollectionActivity extends AppCompatActivity {

    List<Cards> cardsList;
    TableLayout idTable;

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
        cardsList = cardControl.getDataList();
        cards = new Cards();

        idName = findViewById(R.id.idName);
        idType = findViewById(R.id.idType);
        idColor = findViewById(R.id.idColor);
        idRarity = findViewById(R.id.idRarity);

        BtnAdd = findViewById(R.id.idBtnAdd);

        idTable = findViewById(R.id.idTable);


        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cards.setName(idName.getText().toString());
                cards.setType(idType.getText().toString());
                cards.setColor(idColor.getText().toString());
                cards.setRarity(idRarity.getText().toString());

                cardControl.Adicionar(cards);

                idName.setText("");
                idType.setText("");
                idColor.setText("");
                idRarity.setText("");

            }
        });

        for (Cards card : cardsList){

            TableRow tableRow = new TableRow(this);

            TextView textView = new TextView(this);
            textView.setText(card.getName());
            textView.setTextSize(18);
            textView.setBackgroundResource(R.drawable.border);

            Button BtnDel = new Button(this);
            BtnDel.setText("X");
            BtnDel.setTextSize(18);
            BtnDel.setTextColor(Color.parseColor("#CCCCCC"));
            BtnDel.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#AA0C00")));

            Button BtnDetail = new Button(this);
            BtnDetail.setText("+");
            BtnDetail.setTextSize(18);
            BtnDetail.setTextColor(Color.parseColor("#CCCCCC"));

            tableRow.addView(textView);
            tableRow.addView(BtnDel);
            tableRow.addView(BtnDetail);

            idTable.addView(tableRow);
        }

    }
}