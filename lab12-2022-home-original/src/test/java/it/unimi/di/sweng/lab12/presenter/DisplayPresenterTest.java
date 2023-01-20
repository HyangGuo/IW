package it.unimi.di.sweng.lab12.presenter;


import it.unimi.di.sweng.lab12.model.Grocery;
import it.unimi.di.sweng.lab12.model.GroceryListModel;

import it.unimi.di.sweng.lab12.view.DisplayView;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

class DisplayPresenterTest {
    @Test
    void  displayPresenterTest(){

        DisplayView displayView = mock(DisplayView.class);
        DisplayView displayView2 = mock(DisplayView.class);

        GroceryListModel model = new GroceryListModel();

        DisplayPresenter displayPresenter = new DisplayPresenter(model,displayView,displayView2,8);
        model.addDaComprare(new Grocery("pere",3));
        model.reduceDaComprare(0);

        verify(displayView,times(2)).set(0,model.getListDaComprare().get(0).toString());
        verify(displayView2,times(2)).set(0,model.getListComprate().get(0).toString());

    }


}