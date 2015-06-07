import javax.crypto.Cipher;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import sun.misc.BASE64Encoder;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@SuppressWarnings("restriction")
public class TripleDes {

     private static String algorithm = "DESede";
     private static Cipher cipher = null;

     public static void setUp() throws Exception {
         cipher = Cipher.getInstance(algorithm);   
     }

     
     public static Key generateKey() throws NoSuchAlgorithmException {
    	 return KeyGenerator.getInstance(algorithm).generateKey();
     }
     
     public static String encrypt(String input,Key key)
         throws InvalidKeyException, 
                BadPaddingException,
                IllegalBlockSizeException {
         cipher.init(Cipher.ENCRYPT_MODE, key);
         byte[] inputBytes = input.getBytes();
         BASE64Encoder encoder = new BASE64Encoder();
         return encoder.encode(cipher.doFinal(inputBytes));
     }

     public static byte[] decrypt(byte[] encryptionBytes,Key key)
         throws InvalidKeyException, 
                BadPaddingException,
                IllegalBlockSizeException {
         cipher.init(Cipher.DECRYPT_MODE, key);
         byte[] recoveredBytes = 
           cipher.doFinal(encryptionBytes);
         return recoveredBytes;
       }
     
     /** Save the specified TripleDES SecretKey to the specified file */
	  public static void writeKey(SecretKey key, File f) throws IOException,
	      NoSuchAlgorithmException, InvalidKeySpecException {
	    // Convert the secret key to an array of bytes like this
	    SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
	    DESedeKeySpec keyspec = (DESedeKeySpec) keyfactory.getKeySpec(key,
	        DESedeKeySpec.class);
	    byte[] rawkey = keyspec.getKey();

	    // Write the raw key to the file
	    FileOutputStream out = new FileOutputStream(f);
	    out.write(rawkey);
	    out.close();
	  }
	  
	  /** Read a TripleDES secret key from the specified file */
	  public static SecretKey readKey(File f) throws IOException,
	      NoSuchAlgorithmException, InvalidKeyException,
	      InvalidKeySpecException {
	    // Read the raw bytes from the key file
	    DataInputStream in = new DataInputStream(new FileInputStream(f));
	    byte[] rawkey = new byte[(int) f.length()];
	    in.readFully(rawkey);
	    in.close();
	   
	    // Convert the raw bytes to a secret key like this
	    DESedeKeySpec keyspec = new DESedeKeySpec(rawkey);
	    SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
	    SecretKey key = keyfactory.generateSecret(keyspec);
	    return key;
	  }
     
}
