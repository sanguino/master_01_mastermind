package sanguino.mastermind;

import java.util.Random;

public enum Color {
    RED('r'),
    BLUE('b'),
    YELLOW('y'),
    GREEN('g'),
    ORANGE('o'),
    PURPLE('p'),
    NULL_COLOR();

    private char symbol;

    private Color() {
    }

    static public Color randomColor() {
        int pick = new Random().nextInt(Color.values().length - 1);
        return Color.values()[pick];
    }

    Color(char symbol) {
        this.symbol = symbol;
    }

    static public Color getFromValue(char value) {
        for (Color elem : Color.values()) {
            if (elem.symbol == value) {
                return elem;
            }
        }
        return Color.NULL_COLOR;
    }
}
