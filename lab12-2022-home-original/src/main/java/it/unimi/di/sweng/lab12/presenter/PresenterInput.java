package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.model.Grocery;
import it.unimi.di.sweng.lab12.model.GroceryListModel;
import it.unimi.di.sweng.lab12.view.InputView;
import org.jetbrains.annotations.NotNull;

public class PresenterInput implements InputPresenter {
    private final GroceryListModel model;

    private final int max;


    public PresenterInput(@NotNull GroceryListModel model, @NotNull InputView inputView, int max) {
        this.model = model;
        this.max = max;
        inputView.addHandlers(this);

    }

    @Override
    public void action(int num, @NotNull String text) {
        if ((model.getListDaComprare().size() < max) &&(num != 0) ){
            model.addDaComprare(new Grocery(text,num));
        }
    }

}
