package ftv;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    static void main() {
        var context = SpringApplication.run(Main.class);
        var app = context.getBean(App.class);

        app.run();
    }
}
