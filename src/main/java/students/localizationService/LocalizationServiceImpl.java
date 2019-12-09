package students.localizationService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class LocalizationServiceImpl implements LocalizationService {


    @Value("${locale}")
    private String localeTag;

    private MessageSource messageSource;

    private Locale locale;

    public LocalizationServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public String getLocalizedMessage(String messageName) {
        locale = Locale.forLanguageTag(localeTag);
        return messageSource.getMessage(messageName, null, null, locale);
    }

    @Override
    public Resource getLocalizedFile(String fileName, FileExtensionEnum fileExtensionEnum) {
        locale = Locale.forLanguageTag(localeTag);
        return new ClassPathResource("classpath:localizedFiles/" + fileName + "_" + locale.getLanguage()
                + "." + fileExtensionEnum.getExtensionName());
    }

}
