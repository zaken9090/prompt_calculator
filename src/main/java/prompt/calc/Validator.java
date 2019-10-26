package prompt.calc;

import prompt.calc.enums.ArithmeticEnum;
import prompt.calc.enums.RomanEnum;
import prompt.calc.exceptions.IncorrectInputException;

public class Validator {
    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 10;

    public static boolean delimiterIsIn(String userInputData, String delimiter) throws IncorrectInputException {
        if (userInputData.contains(delimiter)) {
            return true;
        }
        throw new IncorrectInputException("Правила ввода некорректны: отсутствуют разделители.");
    }

    public static ArithmeticEnum operatorIsCorrect(String userOperator) throws IncorrectInputException {
        for (int i = 0; i < ArithmeticEnum.values().length; i++) {
            if (userOperator.charAt(0) == ArithmeticEnum.values()[i].getSymbol()) {
                return ArithmeticEnum.values()[i];
            }
        }
        throw new IncorrectInputException("Арифметический оператор введён некорректно.");
    }

    public static boolean checkStyle(int styleA, int styleB) throws IncorrectInputException {
        if ((styleA == styleB && (styleA & styleB) != -1)) {
            return true;
        }
        throw new IncorrectInputException("Введённые стили различаются.");
    }

    public static int getStyle(String userStyle) throws IncorrectInputException {
        if (checkRoman(userStyle) > 0) {
            return 1;
        }
        else if (checkInt(userStyle) > 0) {
            return 2;
        }
        return -1;
    }

    public static int checkRoman(String userInputData) throws IncorrectInputException {
        for (int i = 0; i < RomanEnum.values().length; i++) {
            if (RomanEnum.values()[i].name().equals(userInputData)) {
                if (inRange(RomanEnum.values()[i].getNum())) {
                    return RomanEnum.values()[i].getNum();
                }
            }
        }
        return -1;
    }

    public static int checkInt(String userInputData) throws IncorrectInputException {
        int data = Integer.parseInt(userInputData);
        if (inRange(data)) {
            return data;
        }
        return -1;
    }

    private static boolean inRange(int userValue) throws IncorrectInputException {
        if ((userValue > MIN_VALUE) && !(userValue > MAX_VALUE)) {
            return true;
            }
        throw new IncorrectInputException("Введённые значения за пределами допустимого.");
    }
}
