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

        ArrayList<String[]> pictures = new ArrayList<>(Arrays.asList(
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "       |\n",
                        "       |\n",
                        "       |\n",
                        "       |\n",
                        "=========\n"
                },
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "  O    |\n",
                        "       |\n",
                        "       |\n",
                        "       |\n",
                        "=========\n"
                },
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "  O    |\n",
                        "  |    |\n",
                        "       |\n",
                        "       |\n",
                        "=========\n"
                },
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "  O    |\n",
                        " /|    |\n",
                        "       |\n",
                        "       |\n",
                        "=========\n"
                },
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "  O    |\n",
                        " /|\\   |\n",
                        "       |\n",
                        "       |\n",
                        "=========\n"
                },
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "  O    |\n",
                        " /|\\   |\n",
                        " /     |\n",
                        "       |\n",
                        "=========\n"
                },
                new String[] {
                        "  +----+\n",
                        "  |    |\n",
                        "  O    |\n",
                        " /|\\   |\n",
                        " / \\   |\n",
                        "       |\n",
                        "=========\n"
                }
        ));

        Arrays.fill(stars, '*');
        int count = 7;

        while (count < 8) {
            System.out.println("The word is: " + String.valueOf(stars));

            System.out.print("Input a letter ");
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

                System.out.println("Letter not Found! ");
                System.out.println("You have " + count + " lives ");
                for (String element : pictures.get(0)){
                    System.out.println(element);
                }
                pictures.remove(0);

                if ( count < 1){
                    System.out.println("Game Over");
                    break;
                }
            }

            if (hiddenWord.equalsIgnoreCase(String.valueOf(stars))) {
                System.out.println("You won!");
                break;
            }
        }
    }
}