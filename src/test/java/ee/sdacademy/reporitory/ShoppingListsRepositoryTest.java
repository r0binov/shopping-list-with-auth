package ee.sdacademy.reporitory;

import ee.sdacademy.models.ShoppingLists;
import ee.sdacademy.repository.ShoppingListsRepository;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class ShoppingListsRepositoryTest {

    @Test
    public void test_save() {
        ShoppingListsRepository shoppingListsRepository = new ShoppingListsRepository();
        ShoppingLists shoppingLists = new ShoppingLists();
        shoppingLists.setName("New List");
        shoppingLists.setUser(1);
        ShoppingListsRepository.save(shoppingLists);
        assertEquals("New List", shoppingLists.getName());
    }

    @Test
    public void test_getAll() {
        ShoppingListsRepository shoppingListsRepository = new ShoppingListsRepository();
        ShoppingLists shoppingLists = new ShoppingLists();
        shoppingLists.setName("New List");
        shoppingLists.setUser(1);
        shoppingListsRepository.getAll();
        assertEquals("New List", shoppingListsRepository.getAll());
    }

    @Test
    public void test_delete() {
        ShoppingListsRepository shoppingListsRepository = new ShoppingListsRepository();
        ShoppingLists shoppingLists = new ShoppingLists();
        shoppingLists.setName("New List");
        ShoppingListsRepository.delete(shoppingLists);
        assertNull(shoppingLists);
    }
}
