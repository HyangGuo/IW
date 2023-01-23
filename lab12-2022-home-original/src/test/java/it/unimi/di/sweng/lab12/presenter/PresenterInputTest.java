package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.model.Grocery;
import it.unimi.di.sweng.lab12.model.GroceryListModel;
import it.unimi.di.sweng.lab12.view.InputView;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class PresenterInputTest {
    @Test
    void actionTest(){
        InputView inputView = mock(InputView.class);
        GroceryListModel model = mock(GroceryListModel.class);
        PresenterInput presenterInput = new PresenterInput(model,inputView,8);
        presenterInput.action(5,"pere1");

        verify(model,times(1)).addDaComprare(any(Grocery.class));
    }
    @Test
    void  maxTest(){
        InputView inputView = mock(InputView.class);
        GroceryListModel model = new GroceryListModel();
        PresenterInput presenterInput = new PresenterInput(model,inputView,8);
        presenterInput.action(5,"pere1");
        presenterInput.action(5,"pere2");
        presenterInput.action(5,"pere3");
        presenterInput.action(5,"pere4");
        presenterInput.action(5,"pere5");
        presenterInput.action(5,"pere6");
        presenterInput.action(5,"pere7");
        presenterInput.action(5,"pere8");
        presenterInput.action(5,"pere9");

        assertThat(model.getListDaComprare().size()).isEqualTo(8);
    }

}
