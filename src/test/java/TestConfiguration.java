import localizationService.LocalizationService;
import localizationService.LocalizationServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import serviceAskQuestions.ServiceAsk;
import serviceAskQuestions.ServiceAskImpl;
import serviceLoadQuestions.CsvLoadServiceImpl;
import serviceLoadQuestions.TestItemsLoadService;

import java.io.IOException;


@Configuration
@PropertySource("classpath:prop.properties")
public class TestConfiguration {


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/messages");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

    @Bean
    public LocalizationService localizationService(MessageSource messageSource) {
        return new LocalizationServiceImpl(messageSource);
    }

    @Bean
    public TestItemsLoadService loadService() {
        return new CsvLoadServiceImpl();
    }


    @Bean
    public ServiceAsk serviceAsk(TestItemsLoadService testItemsLoadService, LocalizationService localizationService) throws IOException {
        testItemsLoadService.load();
        return new ServiceAskImpl(testItemsLoadService, localizationService);
    }

}