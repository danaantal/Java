/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Dana
 */
public class Xyz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

//        int nJucatori;
//        int pLitere;
//       
//        BufferedReader buff1 = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Nr jucatori: ");
//        nJucatori = Integer.parseInt(buff1.readLine());
//
//        BufferedReader buff2 = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Nr litere: ");
//        pLitere = Integer.parseInt(buff2.readLine());
//
//        if (pLitere < 3 || pLitere > 50) {
//            System.out.println("Introduceti alt numar de litere > 3 si < 50!");
//
//            BufferedReader buff3 = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("Nr litere: ");
//            pLitere = Integer.parseInt(buff3.readLine());
//        }
        TheGame game = new TheGame(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }
}
