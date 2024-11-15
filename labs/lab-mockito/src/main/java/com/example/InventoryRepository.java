package com.example;

public interface InventoryRepository {
    void updateStock(Long itemId, int quantity);

    int getStock(Long itemId);
}
