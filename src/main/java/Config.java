import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import serviceAskQuestions.ServiceAsk;
import serviceAskQuestions.ServiceAskImpl;
import serviceLoadQuestions.CsvLoadServiceImpl;
import serviceLoadQuestions.TestItemsLoadService;

@Configuration
public class Config {

    @Bean
    public ServiceAsk serviceAsk(){
        return new ServiceAskImpl();
    }

    @Bean
    public TestItemsLoadService loadService(){
        return new CsvLoadServiceImpl();
    }

}
