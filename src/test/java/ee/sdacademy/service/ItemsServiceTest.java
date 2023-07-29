package ee.sdacademy.service;

import ee.sdacademy.models.Items;
import ee.sdacademy.models.ShoppingLists;
import ee.sdacademy.repository.ItemsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemsServiceTest {
    @Mock
    private ItemsRepository itemsRepository;

    private ItemsService itemsService;

    @BeforeEach
    public void init() {
        itemsService = new ItemsService(itemsRepository);
    }

    @Test
    void test_getAll() {
        var expectedResult = new ArrayList<Items>();
        var items = new Items();
        var shoppingLists = new ShoppingLists();

        shoppingLists.setName("New List");

        items.setShoppingList(shoppingLists);
        items.setName("kurk");
        items.setQuantity(BigDecimal.valueOf(2));

        expectedResult.add(items);

        when(itemsRepository.getAll()).thenReturn(expectedResult);

        var result = itemsService.getAll();

        assertEquals(expectedResult, result);
    }

    @Test
    public void test_save() {
        var shoppingLists = new ShoppingLists();
        shoppingLists.setName("New List");

        var items = new Items();
        items.setShoppingList(shoppingLists);
        items.setName("kurk");
        items.setQuantity(BigDecimal.valueOf(2));

        itemsService.save(items);

        var itemName = "kurk";
        var quantity = BigDecimal.valueOf(2);

        assertEquals(itemName, items.getName());
        assertEquals(quantity, items.getQuantity());
    }

    @Test
    public void test_delete() {
        var shoppingLists = new ShoppingLists();
        shoppingLists.setName("New List");

        var items = new Items();
        items.setShoppingList(shoppingLists);
        items.setName("kurk");
        items.setQuantity(BigDecimal.valueOf(2));
        itemsService.delete(items);

        verify(itemsRepository, times(1)).delete(items);
    }
}