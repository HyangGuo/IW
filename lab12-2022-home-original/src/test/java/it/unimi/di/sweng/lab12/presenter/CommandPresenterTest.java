package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.model.Grocery;
import it.unimi.di.sweng.lab12.model.GroceryListModel;
import it.unimi.di.sweng.lab12.view.CommandView;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

class CommandPresenterTest {
    @Test
    void updateModelTest(){
        CommandView commandView = mock(CommandView.class);
        CommandView commandView2 = mock(CommandView.class);
        GroceryListModel model = new GroceryListModel();
        model.addDaComprare(new Grocery("pere",2));
        CommandPresenter commandPresenter = new CommandPresenter(model,commandView,commandView2,8);
        when(commandView.get(0)).thenReturn("pere");
        when(commandView2.get(0)).thenReturn("pere");
        commandPresenter.action(0,"pere");
        assertThat(model.getListComprate().get(0).getNumber()).isEqualTo(1);
    }



}