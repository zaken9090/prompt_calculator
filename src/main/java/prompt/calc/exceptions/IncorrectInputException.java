package prompt.calc.exceptions;

import java.io.IOException;

public class IncorrectInputException extends IOException {
    public IncorrectInputException(String message) {
        super(message);
    }
}
