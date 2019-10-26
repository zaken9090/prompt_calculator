package prompt.calc.enums;

public enum ArithmeticEnum {
    ADDITION ('+'), SUBTRACTION ('-'), MULTIPLICATION ('*'), DIVISION ('/');

    private char symbol;

    ArithmeticEnum(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
