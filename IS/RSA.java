// Java Program for implementation of RSA Algorithm

import java.math.BigInteger;

class RSA {

    // Function to compute base^expo mod m using BigInteger
    static BigInteger power(BigInteger base, BigInteger expo, BigInteger m) {
        return base.modPow(expo, m);
    }

    // Function to find modular inverse of e modulo phi(n)
    static BigInteger modInverse(BigInteger e, BigInteger phi) {
        return e.modInverse(phi);
    }

    // RSA Key Generation
    static void generateKeys(BigInteger[] keys) {
        BigInteger p = new BigInteger("7919");
        BigInteger q = new BigInteger("1009");
        
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Choose e, where 1 < e < phi(n) and gcd(e, phi(n)) == 1
        BigInteger e = BigInteger.ZERO;
        for (e = new BigInteger("2"); e.compareTo(phi) < 0; e = e.add(BigInteger.ONE)) {
            if (e.gcd(phi).equals(BigInteger.ONE)) {
                break;
            }
        }

        // Compute d such that e * d ≡ 1 (mod phi(n))
        BigInteger d = modInverse(e, phi);

        keys[0] = e;  // Public Key (e)
        keys[1] = d;  // Private Key (d)
        keys[2] = n;  // Modulus (n)
    }

    // Encrypt message using public key (e, n)
    static BigInteger encrypt(BigInteger m, BigInteger e, BigInteger n) {
        return power(m, e, n);
    }

    // Decrypt message using private key (d, n)
    static BigInteger decrypt(BigInteger c, BigInteger d, BigInteger n) {
        return power(c, d, n);
    }

    public static void main(String[] args) {
        BigInteger[] keys = new BigInteger[3]; // e, d, n
        
        // Key Generation
        generateKeys(keys);
      
        System.out.println("Public Key (e, n): (" + keys[0] + ", " + keys[2] + ")");
        System.out.println("Private Key (d, n): (" + keys[1] + ", " + keys[2] + ")");

        // Message
        BigInteger M = new BigInteger("123");
        System.out.println("Original Message: " + M);

        // Encrypt the message
        BigInteger C = encrypt(M, keys[0], keys[2]);
        System.out.println("Encrypted Message: " + C);

        // Decrypt the message
        BigInteger decrypted = decrypt(C, keys[1], keys[2]);
        System.out.println("Decrypted Message: " + decrypted);
    }
}