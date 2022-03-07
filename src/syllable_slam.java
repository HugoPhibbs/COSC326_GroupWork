import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class syllable_slam {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.nextLine();
        System.out.println(syllableCount(getSyllableArray(word)));

    }

    public static String[] getSyllableArray(String word) throws FileNotFoundException, IOException {
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
            
            // will add the average method later which just get the average of words the same length.
        }
        return syllables;
    }

    public static int syllableCount(String[] syllables) {
        int count = 0;
        for(int i = 0; i< syllables.length; i++ ){
            count++;

        }
        return count;
    }

}