package usantatecla.mastermind.models;

public enum Color {
    RED('r'),
    BLUE('b'),
    YELLOW('y'),
    GREEN('g'),
    ORANGE('o'),
    PURPLE('p');

    private char character;

    private Color(char character) {
        this.character = character;
    }

    public static Color getColor(char character) {
        for (Color color : Color.values()) {
            if (color.character == character) {
                return color;
            }
        }
        return null;
    }

    public char getCharacter() {
        return this.character;
    }

    static int length() {
        return Color.values().length;
    }

}
