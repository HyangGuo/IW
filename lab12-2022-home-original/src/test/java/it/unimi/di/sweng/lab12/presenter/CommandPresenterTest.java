package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.model.Grocery;
import it.unimi.di.sweng.lab12.model.GroceryListModel;
import it.unimi.di.sweng.lab12.view.CommandView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class CommandPresenterTest {
    CommandView commandView;
    CommandView commandView2;
    GroceryListModel model;
    CommandPresenter commandPresenter;

    @BeforeEach
    void init(){
        commandView = mock(CommandView.class);
        commandView2 = mock(CommandView.class);
        model = mock(GroceryListModel.class);
        commandPresenter = new CommandPresenter(model,commandView,commandView2,8);

    }
    @Test
    void actionTest(){

        when(commandView.get(0)).thenReturn("pere");
        when(commandView2.get(0)).thenReturn("pere");
        commandPresenter.action(0,"pere");

        verify(model).reduceDaComprare(0);
    }
    @Test
    void updateTest(){
        List<Grocery> list = new ArrayList<>();
        list.add(new Grocery("pere",2));
        when(model.getListDaComprare()).thenReturn(list);
        commandPresenter.update();
        //initialization format "---" and update data , 16 times.
        verify(commandView,times(16)).set(anyInt(),anyString());
    }


}
