package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.Observer;
import it.unimi.di.sweng.lab12.model.GroceryListModel;
import it.unimi.di.sweng.lab12.view.CommandView;
import org.jetbrains.annotations.NotNull;


public class CommandPresenter implements Observer ,InputPresenter{

    private final GroceryListModel model;
    private final CommandView commandView;
    private final CommandView commandView2;
    private final int max;

    public CommandPresenter(@NotNull GroceryListModel model, @NotNull CommandView commandView, @NotNull CommandView commandView2,int max) {
        this.model = model;
        this.commandView = commandView;
        this.commandView2 = commandView2;
        this.max = max;
        model.addObserver(this);
        commandView.addHandlers(this);
        commandView2.addHandlers(this);

        for (int i =0; i <max;i++){
            commandView.set(i,"---");
            commandView2.set(i,"---");
        }
    }

    @Override
    public void update() {
        for (int i=0; i < model.getListDaComprare().size();i++){
            commandView.set(i,model.getListDaComprare().get(i).getName());
            commandView2.set(i,model.getListDaComprare().get(i).getName());
        }
        for (int i = model.getListDaComprare().size();i <max;i++){
            commandView.set(i,"---");
            commandView2.set(i,"---");
        }
    }
    @Override
    public void action(int num, @NotNull String text) {
        if(!(commandView.get(num).equals("---") ||commandView2.get(num).equals("---"))){
            model.reduceDaComprare(num);
        }

    }
}
