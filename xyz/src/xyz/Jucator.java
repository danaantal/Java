/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz;

/**
 *
 * @author Dana
 */
public class Jucator {

    public String nume = "";
    public char[] word = new char[50];

    public Jucator(String nume1) {
        this.nume = nume1;
        for (int i = 0; i < word.length; i++) {
            word[i] = ' ';
        }

    }

    public boolean winnerIs(char[] word) {
        int oldRatio;
        int ratio;

        oldRatio = word[1] - word[0];

        for (int i = 1; i < word.length - 1; i++) {
            ratio = word[i + 1] - word[i];

            if (ratio != oldRatio) {
                return false;
        }
        }
        return true;
    }
    

    public char getCharForP() {
        char ch = (char) (90 - (Math.random() * 25));

        return ch;
    }
}
