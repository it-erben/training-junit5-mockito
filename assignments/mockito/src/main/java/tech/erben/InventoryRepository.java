package tech.erben;

public interface InventoryRepository {
    void updateStock(Long itemId, int quantity);

    int getStock(Long itemId);
}
