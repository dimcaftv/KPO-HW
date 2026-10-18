package ftv;

import ftv.items.IInventoryItem;
import ftv.items.IItemsFactory;
import ftv.items.ItemsFactory;
import ftv.items.impl.Bicycle;
import ftv.items.impl.ElectroBicycle;
import ftv.items.impl.Headphones;
import ftv.items.impl.Samocat;
import ftv.service.IServiceCenter;
import ftv.service.IStorage;
import ftv.service.ServiceCenter;
import ftv.ui.IUI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Main.class)
@DisplayName("Интеграционные тесты приложения")
public class AppIntegrationTest {
    @Autowired
    private IStorage storage;
    private IServiceCenter serviceCenter = new ServiceCenter(0, 0); // 0 чтобы рандом не влиял на тесты
    private IItemsFactory itemsFactory = new ItemsFactory();
    @MockitoBean
    private IUI ui;

    @Test
    @DisplayName("Проверка всех фукнций App")
    void test() {
        App app = new App(storage, serviceCenter, ui, itemsFactory);

        List<IInventoryItem> items = List.of(new Bicycle(), new ElectroBicycle(), new Headphones(), new ElectroBicycle(), new Samocat());

        assertEquals(5, app.addItems(items));
        assertTrue(app.getEnergyConsumption() > 0);
        assertEquals(4, app.getBeginnerVehicles().size());
        assertEquals(5, app.getInventoryItems().size());
    }
}
