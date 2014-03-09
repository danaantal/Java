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
        
        for (Jucator j : jucatori) {
            j.winnerIs(p);
        }
    }

}
