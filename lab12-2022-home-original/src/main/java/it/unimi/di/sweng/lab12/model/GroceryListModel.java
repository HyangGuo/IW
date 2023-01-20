package it.unimi.di.sweng.lab12.model;

import it.unimi.di.sweng.lab12.Observable;
import it.unimi.di.sweng.lab12.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class GroceryListModel implements Observable {
    private final List<Grocery> listDaComprare;
    private final List<Grocery> listComprate;
    List<Observer> observers;

    public GroceryListModel(){
        listDaComprare = new ArrayList<>();
        listComprate = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addDaComprare(Grocery goods) {
        for (Grocery grocery: listDaComprare){
            if (goods.getName().equals(grocery.getName())){
                grocery.setNumber(grocery.getNumber()+goods.getNumber());
                notifyObservers();
                return;
            }
        }

        listDaComprare.add(goods);
        notifyObservers();
    }

    public List<Grocery> getListDaComprare() {
        return listDaComprare;
    }

    public void reduceDaComprare(int index) {
        String name = listDaComprare.get(index).getName();
        if (listDaComprare.get(index).getNumber() == 1){
            listDaComprare.remove(index);
            notifyObservers();
        }else {
            listDaComprare.get(index).setNumber(listDaComprare.get(index).getNumber()-1);
        }
        setListComprate(name);
        notifyObservers();
    }

    public List<Grocery> getListComprate() {
        return listComprate;
    }
    public void setListComprate(String name){
        for (int i = 0;i < listComprate.size();i++){
            if (listComprate.get(i).getName().equals(name)){
                listComprate.set(i,new Grocery(name, listComprate.get(i).getNumber()+1));
                notifyObservers();
                return;
            }
        }
        listComprate.add(new Grocery(name, 1));
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers){
            observer.update();
        }
    }
    @Override
    public void addObserver(@NotNull Observer obs) {
        observers.add(obs);
    }
}
