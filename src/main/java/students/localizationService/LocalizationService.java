package students.localizationService;


import org.springframework.core.io.Resource;

public interface LocalizationService {

    String getLocalizedMessage(String messageName);

    Resource getLocalizedFile(String fileName,FileExtensionEnum fileExtensionEnum);

}
