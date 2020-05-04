package prompt.calc;

import java.util.Scanner;

public class Prompt {
    private String userInput;

    public Prompt() {
        System.out.println(
            "Вас приветствует консольное приложение Калькулятор.\n" +
            "Данный калькулятор очень ограничен по функционалу.\n" +
            "Он умеет работать с арабскими и римскими числами от 1 до 10/I до X.\n" +
            "Калькулятор может выполнять только простые операции: сложение (+), вычитание (-), умножение (*) и деление (/).\n" +
            "Передавать калькулятору значения можно только через пробел. \n" +
            "Пример работы программы: \"1 + 2\", \"VI * III\"\n" +
            "Приятного пользования :)\n\n" +
            "Ввод данных:");
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput() {
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
    }

    public static void showResult(String result){
        System.out.println("Результат: " + result);
    }
}
