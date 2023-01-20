package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.Observer;
import it.unimi.di.sweng.lab12.model.GroceryListModel;
import it.unimi.di.sweng.lab12.view.DisplayView;
import org.jetbrains.annotations.NotNull;

public class DisplayPresenter implements Observer {
    private final GroceryListModel model;
    private final DisplayView displayView;
    private final DisplayView displayView2;
    private final int max;

    public DisplayPresenter(@NotNull GroceryListModel model, DisplayView displayView, DisplayView displayView2,int max) {
        this.model = model;
        this.displayView = displayView;
        this.displayView2 = displayView2;
        this.max = max;
        model.addObserver(this);
        for (int i =0; i <max;i++){
            displayView.set(i,"---");
            displayView2.set(i,"---");
        }

    }

    @Override
    public void update() {
        for (int i=0; i < model.getListDaComprare().size();i++){
            displayView.set(i,model.getListDaComprare().get(i).toString());
        }
        for (int i=0; i < model.getListComprate().size();i++){
            displayView2.set(i,model.getListComprate().get(i).toString());
        }
        for (int i = model.getListDaComprare().size();i <max;i++){
            displayView.set(i,"---");
        }
        for (int i = model.getListComprate().size();i <max;i++){
            displayView2.set(i,"---");
        }
    }
}
