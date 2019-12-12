package students.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import students.localizationService.LocalizationService;
import students.localizationService.LocalizationServiceImpl;

@PropertySource("classpath:prop.properties")
@ComponentScan(basePackages = "students")
@Configuration
public class Config {


    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/messages");
        ms.setDefaultEncoding("windows-1251");
        return ms;
    }

    @Bean
    public LocalizationService localizationService(MessageSource messageSource, @Value("${locale}") String localeTag) {
        return new LocalizationServiceImpl(messageSource, localeTag);
    }

}
