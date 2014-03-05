/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dana.antal
 */
public class Pi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        double i = 0;
        double pi = 0;
        double previous, current;
//        System.out.println("Dati n: ");
//        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(buff.readLine());

        int n = 5;
        do {
            previous = 4 * pi;

            if (i % 2 == 0 || i == 0) {
                pi += 1 / (2 * i + 1);

            } else {
                pi += (-1) / (2 * i + 1);

            }
            i++;
            current = 4 * pi;

            String auxp;
            String auxc;
            
             if (extractChar(String.valueOf(previous)).length() > n) {
                auxp = extractChar(String.valueOf(previous)).substring(0,n);

            } else {
                auxp = extractChar(String.valueOf(previous));


            }
             if (extractChar(String.valueOf(current)).length() > n) {
                auxc = extractChar(String.valueOf(current)).substring(0, n);

            } else {
                auxc = extractChar(String.valueOf(current));
            }
            System.out.println(current + " " + auxc);
            if (auxp.equals(auxc) && (int)previous==(int)current) {
                break;
            }

        } while (true);


        // System.out.println(pi * 4 + " " + System.currentTimeMillis());


        System.out.println("PI este:" + pi * 4 + " " + System.currentTimeMillis());
      
    }

    public static String extractChar(String x) {
        String str;
        if (x == null) {
            System.err.print("Null!");
            return "0";
        }

        if (x.contains(".")) {
            int index = x.indexOf(".");
            str = x.substring(index + 1, x.length());
        } else {
            str = String.valueOf(0);
        }

        return str;
    }
}
