//Board based on Milton Bradley Chutes and Ladders gameboard from 1952.
import java.util.*;
public class SnakesAndLadders
{
    static Scanner sc = new Scanner(System.in);
    static String winners;
    public static void main(String args[])
    {
        System.out.print("Enter the no. of players: ");
        int N = sc.nextInt(),A[] = new int[N],i;
        sc.nextLine();
        winners = "";
        while(Goal(A))
        for(i = 0; i < N; i++)
        {
            System.out.print("\nPress ENTER to roll for PLAYER "+(i+1)+".");
            A[i] = ScoreUpdater(A[i],0,0);
            A[i] = SnL(A[i]);
            A = Katti(i,A[i],A);
            System.out.println("PLAYER "+(i+1)+" current position: "+A[i]+((i == N-1)?"\n":""));
        }
        String verb = (winners.length() == 2)?" has ":" have ",Num = (winners.length() == 2)?"Player ":"Players ";
        System.out.println("\n\n\n"+Num+winners.substring(0,winners.length()-1)+verb+"won.");
    }
    public static int ScoreUpdater(int score,int dice,int counter)
    {
        Random r = new Random();
        sc.nextLine();
        int roll = 0;
        while(roll == 0)
        roll = r.nextInt(7);
        if(score != 0)
        {
            if(roll == 6)
            {
                if(++counter == 3)
                {
                    if(score == 1)
                    {
                        System.out.print("You've rolled a 6 for the third time in a row which nullifies your roll bringing you back to base. Press ENTER to roll again.");
                        return ScoreUpdater(0,0,0);
                    }
                    else
                    {
                        System.out.print("You've rolled a 6 for the third time in a row which nullifies your roll. Press ENTER to roll again.");
                        return ScoreUpdater(score,0,0);
                    }
                }
                else
                {
                    System.out.print("You've rolled a 6. Press ENTER to roll again.");
                    return ScoreUpdater(score,dice+roll,counter);
                }
            }
            else
            if(score+dice+roll <= 100)
            {
                System.out.println("You've rolled a "+roll+".");
                return score+dice+roll;
            }
            else
            {
                System.out.println("You've rolled a "+roll+" which exceeds the board limit nullifying your roll.");
                return score;
            }
        }
        else
        {
            if(roll == 1)
            {
                System.out.println("You've rolled a 1 and are out of base now.");
                return 1;
            }
            else if(roll == 6)
            {
                System.out.print("You've rolled a 6 and are out of base now. Press ENTER to roll again.");
                return ScoreUpdater(1,0,1);
            }
            else
            {
                System.out.println("You've rolled a "+roll+". You need to roll a 1 or 6 to get out of base.");
                return 0;
            }
        }
    }
    public static boolean Goal(int A[])
    {
        boolean r = true;
        for(int i = 0;i < A.length;i++)
        if(A[i] == 100)
        {
            winners = winners + (i+1) + ",";
            r = false;
        }
        return r;
    }
    public static int SnL(int position)
    {
        int result = position;
        if(position == 1 || position == 4 || position == 9 || position == 21 || position == 28 || position == 36 || position == 51 || position == 71 || position == 80)
        {
            switch(position)
            {
                case 1:  result = 38;
                         break;
                case 4:  result = 14;
                         break;
                case 9:  result = 31;
                         break;
                case 21: result = 42;
                         break;
                case 28: result = 84;
                         break;
                case 36: result = 44;
                         break;
                case 51: result = 67;
                         break;
                case 71: result = 91;
                         break;
                case 80: result = 100;
                         break;
            }
            System.out.println("Climbed ladder at "+position+" and reached "+result+".");
        }
        else if(position == 16 || position == 47 || position == 49 || position == 56 || position == 62 || position == 64 || position == 87 || position == 93 || position == 95 || position == 98)
        {
            switch(position)
            {
                case 16: result = 6;
                         break;
                case 47: result = 26;
                         break;
                case 49: result = 11;
                         break;
                case 56: result = 53;
                         break;
                case 62: result = 19;
                         break;
                case 64: result = 60;
                         break;
                case 87: result = 24;
                         break;
                case 93: result = 73;
                         break;
                case 95: result = 75;
                         break;
                case 98: result = 78;
                         break;
            }
            System.out.println("Mauled by snake at "+position+" and pushed out at "+result+".");
        }
        return result;
    }
    public static int[] Katti(int goti,int position,int A[])
    {
        for(int i = 0; i < A.length;i++)
        {
            if(i != goti && A[i] == position && position != 100 && position != 0)
            {
                A[i] = 0;
                System.out.println("PLAYER "+(i+1)+" has been overthrown by PLAYER "+(goti+1)+".");
                System.out.println("PLAYER "+(i+1)+" current position: 0");
            }
        }
        return A;
    }
}
