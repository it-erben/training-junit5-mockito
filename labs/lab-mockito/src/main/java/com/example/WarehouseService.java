package com.example;

public interface WarehouseService {
    void notifyRestock(Long itemId, int quantity);

    void notifyShipment(Long itemId, int quantity);

    void notifyLowStock(Long itemId, int remainingStock);
}
