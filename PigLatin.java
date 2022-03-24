/*
Write a program that encodes a word into Pig Latin. 
To translate word into a pig latin word, convert the word in 
to Uppercase and then place the first vowel of the original word 
as the start of new word along with the remaining alphabets. 
The alphabets present before the vowel being shifted towards the end followed by “AY”.
Example: London ONDONLAY   And  Olympics  OLYMPICSAY
*/
import java.io.*;
public class PigLatin
{
    public static void main(String args[])throws IOException
    {
        BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the string to be converted to Pig Latin : ");
        String s = a.readLine();
        int i = 0,d = 0;
        for(i = 0;i<s.length();i++)
        {
            if("aeiouAEIOU".indexOf(s.charAt(i)) != -1) {
                d = i;
                break;
            }
        }
        String s1 = s.substring(d);
        String s2 = s.substring(0,d);
        String output = s1+s2+"ay";
        output = output.toUpperCase();
        System.out.println("Your String converted to Pig Latin : "+output);
    }
}
