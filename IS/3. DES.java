import javax.crypto.Cipher; 
import javax.crypto.KeyGenerator; 
import javax.crypto.SecretKey; 
import java.util.Base64; 
 
public class DESAlgorithm { 
     
    // Method to generate a secret key 
    public static SecretKey generateKey() throws Exception { 
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES"); 
        keyGenerator.init(56); // DES uses a 56-bit key 
        return keyGenerator.generateKey(); 
    } 
 
    // Method to encrypt text 
    public static String encrypt(String plainText, SecretKey secretKey) throws Exception { 
        Cipher cipher = Cipher.getInstance("DES"); 
        cipher.init(Cipher.ENCRYPT_MODE, secretKey); 
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes()); 
        return Base64.getEncoder().encodeToString(encryptedBytes); 
    } 
 
    // Method to decrypt text 
    public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception { 
        Cipher cipher = Cipher.getInstance("DES"); 
        cipher.init(Cipher.DECRYPT_MODE, secretKey); 
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText)); 
        return new String(decryptedBytes); 
    } 
 
    public static void main(String[] args) { 
        try { 
            String originalText = "Hello, DES Encryption!"; 
            SecretKey secretKey = generateKey(); 
             
            String encryptedText = encrypt(originalText, secretKey); 
            String decryptedText = decrypt(encryptedText, secretKey); 
             
            System.out.println("Original Text: " + originalText); 
            System.out.println("Encrypted Text: " + encryptedText); 
            System.out.println("Decrypted Text: " + decryptedText); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
}
