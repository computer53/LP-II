public class AND_OR_2 {
    public static void main(String[] args) {
        String str = "HelloWorld";

        System.out.println("Original String: " + str);

        System.out.println("Decimal Representation:");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.print((int) c + " ");
        }
        System.out.println();

        System.out.println("Binary Representation:");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.print(Integer.toBinaryString(c) + " ");
        }
        System.out.println();

        // AND operation
        System.out.println("AND operation with 127 (Binary & Decimal):");
        StringBuilder andStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int andResult = c & 127;
            System.out.print(Integer.toBinaryString(andResult) + "(" + andResult + ") ");
            andStr.append((char) andResult);
        }
        System.out.println();
        System.out.println("String after AND operation: " + andStr);

        // XOR operation
        System.out.println("XOR operation with 127 (Binary & Decimal):");
        StringBuilder xorStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int xorResult = c ^ 127;
            System.out.print(Integer.toBinaryString(xorResult) + "(" + xorResult + ") ");
            xorStr.append((char) xorResult);
        }
        System.out.println();
        System.out.println("String after XOR operation: " + xorStr);
    }
}
