package com.example.magiccolection.Model;

public class Cards {

    private int id;
    private String Name;
    private String Type;
    private String Color;
    private String Rarity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        this.Color = color;
    }

    public String getRarity() {
        return Rarity;
    }

    public void setRarity(String rarity) {
        this.Rarity = rarity;
    }
}
