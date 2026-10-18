package ftv;

import ftv.items.IItemsFactory;
import ftv.items.Vehicle;
import ftv.items.impl.Samocat;
import ftv.service.IServiceCenter;
import ftv.service.IStorage;
import ftv.ui.IUI;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = Main.class)
@DisplayName("Mock тест")
public class AppMockTest {
    @MockitoBean
    private IStorage storage;
    @MockitoBean
    private IServiceCenter serviceCenter;
    @MockitoBean
    private IUI ui;
    @MockitoBean
    private IItemsFactory itemsFactory;


    @Test
    @DisplayName("Добавление нового транспорта")
    void addInventoryItemTest() {
        App app = new App(storage, serviceCenter, ui, itemsFactory);
        Vehicle vehicle = new Samocat();

        doReturn(true).when(serviceCenter).checkVehicle(vehicle);
        doReturn(true).when(serviceCenter).registerItem(vehicle);
        assertTrue(app.addInventoryItem(vehicle));

        verify(serviceCenter).registerItem(vehicle);
        verify(serviceCenter).checkVehicle(vehicle);
    }
}
