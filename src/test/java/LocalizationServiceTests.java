import students.localizationService.FileExtensionEnum;
import students.localizationService.LocalizationServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalizationServiceTests extends AbstractTestClass {

    @Autowired
    private LocalizationServiceImpl localizationService;

    @Test
    public void localizationMessageEn() {
        localizationService.setLocaleTag("en");
        assertThat(localizationService.getLocalizedMessage("messages.hello")).isEqualTo("hello");
    }

    @Test
    public void localizationMessageRu() {
        localizationService.setLocaleTag("ru");
        assertThat(localizationService.getLocalizedMessage("messages.hello")).isEqualTo("привет");
    }


    @Test
    public void localizationFileEn() throws IOException {
        localizationService.setLocaleTag("en");
        Resource file = localizationService.getLocalizedFile("testItems", FileExtensionEnum.CSV);
        assertThat(file.getFile().canRead()).isEqualTo(true);
        assertThat(file.getFile().canExecute()).isEqualTo(true);
    }

    @Test
    public void localizationFileRu() throws IOException {
        localizationService.setLocaleTag("ru");
        Resource file = localizationService.getLocalizedFile("testItems", FileExtensionEnum.CSV);
        assertThat(file.getFile().canRead()).isEqualTo(true);
        assertThat(file.getFile().canExecute()).isEqualTo(true);
    }


}
