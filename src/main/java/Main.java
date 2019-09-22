import model.TestItem;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import serviceAskQuestions.ServiceAsk;
import serviceLoadQuestions.TestItemsLoadService;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        //List<TestItem> items = context.getBean(TestItemsLoadService.class).load();
        //((ServiceAsk)context.getBean("askService")).start(items);
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(Config.class);
        configApplicationContext.refresh();
        List<TestItem> items = configApplicationContext.getBean(TestItemsLoadService.class).load();
        ((ServiceAsk)configApplicationContext.getBean(ServiceAsk.class)).start(items);
    }
}
