package localizationService;

import org.springframework.context.MessageSource;

import java.util.Locale;

public class LocalizationServiceImpl implements LocalizationService {

    private MessageSource messageSource;

    private Locale locale;

    public LocalizationServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
        locale = Locale.forLanguageTag("${locale}");
    }

    @Override
    public String getMessage(String messageName) {
        return messageSource.getMessage(messageName, null, null, locale);
    }

    @Override
    public String getFile(String fileName) {
        return null;
    }
}
