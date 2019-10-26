package prompt.calc;

import java.util.Scanner;

public class Prompt {
    private String userInput;

    public Prompt() {
        System.out.println("Вас приветствует консольное приложение Калькулятор.");
        System.out.println("Данный калькулятор очень ограничен по функционалу.");
        System.out.println("Он умеет работать с арабскими и римскими числами от 1 до 10/I до X.");
        System.out.println("Калькулятор может выполнять только простые операции: сложение (+), вычитание (-), умножение (*) и деление (/).");
        System.out.println("Передавать калькулятору значения можно только через пробел.");
        System.out.println("Пример работы программы: \"1 + 2\", \"VI / III\"");
        System.out.println("Приятного пользования :)\n\n");
        System.out.println("Ввод данных:");
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
