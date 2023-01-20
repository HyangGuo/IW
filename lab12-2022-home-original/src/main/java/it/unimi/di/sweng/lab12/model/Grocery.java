package it.unimi.di.sweng.lab12.model;

public class Grocery {
    private String name;
    private int number;

    public Grocery(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public String toString(){
        return this.name+"  "+this.number;
    }
}
