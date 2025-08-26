import java.util.Random;
import java.util.Scanner;

public class SnakeLadder2Players {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int p1 = 1, p2 = 1; // player positions
        boolean turn = true; // true = Player 1, false = Player 2

        System.out.println("🎲 Snake and Ladder Game - 2 Players!");
        System.out.println("Start at 1, reach 100 to win.");
        System.out.println("Press ENTER to roll the dice...");

        while (p1 < 100 && p2 < 100) {
            sc.nextLine(); // wait for user

            int dice = rand.nextInt(6) + 1; // dice roll
            if (turn) {
                System.out.println("Player 1 rolled: " + dice);
                p1 += dice;
                if (p1 > 100) p1 = 100;
                p1 = checkSnakesAndLadders(p1);
                System.out.println("Player 1 is now at " + p1);
            } else {
                System.out.println("Player 2 rolled: " + dice);
                p2 += dice;
                if (p2 > 100) p2 = 100;
                p2 = checkSnakesAndLadders(p2);
                System.out.println("Player 2 is now at " + p2);
            }

            turn = !turn; // switch player
        }

        if (p1 == 100) {
            System.out.println("🎉 Player 1 wins!");
        } else {
            System.out.println("🎉 Player 2 wins!");
        }

        sc.close();
    }

    
    public static int checkSnakesAndLadders(int pos) {
        // Ladders
        if (pos == 4) return 25;
        else if (pos == 20) return 50;
        else if (pos == 45) return 75;

        // Snakes
        else if (pos == 99) return 10;
        else if (pos == 90) return 40;
        else if (pos == 70) return 30;

        return pos;
    }
}
