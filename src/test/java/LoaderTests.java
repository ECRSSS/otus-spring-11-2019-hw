import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import students.serviceLoadQuestions.TestItemsLoadService;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class LoaderTests extends AbstractTestClass {

    @Autowired
    private TestItemsLoadService loadService;

    @Test
    public void loadTests() throws IOException {
        assertThat(loadService.load().size()).isEqualTo(2);
    }

}
