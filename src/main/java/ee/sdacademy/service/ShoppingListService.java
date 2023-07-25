package ee.sdacademy.service;

import ee.sdacademy.models.ShoppingLists;
import ee.sdacademy.repository.ShoppingListsRepository;

import java.util.List;

public class ShoppingListService {

    private final ShoppingListsRepository shoppingListsRepository;

    public ShoppingListService(ShoppingListsRepository shoppingListsRepository) {
        this.shoppingListsRepository = shoppingListsRepository;
    }

    public void save(ShoppingLists shoppingLists) {
        shoppingListsRepository.save(shoppingLists);
    }

    public List<ShoppingLists> getAll() {
        return shoppingListsRepository.getAll();
    }

    public void delete(ShoppingLists shoppingLists) {
        shoppingListsRepository.delete(shoppingLists);
    }
}
