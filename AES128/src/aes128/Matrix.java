/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aes128;

/**
 *
 * @author Danna
 */
public class Matrix {

    private final byte[] SBox
            = {(byte) 0x63, (byte) 0x7c, (byte) 0x77, (byte) 0x7b, (byte) 0xf2, (byte) 0x6b, (byte) 0x6f, (byte) 0xc5,
                (byte) 0x30, (byte) 0x01, (byte) 0x67, (byte) 0x2b, (byte) 0xfe, (byte) 0xd7, (byte) 0xab, (byte) 0x76,
                (byte) 0xca, (byte) 0x82, (byte) 0xc9, (byte) 0x7d, (byte) 0xfa, (byte) 0x59, (byte) 0x47, (byte) 0xf0,
                (byte) 0xad, (byte) 0xd4, (byte) 0xa2, (byte) 0xaf, (byte) 0x9c, (byte) 0xa4, (byte) 0x72, (byte) 0xc0,
                (byte) 0xb7, (byte) 0xfd, (byte) 0x93, (byte) 0x26, (byte) 0x36, (byte) 0x3f, (byte) 0xf7, (byte) 0xcc,
                (byte) 0x34, (byte) 0xa5, (byte) 0xe5, (byte) 0xf1, (byte) 0x71, (byte) 0xd8, (byte) 0x31, (byte) 0x15,
                (byte) 0x04, (byte) 0xc7, (byte) 0x23, (byte) 0xc3, (byte) 0x18, (byte) 0x96, (byte) 0x05, (byte) 0x9a,
                (byte) 0x07, (byte) 0x12, (byte) 0x80, (byte) 0xe2, (byte) 0xeb, (byte) 0x27, (byte) 0xb2, (byte) 0x75,
                (byte) 0x09, (byte) 0x83, (byte) 0x2c, (byte) 0x1a, (byte) 0x1b, (byte) 0x6e, (byte) 0x5a, (byte) 0xa0,
                (byte) 0x52, (byte) 0x3b, (byte) 0xd6, (byte) 0xb3, (byte) 0x29, (byte) 0xe3, (byte) 0x2f, (byte) 0x84,
                (byte) 0x53, (byte) 0xd1, (byte) 0x00, (byte) 0xed, (byte) 0x20, (byte) 0xfc, (byte) 0xb1, (byte) 0x5b,
                (byte) 0x6a, (byte) 0xcb, (byte) 0xbe, (byte) 0x39, (byte) 0x4a, (byte) 0x4c, (byte) 0x58, (byte) 0xcf,
                (byte) 0xd0, (byte) 0xef, (byte) 0xaa, (byte) 0xfb, (byte) 0x43, (byte) 0x4d, (byte) 0x33, (byte) 0x85,
                (byte) 0x45, (byte) 0xf9, (byte) 0x02, (byte) 0x7f, (byte) 0x50, (byte) 0x3c, (byte) 0x9f, (byte) 0xa8,
                (byte) 0x51, (byte) 0xa3, (byte) 0x40, (byte) 0x8f, (byte) 0x92, (byte) 0x9d, (byte) 0x38, (byte) 0xf5,
                (byte) 0xbc, (byte) 0xb6, (byte) 0xda, (byte) 0x21, (byte) 0x10, (byte) 0xff, (byte) 0xf3, (byte) 0xd2,
                (byte) 0xcd, (byte) 0x0c, (byte) 0x13, (byte) 0xec, (byte) 0x5f, (byte) 0x97, (byte) 0x44, (byte) 0x17,
                (byte) 0xc4, (byte) 0xa7, (byte) 0x7e, (byte) 0x3d, (byte) 0x64, (byte) 0x5d, (byte) 0x19, (byte) 0x73,
                (byte) 0x60, (byte) 0x81, (byte) 0x4f, (byte) 0xdc, (byte) 0x22, (byte) 0x2a, (byte) 0x90, (byte) 0x88,
                (byte) 0x46, (byte) 0xee, (byte) 0xb8, (byte) 0x14, (byte) 0xde, (byte) 0x5e, (byte) 0x0b, (byte) 0xdb,
                (byte) 0xe0, (byte) 0x32, (byte) 0x3a, (byte) 0x0a, (byte) 0x49, (byte) 0x06, (byte) 0x24, (byte) 0x5c,
                (byte) 0xc2, (byte) 0xd3, (byte) 0xac, (byte) 0x62, (byte) 0x91, (byte) 0x95, (byte) 0xe4, (byte) 0x79,
                (byte) 0xe7, (byte) 0xc8, (byte) 0x37, (byte) 0x6d, (byte) 0x8d, (byte) 0xd5, (byte) 0x4e, (byte) 0xa9,
                (byte) 0x6c, (byte) 0x56, (byte) 0xf4, (byte) 0xea, (byte) 0x65, (byte) 0x7a, (byte) 0xae, (byte) 0x08,
                (byte) 0xba, (byte) 0x78, (byte) 0x25, (byte) 0x2e, (byte) 0x1c, (byte) 0xa6, (byte) 0xb4, (byte) 0xc6,
                (byte) 0xe8, (byte) 0xdd, (byte) 0x74, (byte) 0x1f, (byte) 0x4b, (byte) 0xbd, (byte) 0x8b, (byte) 0x8a,
                (byte) 0x70, (byte) 0x3e, (byte) 0xb5, (byte) 0x66, (byte) 0x48, (byte) 0x03, (byte) 0xf6, (byte) 0x0e,
                (byte) 0x61, (byte) 0x35, (byte) 0x57, (byte) 0xb9, (byte) 0x86, (byte) 0xc1, (byte) 0x1d, (byte) 0x9e,
                (byte) 0xe1, (byte) 0xf8, (byte) 0x98, (byte) 0x11, (byte) 0x69, (byte) 0xd9, (byte) 0x8e, (byte) 0x94,
                (byte) 0x9b, (byte) 0x1e, (byte) 0x87, (byte) 0xe9, (byte) 0xce, (byte) 0x55, (byte) 0x28, (byte) 0xdf,
                (byte) 0x8c, (byte) 0xa1, (byte) 0x89, (byte) 0x0d, (byte) 0xbf, (byte) 0xe6, (byte) 0x42, (byte) 0x68,
                (byte) 0x41, (byte) 0x99, (byte) 0x2d, (byte) 0x0f, (byte) 0xb0, (byte) 0x54, (byte) 0xbb, (byte) 0x16};

    private final byte[] invSBox
            = {(byte) 0x52, (byte) 0x09, (byte) 0x6a, (byte) 0xd5, (byte) 0x30, (byte) 0x36, (byte) 0xa5, (byte) 0x38,
                (byte) 0xbf, (byte) 0x40, (byte) 0xa3, (byte) 0x9e, (byte) 0x81, (byte) 0xf3, (byte) 0xd7, (byte) 0xfb,
                (byte) 0x7c, (byte) 0xe3, (byte) 0x39, (byte) 0x82, (byte) 0x9b, (byte) 0x2f, (byte) 0xff, (byte) 0x87,
                (byte) 0x34, (byte) 0x8e, (byte) 0x43, (byte) 0x44, (byte) 0xc4, (byte) 0xde, (byte) 0xe9, (byte) 0xcb,
                (byte) 0x54, (byte) 0x7b, (byte) 0x94, (byte) 0x32, (byte) 0xa6, (byte) 0xc2, (byte) 0x23, (byte) 0x3d,
                (byte) 0xee, (byte) 0x4c, (byte) 0x95, (byte) 0x0b, (byte) 0x42, (byte) 0xfa, (byte) 0xc3, (byte) 0x4e,
                (byte) 0x08, (byte) 0x2e, (byte) 0xa1, (byte) 0x66, (byte) 0x28, (byte) 0xd9, (byte) 0x24, (byte) 0xb2,
                (byte) 0x76, (byte) 0x5b, (byte) 0xa2, (byte) 0x49, (byte) 0x6d, (byte) 0x8b, (byte) 0xd1, (byte) 0x25,
                (byte) 0x72, (byte) 0xf8, (byte) 0xf6, (byte) 0x64, (byte) 0x86, (byte) 0x68, (byte) 0x98, (byte) 0x16,
                (byte) 0xd4, (byte) 0xa4, (byte) 0x5c, (byte) 0xcc, (byte) 0x5d, (byte) 0x65, (byte) 0xb6, (byte) 0x92,
                (byte) 0x6c, (byte) 0x70, (byte) 0x48, (byte) 0x50, (byte) 0xfd, (byte) 0xed, (byte) 0xb9, (byte) 0xda,
                (byte) 0x5e, (byte) 0x15, (byte) 0x46, (byte) 0x57, (byte) 0xa7, (byte) 0x8d, (byte) 0x9d, (byte) 0x84,
                (byte) 0x90, (byte) 0xd8, (byte) 0xab, (byte) 0x00, (byte) 0x8c, (byte) 0xbc, (byte) 0xd3, (byte) 0x0a,
                (byte) 0xf7, (byte) 0xe4, (byte) 0x58, (byte) 0x05, (byte) 0xb8, (byte) 0xb3, (byte) 0x45, (byte) 0x06,
                (byte) 0xd0, (byte) 0x2c, (byte) 0x1e, (byte) 0x8f, (byte) 0xca, (byte) 0x3f, (byte) 0x0f, (byte) 0x02,
                (byte) 0xc1, (byte) 0xaf, (byte) 0xbd, (byte) 0x03, (byte) 0x01, (byte) 0x13, (byte) 0x8a, (byte) 0x6b,
                (byte) 0x3a, (byte) 0x91, (byte) 0x11, (byte) 0x41, (byte) 0x4f, (byte) 0x67, (byte) 0xdc, (byte) 0xea,
                (byte) 0x97, (byte) 0xf2, (byte) 0xcf, (byte) 0xce, (byte) 0xf0, (byte) 0xb4, (byte) 0xe6, (byte) 0x73,
                (byte) 0x96, (byte) 0xac, (byte) 0x74, (byte) 0x22, (byte) 0xe7, (byte) 0xad, (byte) 0x35, (byte) 0x85,
                (byte) 0xe2, (byte) 0xf9, (byte) 0x37, (byte) 0xe8, (byte) 0x1c, (byte) 0x75, (byte) 0xdf, (byte) 0x6e,
                (byte) 0x47, (byte) 0xf1, (byte) 0x1a, (byte) 0x71, (byte) 0x1d, (byte) 0x29, (byte) 0xc5, (byte) 0x89,
                (byte) 0x6f, (byte) 0xb7, (byte) 0x62, (byte) 0x0e, (byte) 0xaa, (byte) 0x18, (byte) 0xbe, (byte) 0x1b,
                (byte) 0xfc, (byte) 0x56, (byte) 0x3e, (byte) 0x4b, (byte) 0xc6, (byte) 0xd2, (byte) 0x79, (byte) 0x20,
                (byte) 0x9a, (byte) 0xdb, (byte) 0xc0, (byte) 0xfe, (byte) 0x78, (byte) 0xcd, (byte) 0x5a, (byte) 0xf4,
                (byte) 0x1f, (byte) 0xdd, (byte) 0xa8, (byte) 0x33, (byte) 0x88, (byte) 0x07, (byte) 0xc7, (byte) 0x31,
                (byte) 0xb1, (byte) 0x12, (byte) 0x10, (byte) 0x59, (byte) 0x27, (byte) 0x80, (byte) 0xec, (byte) 0x5f,
                (byte) 0x60, (byte) 0x51, (byte) 0x7f, (byte) 0xa9, (byte) 0x19, (byte) 0xb5, (byte) 0x4a, (byte) 0x0d,
                (byte) 0x2d, (byte) 0xe5, (byte) 0x7a, (byte) 0x9f, (byte) 0x93, (byte) 0xc9, (byte) 0x9c, (byte) 0xef,
                (byte) 0xa0, (byte) 0xe0, (byte) 0x3b, (byte) 0x4d, (byte) 0xae, (byte) 0x2a, (byte) 0xf5, (byte) 0xb0,
                (byte) 0xc8, (byte) 0xeb, (byte) 0xbb, (byte) 0x3c, (byte) 0x83, (byte) 0x53, (byte) 0x99, (byte) 0x61,
                (byte) 0x17, (byte) 0x2b, (byte) 0x04, (byte) 0x7e, (byte) 0xba, (byte) 0x77, (byte) 0xd6, (byte) 0x26,
                (byte) 0xe1, (byte) 0x69, (byte) 0x14, (byte) 0x63, (byte) 0x55, (byte) 0x21, (byte) 0x0c, (byte) 0x7d};

    private final byte[] RCon = {(byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x04,
        (byte) 0x08, (byte) 0x10, (byte) 0x20, (byte) 0x40,
        (byte) 0x80, (byte) 0x1b, (byte) 0x36};

    //x^8+x^4+x^3+x+1  
    final byte polynom = 0x1B;

    private int r = 4, c = 4; //rows, columns
    public byte[][] matrix = new byte[4][4];
    private byte[] key;
    private byte[][] word;

    public Matrix(byte[] b) {//constructorul matricii si al cheii
        word = new byte[44][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                word[i][j] = b[4 * i + (3 - j)];
            }
        }
        keySchedule();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = (byte) 0x61; // "a"
            }
        }
    }

    public String toChar() {
        String character = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                character = character + (char) this.matrix[i][j];

            }
        }
        return character;
    }

    private void keySchedule() {
        byte[] temp = new byte[4];
        for (int i = 4; i < 44; i++) {
            for (int j = 0; j < 4; j++) {
                temp[j] = word[i - 1][j];
            }

            if (i % 4 == 0) {//begin if condition for every 4th column wich is "special
                byte tempbyte = temp[3];//first element in the column becomes the last element
                temp[3] = temp[2];
                temp[2] = temp[1];
                temp[1] = temp[0];
                temp[0] = tempbyte;

                for (int j = 0; j < 4; j++) {//SBox on each column element
                    temp[j] = SBox[temp[j] & 0xff];
                }
                temp[3] ^= RCon[i / 4];//rcon XOR operation
            }//end if
            for (int j = 0; j < 4; j++) {
                word[i][j] = (byte) (temp[j] ^ word[i - 4][j]);//XOR operation with the first column of the word
                // System.out.println(word[i][j]);
            }
        }//end for of i
    }

    private void addRoundKey(int round) {

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                this.matrix[i][j] ^= word[i][j];
            }
        }
    }

    public void subBytes() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                this.matrix[i][j] = SBox[this.matrix[i][j] & 0xFF];
            }
        }
    }

    private void invSubBytes() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                this.matrix[i][j] = invSBox[this.matrix[i][j] & 0xFF];
            }
        }
    }

    public void shiftRows() {
        //row 0 remains unchanged
        byte tmp;
        //row 1 - element 0 becomes element 3
        tmp = this.matrix[1][0];
        for (int col = 0; col < 3; col++) {
            this.matrix[1][col] = this.matrix[1][col + 1];
        }
        this.matrix[1][3] = tmp;
        //row 2 - element 0 becomes element 2 and element 1 becomes element 3
        tmp = this.matrix[2][0];
        this.matrix[2][0] = this.matrix[2][2];
        this.matrix[2][2] = tmp;
        tmp = this.matrix[2][1];
        this.matrix[2][1] = this.matrix[2][3];
        this.matrix[2][3] = tmp;
        //row 3 - element 0 becomes element 3, element 1 becomes element 2 and element 2 becomes element 1
        tmp = this.matrix[3][3];
        for (int col = 3; col > 0; col--) {
            this.matrix[3][col] = this.matrix[3][col - 1];
        }
        this.matrix[3][0] = tmp;
    }

    private void invShiftRows() {
        byte tmp;
        //row 3 - element 3 becomes element 0, element 2 becomes element 1 and element 1 becomes element 2
        tmp = this.matrix[3][0];
        for (int col = 0; col < 3; col++) {
            this.matrix[3][col] = this.matrix[3][col + 1];
        }
        this.matrix[3][3] = tmp;
        //row 2 - element 2 becomes element 0 and element 3 becomes element 1
        tmp = this.matrix[2][0];
        this.matrix[2][0] = this.matrix[2][2];
        this.matrix[2][2] = tmp;
        tmp = this.matrix[2][1];
        this.matrix[2][1] = this.matrix[2][3];
        this.matrix[2][3] = tmp;
        //row 1 - element 3 becomes element 0
        tmp = this.matrix[1][3];
        for (int col = 3; col > 0; c--) {
            this.matrix[1][col] = this.matrix[1][col - 1];
        }
        this.matrix[1][0] = tmp;
    }

    private byte multiplyX(byte inputByte) {//daca primul bit este 1: shiftare la stanga cu o pozitie, 
        //se pierde primul bit, se adauga 0 la final (10010011 devine 00100110) 
        //si se face XOR cu sirul de biti 00011011
        byte temp;
        if ((inputByte & 0x80) == 0) {
            temp = (byte) (inputByte << 1); //daca primul bit este 0 se face doar shiftare, fara operatia de XOR;  
        } else {
            temp = (byte) ((inputByte << 1) ^ polynom);
        }
        return temp;
    }

    private void mixColumns() {
        /*private final byte[][] mixcolumnMatrix = 
         {{(byte) 0x02, (byte) 0x03, (byte) 0x01, (byte) 0x01},
         {(byte) 0x01, (byte) 0x02, (byte) 0x03, (byte) 0x01},
         {(byte) 0x01, (byte) 0x01, (byte) 0x02, (byte) 0x03},
         {(byte) 0x03, (byte) 0x01, (byte) 0x01, (byte) 0x02}};*/
        byte[][] temp = new byte[r][c];
        for (int j = 0; j < c; j++) {
            temp[0][j] = (byte) (multiplyX(temp[0][j]) //x
                    ^ multiplyX(temp[1][j]) ^ temp[1][j] //x+1
                    ^ temp[2][j] // 1
                    ^ temp[3][j]); // 1

            temp[1][j] = (byte) (multiplyX(temp[1][j]) //x
                    ^ multiplyX(temp[2][j]) ^ temp[2][j] //x+1
                    ^ temp[3][j] // 1
                    ^ temp[0][j]); // 1

            temp[2][j] = (byte) (multiplyX(temp[2][j]) //x
                    ^ multiplyX(temp[3][j]) ^ temp[3][j] //x+1
                    ^ temp[0][j] // 1
                    ^ temp[1][j]); // 1

            temp[3][j] = (byte) (multiplyX(temp[3][j]) //x
                    ^ multiplyX(temp[0][j]) ^ temp[0][j] //x+1
                    ^ temp[1][j] // 1
                    ^ temp[2][j]); // 1
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                this.matrix[i][j] = temp[i][j];
            }
        }
    }

    private byte multiplyX2(byte inputByte) { //x * multiplyX
        byte temp;
        temp = multiplyX(inputByte);
        temp = multiplyX(temp);
        return temp;
    }

    private byte multiplyX3(byte inputByte) { //x * mulptiplyX2
        byte temp;
        temp = multiplyX(inputByte);
        temp = multiplyX(temp);
        temp = multiplyX(temp);
        return temp;
    }

    private void invMixColumns() {//dont forget about keyschedule call
        /*private final byte[][] invMixcolumnMatrix = 
         {{(byte) 0x0e, (byte) 0x0b, (byte) 0x0d, (byte) 0x09},
         {(byte) 0x09, (byte) 0x0e, (byte) 0x0b, (byte) 0x0d},
         {(byte) 0x0d, (byte) 0x09, (byte) 0x0e, (byte) 0x0b},
         {(byte) 0x0b, (byte) 0x0d, (byte) 0x09, (byte) 0x0e}};*/
        byte[][] temp = new byte[r][c];

        for (int j = 0; j < c; j++) {
            temp[0][j] = (byte) (multiplyX3(temp[0][j]) ^ multiplyX2(temp[0][j]) ^ multiplyX(temp[0][j])//x^3 XOR x^2 XOR x
                    ^ multiplyX3(temp[1][j]) ^ multiplyX(temp[1][j]) ^ temp[1][j]//x^3 XOR x XOR 1
                    ^ multiplyX3(temp[2][j]) ^ multiplyX2(temp[2][j]) ^ temp[2][j]//x^3 XOR X^2 XOR 1
                    ^ multiplyX3(temp[3][j]) ^ temp[3][j]);//x^3 XOR 1

            temp[1][j] = (byte) (multiplyX3(temp[1][j]) ^ multiplyX2(temp[1][j]) ^ multiplyX(temp[1][j])//x^3 XOR x^2 XOR x
                    ^ multiplyX3(temp[2][j]) ^ multiplyX(temp[2][j]) ^ temp[2][j]//x^3 XOR x XOR 1
                    ^ multiplyX3(temp[3][j]) ^ multiplyX2(temp[3][j]) ^ temp[3][j]//x^3 XOR X^2 XOR 1
                    ^ multiplyX3(temp[0][j]) ^ temp[0][j]);//x^3 XOR 1

            temp[2][j] = (byte) (multiplyX3(temp[2][j]) ^ multiplyX2(temp[2][j]) ^ multiplyX(temp[2][j])//x^3 XOR x^2 XOR x
                    ^ multiplyX3(temp[3][j]) ^ multiplyX(temp[3][j]) ^ temp[3][j]//x^3 XOR x XOR 1
                    ^ multiplyX3(temp[0][j]) ^ multiplyX2(temp[0][j]) ^ temp[0][j]//x^3 XOR X^2 XOR 1
                    ^ multiplyX3(temp[1][j]) ^ temp[1][j]);//x^3 XOR 1

            temp[3][j] = (byte) (multiplyX3(temp[3][j]) ^ multiplyX2(temp[3][j]) ^ multiplyX(temp[3][j])//x^3 XOR x^2 XOR x
                    ^ multiplyX3(temp[0][j]) ^ multiplyX(temp[0][j]) ^ temp[0][j]//x^3 XOR x XOR 1
                    ^ multiplyX3(temp[1][j]) ^ multiplyX2(temp[1][j]) ^ temp[1][j]//x^3 XOR X^2 XOR 1
                    ^ multiplyX3(temp[2][j]) ^ temp[2][j]);//x^3 XOR 1
        }
    }

    public byte[] encrypt(byte[] plaintext) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                this.matrix[i][j] = plaintext[4 * i + j];
            }
        }

        addRoundKey(0);
        for (int round = 1; round < 10; round++) {
            subBytes();
            shiftRows();
            mixColumns();
            addRoundKey(round);
        }
        subBytes();
        shiftRows();
        addRoundKey(10);

        byte[] ciphertext = new byte[16];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ciphertext[i * 4 + j] = this.matrix[i][j];
            }
        }
        return ciphertext;
    }

    public byte[] decrypt(byte[] ciphertext) {
        for(int i=0;i<4;i++)  
           for(int j=0;j<4;j++)  
               this.matrix[i][j] = ciphertext[i*4+j]; 
        
        addRoundKey(10);
            for (int round = 9; round > 0; round--) {
            invShiftRows();
            invSubBytes();
            addRoundKey(round);
            invMixColumns();
        }
        invShiftRows();
        invSubBytes();
        addRoundKey(0);
        
        byte[] plaintext = new byte[16];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                plaintext[i * 4 + j] = this.matrix[i][j];
            }
        }
        return plaintext;
    }
}
