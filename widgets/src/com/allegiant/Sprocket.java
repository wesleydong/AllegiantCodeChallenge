package com.allegiant;

import java.io.Serializable;

public class Sprocket implements Serializable  {

    private int id;
    private double price;
    private Color color;
    private double saturation;

    public Sprocket(int id, Color color, double price) {
        this.id = id;
        this.color = color;
        this.price = price;
        this.saturation = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSaturation() {
        return saturation;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }
}
