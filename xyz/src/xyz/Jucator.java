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
            word[i] = 'd';
        }

    }

    public int winnerIs(int p) {
        int oldRatio;
        int ratio;
        char[] word = new char[p];

        System.out.println("***");
        for (int i = 0; i < word.length; i++) {
            word[i] = (char) (90 - (Math.random() * 25));

            System.out.println(word[i]);
        }

        oldRatio = word[1] - word[0];

        for (int i = 0; i < word.length; i++) {
            ratio = word[i + 1] - word[i];

            if (ratio != oldRatio) {
                return 0;
            }
        }
        return 1;
    }
}
