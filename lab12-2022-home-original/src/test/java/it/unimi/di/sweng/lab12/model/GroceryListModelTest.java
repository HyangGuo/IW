package it.unimi.di.sweng.lab12.model;

import it.unimi.di.sweng.lab12.Observer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


class GroceryListModelTest {
    @Test
    void storeDateTest(){
        GroceryListModel model = new GroceryListModel();
        Grocery goods = new Grocery("mele",2);
        model.addDaComprare(goods);
        assertThat(model.getListDaComprare().contains(goods)).isTrue();
    }
    @Test
    void editDateTest(){
        GroceryListModel model = new GroceryListModel();
        Grocery goods = new Grocery("mele",1);
        model.addDaComprare(goods);
        model.addDaComprare(goods);
        model.reduceDaComprare(0);
        model.reduceDaComprare(0);
        assertThat(model.getListDaComprare().size()).isEqualTo(0);

    }
    @Test
    void listComprateTest(){
        GroceryListModel model = new GroceryListModel();
        Grocery mele = new Grocery("mele",3);
        model.addDaComprare(mele);
        model.reduceDaComprare(0);
        model.reduceDaComprare(0);
        model.reduceDaComprare(0);
        assertThat(model.getListComprate().get(0).getNumber()).isEqualTo(3);
    }
    @Test
    void testNotifyObservers(){
        Observer obs = mock(Observer.class);
        Observer obs1 = mock(Observer.class);
        GroceryListModel model = new GroceryListModel();
        model.addObserver(obs);
        model.addObserver(obs1);

        model.addDaComprare(new Grocery("pere",1));

        verify(obs).update();
        verify(obs1).update();
    }
}