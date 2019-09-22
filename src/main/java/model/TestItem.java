package model;

import model.itemsPart.Answer;
import model.itemsPart.Question;
import util.Bank;

import java.util.List;
import java.util.stream.Stream;

public class TestItem {

    public TestItem(Question question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    private Question question;

    public Question getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    private List<Answer> answers;

    public boolean ask() {
        System.out.println(question.getText());
        while (true) {
            System.out.println("--Выберите ответ из списка(ответов может быть " +
                    "несколько, в таком случае выбирайте последовательно)--");
            Stream.iterate(0, n -> n + 1).limit(answers.size()).forEach(n -> {
                System.out.println((n + 1) + ": " + answers.get(n).getText());
            });
            System.out.println("--Введите ответ--");
            int answerKey = Bank.scanner.nextInt();
            Answer selectedAnswer = answers.get(answerKey - 1);
            answers.remove(selectedAnswer);
            if (selectedAnswer.isRight() && answers.stream().noneMatch(Answer::isRight)) {
                System.out.println("Ответ(ы) верны");
                return true;
            } else if (selectedAnswer.isRight() && answers.stream().anyMatch(Answer::isRight)) {
                continue;
            } else {
                System.out.println("Вы ошиблись");
                return false;
            }
        }
    }


}
