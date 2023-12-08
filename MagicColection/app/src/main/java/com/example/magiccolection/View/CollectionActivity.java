package com.example.magiccolection.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
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

    private int selectedCardId;

    List<Cards> cardsList;
    TableLayout idTable;

    CardsController cardControl;

    Cards cards;
    Cards selectedCard;

    EditText idName;
    EditText idType;
    EditText idColor;
    EditText idRarity;

    Button BtnAdd;
    Button BtnEdit;

    private void clearFields() {
        idName.setText("");
        idType.setText("");
        idColor.setText("");
        idRarity.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        cardControl = new CardsController(CollectionActivity.this);
        cardsList = cardControl.getDataList();
        cards = new Cards();
        selectedCard = new Cards();

        idName = findViewById(R.id.idName);
        idType = findViewById(R.id.idType);
        idColor = findViewById(R.id.idColor);
        idRarity = findViewById(R.id.idRarity);

        BtnAdd = findViewById(R.id.idBtnAdd);
        BtnEdit = findViewById(R.id.idbtnEdit);

        idTable = findViewById(R.id.idTable);

        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cards.setName(idName.getText().toString());
                cards.setType(idType.getText().toString());
                cards.setColor(idColor.getText().toString());
                cards.setRarity(idRarity.getText().toString());

                cardControl.Adicionar(cards);

                clearFields();

                recreate();

            }
        });

        BtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedCard = cardControl.getCardById(selectedCardId);

                String newName = idName.getText().toString();
                String newType = idType.getText().toString();
                String newColor = idColor.getText().toString();
                String newRarity = idRarity.getText().toString();

                selectedCard.setName(newName);
                selectedCard.setType(newType);
                selectedCard.setColor(newColor);
                selectedCard.setRarity(newRarity);

                cardControl.atualizarCard(selectedCard);

                clearFields();

                recreate();
            }
        });

        for (Cards card : cardsList){

            TableRow tableRow = new TableRow(this);

            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                    0,
                    TableRow.LayoutParams.MATCH_PARENT,
                    50f
            );

            layoutParams.setMargins(10, 10, 0, 0);
            TextView textView = new TextView(this);
            textView.setText(card.getName());
            textView.setTextSize(18);
            textView.setBackgroundResource(R.drawable.border);
            textView.setGravity(Gravity.CENTER);
            textView.setLayoutParams(layoutParams);

            TableRow.LayoutParams buttonLayoutParams = new TableRow.LayoutParams(
                    0,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    20f
            );

            buttonLayoutParams.setMargins(2, 0, 0, 0);

            Button BtnDel = new Button(this);
            BtnDel.setText("X");
            BtnDel.setTextSize(18);
            BtnDel.setTextColor(Color.parseColor("#CCCCCC"));
            BtnDel.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#AA0C00")));
            BtnDel.setLayoutParams(buttonLayoutParams);

            buttonLayoutParams.setMargins(4, 0, 0, 0);

            Button BtnDetail = new Button(this);
            BtnDetail.setText("+");
            BtnDetail.setTextSize(18);
            BtnDetail.setTextColor(Color.parseColor("#CCCCCC"));
            BtnDetail.setLayoutParams(buttonLayoutParams);

            buttonLayoutParams.setMargins(2, 0, 0, 0);

            BtnDel.setTag(card.getId());
            BtnDetail.setTag(card.getId());

            BtnDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int cardId = (int) view.getTag();
                    idTable.removeView(tableRow);

                    cardControl.excluirCard(cardId);
                }
            });

            BtnDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int cardId = (int) view.getTag();

                    Cards selectedCard = cardControl.getCardById(cardId);

                    idName.setText(selectedCard.getName());
                    idType.setText(selectedCard.getType());
                    idColor.setText(selectedCard.getColor());
                    idRarity.setText(selectedCard.getRarity());

                    selectedCardId = cardId;
                }
            });

            tableRow.addView(textView);
            tableRow.addView(BtnDel);
            tableRow.addView(BtnDetail);

            idTable.addView(tableRow);
        }

    }
}