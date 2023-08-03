package ee.sdacademy.service;

import ee.sdacademy.models.Items;
import ee.sdacademy.repository.ItemsRepository;

import java.util.List;

public class ItemsService {
    private final ItemsRepository itemsRepository;

    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Items> getAll() {
        return itemsRepository.getAll();
    }

    public void save(Items items) {
        itemsRepository.save(items);
    }

    public void delete(Items items) {
        itemsRepository.delete(items);
    }
}
