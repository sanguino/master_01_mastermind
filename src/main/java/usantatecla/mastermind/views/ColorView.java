package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Color;
import usantatecla.utils.WithConsoleView;

public class ColorView extends WithConsoleView{

    private static final char[] INITIALS = {'r', 'b', 'y', 'g', 'o', 'p'};

    static String allInitials() {
        String result = "";
        for(char character: ColorView.INITIALS) {
            result += character;
        }
        return result;
    }

    public static int getOrdinal(char character) {
        for (int i = 0; i < ColorView.INITIALS.length; i++) {
            if (ColorView.INITIALS[i] == character) {
                return i;
            }
        }
        return -1;
    }

    public static char getCharacter(int i) {
        return ColorView.INITIALS[i];
    }

    void write(String colors) {
        this.console.write(colors);
    }

}