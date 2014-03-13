/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz;

import java.util.ArrayList;

/**
 *
 * @author Danna
 */
public class TheGame {

    public ArrayList<Jucator> jucatori;

    public TheGame(int n, int p) {
        jucatori = new ArrayList();

        for (int i = 0; i < n; i++) {
            jucatori.add(new Jucator(String.valueOf(i + 1)));
        }
        for (Jucator j : jucatori) {
            System.out.println("#" + j.nume);
        }
        for (int i = 0; i < p; i++) {
            for (Jucator j : jucatori) {

                j.word[i] = j.getCharForP();
             //   j.word = new char[]{'K', 'I', 'G', 'E', 'C'};
                System.out.println(j.word);

                System.out.println("****");
                if (j.winnerIs(j.word)) {
                    System.out.println(j.nume + " a castigat"); 
                    jucatori.remove(j);
                }
            }

        }
    }
}
