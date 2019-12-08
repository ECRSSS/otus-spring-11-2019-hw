import org.springframework.beans.factory.annotation.Autowired;
import serviceLoadQuestions.TestItemsLoadService;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class LoaderTests extends AbstractTestClass {

    @Autowired
    TestItemsLoadService loadService;

    @org.junit.Test
    public void loadTests() throws IOException {
        assertThat(loadService.load().size()).isEqualTo(2);
    }

}
