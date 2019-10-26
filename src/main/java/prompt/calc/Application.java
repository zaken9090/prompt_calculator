package prompt.calc;

import prompt.calc.exceptions.IncorrectInputException;

public class Application {
    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        prompt.setUserInput();
        Handler handler = new Handler(prompt.getUserInput());
        try {
            handler.checkInputUserData();
        } catch (IncorrectInputException e) {
            e.printStackTrace();
        }
    }
}
