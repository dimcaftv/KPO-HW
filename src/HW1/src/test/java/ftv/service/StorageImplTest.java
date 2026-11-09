package ftv.service;

import ftv.items.impl.Headphones;
import ftv.items.impl.Helmet;
import ftv.items.impl.Samocat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тесты реализации Storage")
public class StorageImplTest {
    @Test
    @DisplayName("Добавление предмета")
    void addItemTest() {
        final IStorage storage = new Storage();
        assertDoesNotThrow(() -> storage.addItem(new Helmet(UUID.randomUUID())));
    }

    @Test
    @DisplayName("Список всех предметов")
    void getItemsTest() {
        final IStorage storage = new Storage();
        storage.addItem(new Helmet(UUID.randomUUID()));
        storage.addItem(new Headphones(UUID.randomUUID()));
        assertEquals(2, storage.getItems().size());
    }

    @Test
    @DisplayName("Список транспорта")
    void getVehiclesTest() {
        final IStorage storage = new Storage();
        storage.addItem(new Helmet(UUID.randomUUID()));
        storage.addItem(new Samocat(UUID.randomUUID()));
        assertEquals(1, storage.getVehicles().size());
    }

    @Test
    @DisplayName("Получение предмета по id")
    void getItemTest() {
        final IStorage storage = new Storage();
        var item = new Helmet(UUID.randomUUID());
        storage.addItem(item);
        assertEquals(item, storage.getItem(item.getId()));

    }

}
