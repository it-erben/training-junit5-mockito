package com.example;

// InventoryService.java
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final WarehouseService warehouseService;

    public InventoryService(InventoryRepository inventoryRepository, WarehouseService warehouseService) {
        this.inventoryRepository = inventoryRepository;
        this.warehouseService = warehouseService;
    }

    public void restockItem(Long itemId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        try {
            inventoryRepository.updateStock(itemId, quantity);
            warehouseService.notifyRestock(itemId, quantity);
        } catch (Exception e) {
            throw new InventoryProcessingException("Failed to restock item: " + itemId, e);
        }
    }

    public int getAvailableStock(Long itemId) {
        try {
            return inventoryRepository.getStock(itemId);
        } catch (Exception e) {
            throw new InventoryProcessingException("Failed to get stock for item: " + itemId, e);
        }
    }

    public void shipItem(Long itemId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }

        try {
            int currentStock = inventoryRepository.getStock(itemId);
            if (currentStock < quantity) {
                throw new InsufficientStockException("Not enough stock available");
            }

            inventoryRepository.updateStock(itemId, -quantity);
            warehouseService.notifyShipment(itemId, quantity);

            // Check if stock is low after shipment
            int remainingStock = currentStock - quantity;
            if (remainingStock < 5) { // Assuming 5 is the low stock threshold
                warehouseService.notifyLowStock(itemId, remainingStock);
            }
        } catch (Exception e) {
            throw new InventoryProcessingException("Failed to ship item: " + itemId, e);
        }
    }
}

// Custom exceptions
class InventoryProcessingException extends RuntimeException {
    public InventoryProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}
