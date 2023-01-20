package it.unimi.di.sweng.lab12.presenter;

import it.unimi.di.sweng.lab12.model.Grocery;
import it.unimi.di.sweng.lab12.model.GroceryListModel;
import it.unimi.di.sweng.lab12.view.InputView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class PresenterInputTest {
    @Test
    void presentInputTest(){
        InputView inputView = mock(InputView.class);
        GroceryListModel model = new GroceryListModel();
        model.addDaComprare(new Grocery("pere",2));
        PresenterInput presenterInput = new PresenterInput(model,inputView,8);
        presenterInput.action(5,"pere");
        assertThat(model.getListDaComprare().get(0).getNumber()).isEqualTo(7);
    }
}