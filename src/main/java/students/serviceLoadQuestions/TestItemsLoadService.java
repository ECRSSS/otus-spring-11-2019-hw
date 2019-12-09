package students.serviceLoadQuestions;

import students.model.TestItem;

import java.io.IOException;
import java.util.List;

public interface TestItemsLoadService {

    List<TestItem> load() throws IOException;

}
