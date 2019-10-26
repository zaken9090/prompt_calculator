package prompt.calc;

import prompt.calc.enums.ArithmeticEnum;
import prompt.calc.enums.RomanEnum;
import prompt.calc.exceptions.IncorrectInputException;

public class Handler {
    private final String delimiter = " ";
    private final String userInput;

    private ArithmeticEnum userInputOperator;
    private int userInputA;
    private int userInputB;
    private int userInputStyleA;
    private int userInputStyleB;
    private boolean romanStyle = false;

    private static StringBuilder stringBuilder = new StringBuilder();
    private static int romanSize = RomanEnum.values().length -1;

    Handler(String userInput) {
        this.userInput = userInput;
    }

    void checkInputUserData() throws IncorrectInputException {
        String[] splittedOutUserInput = null;

        if (Validator.delimiterIsIn(userInput, delimiter)) {
            splittedOutUserInput = userInput.split(delimiter);
        }

        if (splittedOutUserInput != null) {
            userInputOperator = Validator.operatorIsCorrect(splittedOutUserInput[1]);
            userInputStyleA = Validator.getStyle(splittedOutUserInput[0]);
            userInputStyleB = Validator.getStyle(splittedOutUserInput[2]);
        }

        if (Validator.checkStyle(userInputStyleA, userInputStyleB)) {
            if ((userInputStyleA & userInputStyleB) == 1) {
                userInputA = Validator.checkRoman(splittedOutUserInput[0]);
                userInputB = Validator.checkRoman(splittedOutUserInput[2]);
                romanStyle = true;
            } else {
                userInputA = Validator.checkInt(splittedOutUserInput[0]);
                userInputB = Validator.checkInt(splittedOutUserInput[2]);
            }
        }

        String result = Arithmetic.calc(userInputOperator, userInputA, userInputB).toString();

        if (!romanStyle) {
            Prompt.showResult(result);
        } else {
            Prompt.showResult(convertIntToRoman(result));
        }
    }

    private String convertIntToRoman(String userValue) {
        int userValueSize = userValue.length();
        Integer value = Integer.parseInt(userValue);

        while (userValueSize > 0) {
            for (; romanSize > 0; romanSize--){
                if (value == RomanEnum.values()[romanSize].getNum()){
                    stringBuilder.append(RomanEnum.values()[romanSize]);
                    return stringBuilder.toString();
                }else if ((value <= RomanEnum.values()[romanSize].getNum() && !(value < RomanEnum.values()[romanSize-1].getNum()))){
                    value -= RomanEnum.values()[romanSize-1].getNum();
                    stringBuilder.append(RomanEnum.values()[romanSize-1]);
                    if (value > 0) {
                        convertIntToRoman(value.toString());
                    }
                }
            }
            userValueSize--;
        }
        return stringBuilder.toString();
    }
}
