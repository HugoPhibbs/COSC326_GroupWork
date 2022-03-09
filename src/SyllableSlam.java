import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
  * Class that predicts the number of syllables in a word
  */
public class SyllableSlam {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine().toLowerCase();
        System.out.println("Estimated number of syllables = " + syllableCount(word));
        scanner.close();
    }

    public static String[] getSyllableArray(String word) { // throws FileNotFoundException, IOException 
        String[] syllables = {};
        try (BufferedReader reader = new BufferedReader(new FileReader("Syllables.txt"))) {
            for (String line; (line = reader.readLine()) != null;) {
                String[] wordArray = line.split("=");
                if (wordArray[0].equals(word)) {
                    syllables = wordArray[1].split("�");
                    return syllables;
                }
            }
        } catch (Exception e){
            System.out.println("cant find dataset");
        }
        return syllables;
    }

    public static int syllableCount(String word) {

        String[] syllables = getSyllableArray(word);
        
        if (syllables.length == 0) {
            return SyllableCounter.count(word);
        } 

        return syllables.length;
    }

}