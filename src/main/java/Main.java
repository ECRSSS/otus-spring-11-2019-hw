import model.TestItem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import serviceAskQuestions.ServiceAsk;
import serviceLoadQuestions.TestItemsLoadService;

import java.io.IOException;
import java.util.List;

@PropertySource("classpath:prop.properties")
@Configuration
@ComponentScan(basePackageClasses = {TestItemsLoadService.class,ServiceAsk.class})
public class Main {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        List<TestItem> items = context.getBean(TestItemsLoadService.class).load();
        ((ServiceAsk)context.getBean("askService")).start(items);
        ServiceAsk service = context.getBean(ServiceAsk.class);
        service.start(items);
    }
}
