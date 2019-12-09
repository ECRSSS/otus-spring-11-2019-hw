package serviceAskQuestions;

import localizationService.LocalizationService;
import model.TestItem;
import org.springframework.stereotype.Service;
import serviceLoadQuestions.TestItemsLoadService;
import util.Bank;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Service
public class ServiceAskImpl implements ServiceAsk {

    private List<TestItem> items;

    private LocalizationService localizationService;

    private void setItems(List<TestItem> items) {
        this.items = items;
    }

    public ServiceAskImpl(TestItemsLoadService loadService, LocalizationService localizationService) throws IOException {
        setItems(loadService.load());
        this.localizationService = localizationService;
    }

    public void start() {
        Scanner in = Bank.scanner;
        System.out.println(localizationService.getMessage("messages.hello"));
        String lastName = in.nextLine();
        System.out.println("Введите имя:");
        String firstName = in.nextLine();
        int total = items.size();
        int rightTotal = 0;
        for (TestItem item : items) {
            rightTotal = item.ask() ? rightTotal += 1 : rightTotal;
        }
        System.out.println("Правильных ответов: " + rightTotal + "/" + total);
    }
}
