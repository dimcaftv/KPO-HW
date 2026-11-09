package ftv;

import ftv.items.IItemsFactory;
import ftv.items.ItemsFactory;
import ftv.service.IServiceCenter;
import ftv.service.IStorage;
import ftv.service.ServiceCenter;
import ftv.service.Storage;
import ftv.ui.ConsoleUI;
import ftv.ui.IUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class Config {
    @Bean
    App app(IStorage IStorage, IServiceCenter serviceCenter, IUI ui, IItemsFactory itemsFactory) {
        return new App(IStorage, serviceCenter, ui, itemsFactory);
    }

    @Bean
    IStorage storage() {
        return new Storage();
    }

    @Bean
    IServiceCenter serviceCenter() {
        return new ServiceCenter(30, 6);
    }

    @Bean
    IUI ui() {
        return new ConsoleUI();
    }

    @Bean
    IItemsFactory itemsFactory() {
        return new ItemsFactory();
    }
}
