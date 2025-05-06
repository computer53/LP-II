public class new1{
    public static void main(String[] args) {
        String str = "Hello World";

        System.out.println("Character | ASCII | AND with 127 | XOR with 127");
        System.out.println("----------------------------------------------");

        for (char ch : str.toCharArray()) {
            int asciiValue = (int) ch; 
            int andResult = ch & 127;   
            int xorResult = ch ^ 127;   

            System.out.printf("    %c     |  %3d  |     %3d     |     %3d\n", ch, asciiValue, andResult, xorResult);
        }
    }
}
