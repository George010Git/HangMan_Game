import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        ArrayList<String> words = new ArrayList<>(Arrays.asList("welcome", "human", "understand", "computer", "programmer", "revolution",
                "laundry", "notorious", "engagement", "alive", "depressed", "president", "addicted", "production", "formula"));
        int index = rnd.nextInt(words.size());

        System.out.println("Welcome to Hang Man");
        String hiddenWord = words.get(index);

        char[] stars = new char[hiddenWord.length()];

        Arrays.fill(stars, '*');
        int count = 5;

        while (count < 6) {
            System.out.println("The word is: " + String.valueOf(stars));

            System.out.print("Introduceti o litera ");
            char letter = sc.next().charAt(0);
            boolean isLetterFound = false;

            for (int i = 0; i < hiddenWord.length(); i++) {
                if (hiddenWord.charAt(i) == letter) {
                    stars[i] = letter;
                    isLetterFound = true;
                }
            }

            if (!isLetterFound) {
                count--;
                if ( count < 1){
                    System.out.println("Game Over");
                    break;
                }
                System.out.println("Letter not Found! ");
                System.out.println("You have " + count + " lives ");
            }

            if (hiddenWord.equalsIgnoreCase(String.valueOf(stars))) {
                System.out.println("You won!");
                break;
            }
        }
    }
}