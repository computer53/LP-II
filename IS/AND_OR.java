import java.util.Scanner;
public class AND_OR
{
    public static void main(String args[])
    {
        String s="Hello World";
        String result="";
        String resul1="";
        for(int i=0;i<s.length();i++)
        {
            result+=(char)(s.charAt(i)&127);
            resul1+=(char)(s.charAt(i)^127);
        }
        System.out.println(result);
        System.out.println(resul1);
    }
}