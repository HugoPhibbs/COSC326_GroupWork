import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class that predicts the number of syllables in a word
 */
public class SyllableSlam {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        String word = scanner.nextLine();
        
        System.out.println(word.charAt(6));

    }

    public String[] getSyllableArray(String word) throws FileNotFoundException, IOException{
        String[] syllables = {};

        try (BufferedReader reader = new BufferedReader(new FileReader("Syllables.txt"))){
            for(String line; (line = reader.readLine()) != null; ) {
                String [] wordArray = line.split("=");
                if(wordArray[0].equals(word)){
                    syllables = wordArray[1].split(" ");

                }
        }
    }
    return syllables;
    } 
}