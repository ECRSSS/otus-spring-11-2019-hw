package serviceAskQuestions;

import model.TestItem;
import util.Bank;

import java.util.List;
import java.util.Scanner;

public class ServiceAskImpl implements ServiceAsk {

    public void start(List<TestItem> items) {
        Scanner in = Bank.scanner;
        System.out.println("Введите фамилию:");
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
