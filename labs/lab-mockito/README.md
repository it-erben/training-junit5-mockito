# Aufgabe: Lagerbestandsverwaltung mit Benachrichtigungen

## Szenario
Ein System zur Lagerbestandsverwaltung nutzt einen `InventoryService`, der Bestände in Echtzeit aktualisiert. Der Service interagiert mit zwei Abhängigkeiten:

- `InventoryRepository`: Verwaltung der Bestandsdaten
- `WarehouseService`: Sendet Bestellungen zur Auffüllung des Lagerbestands und benachrichtigt das Lager

Der `InventoryService` hat folgende Methoden:

```java
void restockItem(Long itemId, int quantity);
```
Fügt eine gegebene Menge eines Artikels zum Lagerbestand hinzu und benachrichtigt das Lager über die Auffüllung.
- Wirft `IllegalArgumentException` bei ungültiger Menge
- Wirft `InventoryProcessingException` bei Verarbeitungsfehlern

```java
int getAvailableStock(Long itemId);
```
Gibt die verfügbare Menge eines Artikels im Lagerbestand zurück.
- Wirft `InventoryProcessingException` bei Verarbeitungsfehlern

```java
void shipItem(Long itemId, int quantity);
```
Reduziert die Menge eines Artikels um die angeforderte Menge und benachrichtigt das Lager über den Versand.
- Wirft `IllegalArgumentException` bei ungültiger Menge
- Wirft `InsufficientStockException` bei nicht ausreichendem Bestand
- Wirft `InventoryProcessingException` bei Verarbeitungsfehlern

## Aufgabe
Schreiben Sie Tests für den `InventoryService`, die folgende Szenarien abdecken:

### 1. Test für erfolgreiche Auffüllung (restockItem)
- Stellen Sie sicher, dass `InventoryRepository.updateStock` aufgerufen wird und die korrekte Menge hinzugefügt wird
- Verifizieren Sie, dass `WarehouseService.notifyRestock` mit der Artikel-ID und der hinzugefügten Menge aufgerufen wird

### 2. Test für ungültige Menge (restockItem)
- Simulieren Sie einen Aufruf von `restockItem` mit einer Menge von 0 oder einer negativen Zahl
- Stellen Sie sicher, dass eine `IllegalArgumentException` geworfen wird
- Verifizieren Sie, dass `InventoryRepository.updateStock` und `WarehouseService.notifyRestock` nicht aufgerufen werden

### 3. Test für erfolgreichen Versand (shipItem)
- Stellen Sie sicher, dass `InventoryRepository.updateStock` aufgerufen wird, um die Menge zu reduzieren
- Verifizieren Sie, dass `WarehouseService.notifyShipment` mit der Artikel-ID und der versandten Menge aufgerufen wird

### 4. Test für Ausnahmefälle
- Simulieren Sie eine `RuntimeException` in `InventoryRepository.updateStock` 
- Verifizieren Sie, dass eine `InventoryProcessingException` geworfen wird, wenn nun `InventoryRepository.restockItem` aufgerufen wird
