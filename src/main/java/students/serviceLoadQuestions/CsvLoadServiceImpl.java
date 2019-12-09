package students.serviceLoadQuestions;

import students.localizationService.FileExtensionEnum;
import students.localizationService.LocalizationService;
import students.model.TestItem;
import students.model.itemsPart.Answer;
import students.model.itemsPart.Question;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvLoadServiceImpl implements TestItemsLoadService {

    private LocalizationService localizationService;

    public CsvLoadServiceImpl(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    @Override
    public List<TestItem> load() throws IOException {
        CSVParser csvParser = CSVFormat.EXCEL.withHeader().parse(
                new InputStreamReader(new FileInputStream(
                        localizationService
                                .getLocalizedFile("testItems", FileExtensionEnum.CSV)
                                .getFile())));
        List<TestItem> testItems = new ArrayList<>();
        for (CSVRecord record : csvParser) {
            Question question = new Question(record.get("question"));
            String ansData = record.get("answer");
            String[] answersString = ansData.split(";");
            List<Answer> answers = new ArrayList<>();
            for (String item : answersString) {
                boolean isRight = false;
                if (item.contains("-true")) {
                    item = item.replaceAll("-true", "");
                    isRight = true;
                }
                Answer answer = new Answer(item, isRight);
                answers.add(answer);
            }
            testItems.add(new TestItem(question, answers));
        }
        return testItems;
    }

}
