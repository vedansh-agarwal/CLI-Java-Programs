//Board based on Milton Bradley Chutes and Ladders gameboard from 1952.

import java.util.*;

public class SnakesAndLadders {
    static final int jumpPositions[][] = {{1, 38}, {4, 14}, {9, 31}, {16, 6}, {21, 42}, {28, 84}, {36, 44}, {47, 26}, {49, 11}, {51, 67}, {62, 19}, {64, 60}, {71, 91}, {80, 100}, {87, 24}, {93, 73}, {95, 75}, {98, 78}};
    static Scanner sc = new Scanner(System.in);
    static String winners;
    static int players[];

    public static void main(String args[]) {
        System.out.print("Enter the no. of players: ");
        int numPlayers = sc.nextInt();
        players = new int[numPlayers];
        sc.nextLine();
        winners = "";
        while (goal().length() == 0)
            for (int i = 0; i < numPlayers; i++) {
                System.out.print("\nPress ENTER to roll for PLAYER " + (i + 1) + ".");
                players[i] = scoreUpdater(players[i], 0, 0);
                snakesLadders(i);
                overthrow(i);
                System.out.println("PLAYER " + (i + 1) + " current position: " + players[i] + ((i == numPlayers - 1) ? "\n" : ""));
            }
        String verb = (winners.indexOf(",") == winners.lastIndexOf(",")) ? " has " : " have ";
        String subject = (winners.indexOf(",") == winners.lastIndexOf(",")) ? "Player " : "Players ";
        System.out.println("\n\n" + subject + winners.substring(1) + verb + "won.\n");
    }

    public static int scoreUpdater(int score, int dice, int counter) {
        Random r = new Random();
        sc.nextLine();
        int roll = 0;
        while (roll == 0)
            roll = r.nextInt(7);
        if (score != 0) {
            if (roll == 6) {
                if (++counter == 3) {
                    if (score == 1) {
                        System.out.print("You've rolled a 6 for the third time in a row which nullifies your roll bringing you back to base. Press ENTER to roll again.");
                        return scoreUpdater(0, 0, 0);
                    } else {
                        System.out.print("You've rolled a 6 for the third time in a row which nullifies your roll. Press ENTER to roll again.");
                        return scoreUpdater(score, 0, 0);
                    }
                } else {
                    System.out.print("You've rolled a 6. Press ENTER to roll again.");
                    return scoreUpdater(score, dice + roll, counter);
                }
            } else if (score + dice + roll <= 100) {
                System.out.println("You've rolled a " + roll + ".");
                return score + dice + roll;
            } else {
                System.out.println("You've rolled a " + roll + " which exceeds the board limit nullifying your roll.");
                return score;
            }
        } else {
            if (roll == 1) {
                System.out.println("You've rolled a 1 and are out of base now.");
                return 1;
            } else if (roll == 6) {
                System.out.print("You've rolled a 6 and are out of base now. Press ENTER to roll again.");
                return scoreUpdater(1, 0, 1);
            } else {
                System.out.println("You've rolled a " + roll + ". You need to roll a 1 or 6 to get out of base.");
                return 0;
            }
        }
    }

    public static String goal() {
        for (int i = 0; i < players.length; i++)
            winners += (players[i] == 100) ? "," + (i + 1) : "";
        return winners;
    }

    public static void snakesLadders(int player_no) {
        for (int i = 0; i < jumpPositions.length; i++) {
            if (players[player_no] == jumpPositions[i][0]) {
                if (players[player_no] < jumpPositions[i][1])
                    System.out.println("Climbed ladder at " + players[player_no] + " and reached " + jumpPositions[i][1] + ".");
                else
                    System.out.println("Mauled by snake at " + players[player_no] + " and pushed out at " + jumpPositions[i][1] + ".");
                players[player_no] = jumpPositions[i][1];
                break;
            }
        }
    }

    public static void overthrow(int player_no) {
        for (int i = 0; i < players.length; i++) {
            if (i != player_no && players[i] == players[player_no] && players[player_no] != 100 && players[player_no] != 0) {
                players[i] = 0;
                System.out.println("PLAYER " + (i + 1) + " has been overthrown by PLAYER " + (player_no + 1) + ".");
                System.out.println("PLAYER " + (i + 1) + " current position: 0");
            }
        }
    }
}