package com.example.magiccolection.Controller;

import com.example.magiccolection.Model.Collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionController {

    public List collectionList;

    public List getCollectionList(){

        collectionList = new ArrayList<Collection>();

        collectionList.add(new Collection("Lost Caverns of Ixalan"));

        return collectionList;
    }

    public ArrayList<String> dataSpinner(){

        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < getCollectionList().size(); i++) {

            Collection objeto = (Collection) getCollectionList().get(i);

            data.add(objeto.getCollectionName());


        }

        return data;
    }

}
