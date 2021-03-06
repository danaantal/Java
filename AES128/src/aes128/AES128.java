/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes128;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Danna
 */
public class AES128 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File file = new File("plaintext.txt");
        File key = new File("key.txt");
        byte[] fromfile = null;
        byte[] fromkey = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            if ((int) file.length() > 16) {//daca lungimea fisierului e mai mare de 16, noi citim doar 16 caractere
                fromfile = new byte[16];
                fileInputStream.read(fromfile);
            } else {
                fromfile = new byte[(int) file.length()];
                fileInputStream.read(fromfile);
            }
            System.out.print("Input: ");
            for (int i = 0; i < fromfile.length; i++) {
                System.out.print((char) fromfile[i]);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");

        } catch (IOException e1) {
            System.out.println("Error Reading The File.");

        }
        try {
            FileInputStream keyInputStream = new FileInputStream(key);
            if ((int) key.length() > 16) {//daca lungimea fisierului e mai mare de 16, noi citim doar 16 caractere
                fromkey = new byte[16];
                keyInputStream.read(fromkey);
            } else {
                fromkey = new byte[(int) key.length()];
                keyInputStream.read(fromkey);
            }
            System.out.print("Key: ");
            for (int i = 0; i < fromkey.length; i++) {
                System.out.print((char) fromkey[i]);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Key Not Found.");

        } catch (IOException e1) {
            System.out.println("Error Reading The Key.");

        }
        byte[] ciphertext = new byte[16];
        byte[] plaintext = new byte[16];

        Matrix cryptIt = new Matrix(fromkey);
        ciphertext = cryptIt.encrypt(fromfile);

        
//       try {
//          FileOutputStream cypher = new FileOutputStream("ciphertext.txt");
//          ObjectOutputStream save = new ObjectOutputStream(cypher);
//          save.write(ciphertext);
//          save.close();
//        } catch ( IOException e ) {
//           e.printStackTrace();
//        }
        Scanner in = new Scanner(System.in);
        // print menu
        System.out.println("1. Crypt");
        System.out.println("2. Decrypt");
        System.out.println("0. Quit");
        // handle user commands
        boolean quit = false;
        String menuItem;
        do {
            System.out.print("Choose menu item: ");
            menuItem = in.next();
            switch (menuItem) {
                case "1":
                    System.out.println("You've chosen to crypt plaintext...");
                    for (int i = 0; i < ciphertext.length; i++) {
                        System.out.print((char) ciphertext[i]);
                    }
                    System.out.println();
                    break;
                case "2":
                    System.out.println("You've chosen to decrypt cryptotext...");
                    plaintext = cryptIt.decrypt(ciphertext);
                    for (int i = 0; i < plaintext.length; i++) {
                        System.out.print((char) plaintext[i]);
                    }
                    System.out.println();
                    break;
                case "0":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice...");
            }
        } while (!quit);
        System.out.println("Bye-bye!");
    }

}
