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
//        jucatori.get(0).word = new char[]{'K', 'I', 'G', 'E', 'C'};
//        jucatori.get(1).word = new char[]{'A', 'B', 'G', 'E', 'C'};
//        jucatori.get(2).word = new char[]{'A', 'B', 'C', 'D', 'E'};

        for (int i = 0; i < p; i++) {
            ArrayList<Jucator> castigatori = new ArrayList<>();
            for (Jucator j : jucatori) {

                j.word[i] = j.getCharForP();
                System.out.println("****");
                System.out.print("#" + j.nume + " ");
                System.out.println(j.word);

                if (j.winnerIs(j.word)) {
                    System.out.println("#" + j.nume + " a castigat!");
                    castigatori.add(j);
                }
            }
            jucatori.removeAll(castigatori);


        }
    }
}
