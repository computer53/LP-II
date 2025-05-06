import java.util.Scanner;

public class TranspositionCipher {

    // Encryption method
    public static String encryptMessage(String plaintext, int key) {
        String[] ciphertext = new String[key];
        for (int i = 0; i < key; i++) {
            ciphertext[i] = "";
        }

        // Perform encryption
        for (int column = 0; column < key; column++) {
            int pointer = column;
            while (pointer < plaintext.length()) {
                ciphertext[column] += plaintext.charAt(pointer);
                pointer += key;
            }
        }

        // Combine all columns into a single string
        StringBuilder encryptedText = new StringBuilder();
        for (String s : ciphertext) {
            encryptedText.append(s);
        }

        return encryptedText.toString();
    }

    // Decryption method
    public static String decryptMessage(int key, String message) {
        int numOfColumns = (int) Math.ceil((double) message.length() / key);
        int numOfRows = key;
        int numOfShadedBoxes = (numOfColumns * numOfRows) - message.length();

        // Prepare an array for the columns
        String[] text = new String[numOfColumns];
        for (int i = 0; i < numOfColumns; i++) {
            text[i] = "";
        }

        int column = 0;
        int row = 0;

        // Decrypt the message
        for (int i = 0; i < message.length(); i++) {
            text[column] += message.charAt(i);
            column++;

            if (column == numOfColumns || (column == numOfColumns - 1 && row >= numOfRows - numOfShadedBoxes)) {
                column = 0;
                row++;
            }
        }

        // Combine the columns into the decrypted message
        StringBuilder decryptedText = new StringBuilder();
        for (String s : text) {
            decryptedText.append(s);
        }

        return decryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Encryption
        System.out.print("Enter your plain text: ");
        String plaintext = scanner.nextLine();

        System.out.print("Enter key: ");
        int key = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String encryptedMessage = encryptMessage(plaintext, key);
        System.out.println("Encrypted message: " + encryptedMessage);

        // Decryption
        System.out.print("Enter cipher text: ");
        String cipherText = scanner.nextLine();

        System.out.print("Enter key for decryption: ");
        int decryptionKey = scanner.nextInt();

        String decryptedMessage = decryptMessage(decryptionKey, cipherText);
        System.out.println("Decrypted message: " + decryptedMessage);

        scanner.close();
    }
}
