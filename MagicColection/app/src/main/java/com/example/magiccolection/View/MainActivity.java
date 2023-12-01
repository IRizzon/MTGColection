package com.example.magiccolection.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.magiccolection.Controller.CollectionController;
import com.example.magiccolection.Model.Collection;
import com.example.magiccolection.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    CollectionController collectionControl;
    List<String> Collection;
    Spinner spinner;

    Button idCollectAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collectionControl = new CollectionController();
        Collection = collectionControl.getCollectionList();

        spinner = findViewById(R.id.idCollectSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this, android.R.layout.simple_list_item_1, collectionControl.dataSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        idCollectAccess = findViewById(R.id.idCollectAccess);

        idCollectAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent telaColecao = new Intent(MainActivity.this, CollectionActivity.class);
                startActivity(telaColecao);
                finish();

            }
        });
    }
}