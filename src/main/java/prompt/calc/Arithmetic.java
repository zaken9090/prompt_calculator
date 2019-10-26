package prompt.calc;

import prompt.calc.enums.ArithmeticEnum;

public class Arithmetic {
    public static Integer calc (ArithmeticEnum arithmetic, int a, int b) {
        Integer result;
        switch (arithmetic){
            case ADDITION:
                result = (a + b);
                return result;
            case SUBTRACTION:
                result = a - b;
                return result;
            case MULTIPLICATION:
                result = a * b;
                return result;
            case DIVISION:
                result = a / b;
                return result;
            default:
               return 0;
        }
    }
}
