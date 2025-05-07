import java.math.BigInteger;
import java.util.Scanner;

public class RSA {

    // Method to compute GCD
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Choose two prime numbers (small for simplicity)
        int p = 3;
        int q = 11;

        // 2. Compute n = p * q
        int n = p * q;

        // 3. Compute phi = (p - 1) * (q - 1)
        int phi = (p - 1) * (q - 1);

        // 4. Calculate e automatically
        int e = 2;
        while (e < phi) {
            if (gcd(e, phi) == 1) {
                break;
            }
            e++;
        }

        // 5. Compute d such that (d * e) % phi == 1
        int d = 0;
        for (int i = 1; i < phi; i++) {
            if ((i * e) % phi == 1) {
                d = i;
                break;
            }
        }

        System.out.println("Public Key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private Key (d, n): (" + d + ", " + n + ")");

        // 6. Get message from user
        System.out.print("Enter a message (number < " + n + "): ");
        int msg = sc.nextInt();

        // 7. Encrypt: c = (msg^e) % n
        BigInteger C = BigInteger.valueOf(msg).pow(e).mod(BigInteger.valueOf(n));
        System.out.println("Encrypted message: " + C);

        // 8. Decrypt: m = (c^d) % n
        BigInteger M = C.pow(d).mod(BigInteger.valueOf(n));
        System.out.println("Decrypted message: " + M);

        sc.close();
    }
}
