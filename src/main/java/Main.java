import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import serviceAskQuestions.ServiceAsk;
import serviceLoadQuestions.CsvLoadServiceImpl;
import serviceLoadQuestions.TestItemsLoadService;

import java.io.IOException;

@ComponentScan(basePackages = ".")
@PropertySource("classpath:prop.properties")
@Configuration
public class Main {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public TestItemsLoadService loadService() {
        return new CsvLoadServiceImpl();
    }


 /*   @Bean
    public ServiceAsk serviceAsk(TestItemsLoadService testItemsLoadService) throws IOException {
        testItemsLoadService.load();
        ServiceAsk serviceAsk = new ServiceAskImpl();
        serviceAsk.setItems(testItemsLoadService.load());
        return serviceAsk;
    }*/

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(Main.class);
        configApplicationContext.getBean(ServiceAsk.class).start();
    }
}
