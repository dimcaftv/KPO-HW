package ftv;

import ftv.infrastructure.ui.ConsoleUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = SpringApplication.run(Main.class)) {
            context.getBean(ConsoleUI.class).run();
        }
    }
}
