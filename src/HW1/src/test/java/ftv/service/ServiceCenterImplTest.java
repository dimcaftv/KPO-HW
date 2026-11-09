package ftv.service;

import ftv.items.impl.Samocat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты реализации ServiceCenter")
public class ServiceCenterImplTest {
    private final IServiceCenter serviceCenter = new ServiceCenter(0, 0); // 0, 0 чтобы всегда проходило проверки

    @Test
    @DisplayName("Генерация нового id")
    void getNewIdTest() {
        assertDoesNotThrow(serviceCenter::getNewId);
    }

    @Test
    @DisplayName("Регистрация нового предмета")
    void registerItemTest() {
        var vehicle = new Samocat();
        assertTrue(serviceCenter.registerItem(vehicle));
        assertFalse(serviceCenter.registerItem(vehicle));
    }

    @Test
    @DisplayName("Техосмотр транспорта")
    void checkVehicleTest() {
        var vehicle = new Samocat();
        assertTrue(serviceCenter.checkVehicle(vehicle));
    }

    @Test
    @DisplayName("Доступность транспорта для новичков")
    void beginnerCheckTest() {
        var vehicle = new Samocat();
        assertTrue(serviceCenter.beginnerCheck(vehicle));
    }
}
