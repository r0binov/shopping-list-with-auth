package ee.sdacademy.repository;

import ee.sdacademy.models.ShoppingLists;
import ee.sdacademy.models.Users;
import ee.sdacademy.service.ShoppingListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ShoppingListsRepositoryTest {

    @Mock
    private ShoppingListsRepository shoppingListsRepository;

    private ShoppingListService shoppingListService;

    @BeforeEach
    public void init() {
        shoppingListService = new ShoppingListService(shoppingListsRepository);
    }

    @Test
    void test_getAll() {
        var expectedResult = new ArrayList<ShoppingLists>();
        var shoppingLists = new ShoppingLists();
        var users = new Users();

        shoppingLists.setName("TestName");

        users.setUsername("wawa");
        users.setPassword("ssss");

        expectedResult.add(shoppingLists);

        when(shoppingListsRepository.getAll()).thenReturn(expectedResult);

        var result = shoppingListService.getAll();

        assertEquals(expectedResult, result);
    }

    @Test
    public void test_save() {
        var users = new Users();
        users.setUsername("aaa");
        users.setPassword("bbbb");

        var shoppingLists = new ShoppingLists();
        shoppingLists.setUser(users);
        shoppingLists.setName("New List");

        shoppingListService.save(shoppingLists);

        var shoppingListName = "New List";

        assertEquals(shoppingListName, shoppingLists.getName());
    }

    @Test
    public void test_delete() {
        var users = new Users();
        users.setUsername("aaa");
        users.setPassword("bbbb");

        var shoppingLists = new ShoppingLists();
        shoppingLists.setUser(users);
        shoppingLists.setName("New List");

        shoppingListService.delete(shoppingLists);

        verify(shoppingListsRepository, times(1)).delete(shoppingLists);

    }
}
