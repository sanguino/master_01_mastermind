package sanguino.mastermind;

import sanguino.utils.Console;

enum Message {
    TITTLE("--- MASTERMIND ---"),
    ENTER_COMBINATION("Propose a combination: "),
    ATTEMPTS(" attempt(s):"),
    SECRET_CODE("xxxx"),
    SEPARATOR(""),
    PART_BLACKS(" blacks and "),
    PART_WHITES(" whites"),
    RESULT("%s --> %s"),
    PLAYER_WIN("You've won!!! ;-)"),
    PLAYER_LOOSE("You've lost!!! :-("),
    RESUME("RESUME"),
    NULL_MESSAGE();

    private String message;

    private Message() {
    }

    private Message(String message) {
        this.message = message;
    }

    void writeln() {
        Console.instance().writeln(this.message);
    }

    void writeln(int attempts) {
        assert this == Message.ATTEMPTS;
        Console.instance().writeln(attempts + this.message);
    }

    void writeln(String code, String result) {
        assert this == Message.RESULT;
        Console.instance().writeln(String.format(this.message, code, result));
    }

    @Override
    public String toString() {
        return this.message;
    }

}