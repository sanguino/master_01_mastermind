package sanguino.utils;

public class CombinationStringDialog {

    private static final String VALID_COLORS = "rbygop";

    private Error checkLength(String value, int numColors) {
        return value.length() == numColors ? Error.NULL_ERROR : Error.WRONG_LENGTH;
    }

    private Error checkCharacters(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (CombinationStringDialog.VALID_COLORS.indexOf(value.charAt(i)) == -1) {
                return Error.WRONG_COLOR;
            }
        }
        return Error.NULL_ERROR;
    }

    private Error checkNotDuplicated(String value) {
        for (int i = 0; i < value.length(); i++) {
            for (int j = i + 1; j < value.length(); j++) {
                if (value.charAt(i) == value.charAt(j)) {
                    return Error.WRONG_DUPLICATED;
                }
            }
        }
        return Error.NULL_ERROR;
    }

    private Error checkErrors(String value, int numColors) {
        Error error = checkLength(value, numColors);
        if (error == Error.NULL_ERROR) {
            error = checkCharacters(value);
        }
        if (error == Error.NULL_ERROR) {
            error = checkNotDuplicated(value);
        }
        return error;
    }

    public String read(String message, int numColors) {
        assert message != null;
        Error error;
        String value;
        do {
            value = Console.instance().readString(message);
            error = checkErrors(value, numColors);
            error.writeln();
        } while (error != Error.NULL_ERROR);
        return value;
    }
}