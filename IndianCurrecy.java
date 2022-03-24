import java.util.*;
public class IndianCurrecy
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to be converted (without commas): ");
        long n = sc.nextLong();
        int counter = 0;
        String s[] = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
        "Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen",
        "Eighteen","Nineteen","Twenty","Twenty-One","Twenty-Two","Twenty-Three",
        "Twenty-Four","Twenty-Five","Twenty-Six","Twenty-Seven","Twenty-Eight",
        "Twenty-Nine","Thirty","Thirty-One","Thirty-Two","Thirty-Three","Thirty-Four",
        "Thirty-Five","Thirty-Six","Thirty-Seven","Thirty-Eight","Thirty-Nine","Forty",
        "Forty-One","Forty-Two","Forty-Three","Forty-Four","Forty-Five","Forty-Six",
        "Forty-Seven","Forty-Eight","Forty-Nine","Fifty","Fifty-One","Fifty-Two",
        "Fifty-Three","Fifty-Four","Fifty-Five","Fifty-Six","Fifty-Seven","Fifty-Eight",
        "Fifty-Nine","Sixty","Sixty-One","Sixty-Two","Sixty-Three","Sixty-Four",
        "Sixty-Five","Sixty-Six","Sixty-Seven","Sixty-Eight","Sixty-Nine","Seventy",
        "Seventy-One","Seventy-Two","Seventy-Three","Seventy-Four","Seventy-Five",
        "Seventy-Six","Seventy-Seven","Seventy-Eight","Seventy-Nine","Eighty",
        "Eighty-One","Eighty-Two","Eighty-Three","Eighty-Four","Eighty-Five",
        "Eighty-Six","Eighty-Seven","Eighty-Eight","Eighty-Nine","Ninety","Ninety-One",
        "Ninety-Two","Ninety-Three","Ninety-Four","Ninety-Five","Ninety-Six",
        "Ninety-Seven","Ninety-Eight","Ninety-Nine"};
        String s1[] = {" Shankh "," Padma "," Neel "," Kharab "," Arab "," Crore ",
        " Lakh "," Thousand "};
        String output = "";
        for(int i = 17;i >= 3;i = i-2)
        {
            if(n > (long)Math.pow(10,i))
            {
                output += s[(int)(n/(long)Math.pow(10,i))]+ s1[counter];
                n = n % (long)Math.pow(10,i);
            }
            counter++;
        }
        if(n > (long)Math.pow(10,2))
        {
            output += s[(int)(n/(long)Math.pow(10,2))]+" Hundred ";
            n = n % (long)Math.pow(10,2);
        }
        output += s[(int)n];
        System.out.println(output);
    }
}
