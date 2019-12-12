package students.localizationService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
public class LocalizationServiceImpl implements LocalizationService {

    private String localeTag;

    private MessageSource messageSource;

    private Locale locale;

    public LocalizationServiceImpl(MessageSource messageSource,@Value("${locale}") String localeTag) {
        this.messageSource = messageSource;
        this.localeTag = localeTag;
    }

    public void setLocaleTag(String localeTag) {
        this.localeTag = localeTag;
    }

    @Override
    public String getLocalizedMessage(String messageName) {
        locale = Locale.forLanguageTag(localeTag);
        return messageSource.getMessage(messageName, null, null, locale);
    }

    @Override
    public Resource getLocalizedFile(String fileName, FileExtensionEnum fileExtensionEnum) {
        locale = Locale.forLanguageTag(localeTag);
        return new ClassPathResource("/localizedFiles/" + fileName + "_" + locale.getLanguage()
                + "." + fileExtensionEnum.getExtensionName());
    }

}
