package students;

import students.config.Config;
import org.springframework.context.annotation.*;
import students.serviceAskQuestions.ServiceAsk;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(Config.class);
        configApplicationContext.getBean(ServiceAsk.class).start();
    }

}
