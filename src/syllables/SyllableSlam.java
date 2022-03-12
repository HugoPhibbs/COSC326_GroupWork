package syllables;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
  * Class that predicts the number of syllables in a word
 *
 * @author Laurel Hubbard, Ben Forde, Hugo Phibbs
  */
public class SyllableSlam {

    BufferedReader datasetReader = readDataSet();

    public static void main(String[] args){
        new SyllableSlam().start();
    }

    /**
     * Starts the syllables.SyllableSlam program
     */
    public void start() {
        ArrayList<String> words = inputWords();
        printResults(words);
    }

    /**
     * Counts the number of syllables for each word in an inputted ArrayList.
     *
     * Then prints the result of the counting for each word
     *
     * @param words ArrayList containing Strings for the syllable count to be counted for
     */
    public void printResults(ArrayList<String> words) {
        for (String word : words) {
            if (wordIsValid(word)) {
                System.out.println(syllableCount(word));
            }
            else {
                System.out.printf("'%s' word is not valid!\n", word);
            }
        }
    }


    /**
     * Gets a list of inputted words from a user
     *
     * @return ArrayList<String> containing the words entered by a user
     */
    public ArrayList<String> inputWords() {
        System.out.println("Input words (one per each line)\nPress enter on an empty line to submit");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        while (!word.equals("")) {
            list.add(word.toLowerCase(Locale.ROOT));
            word = scanner.nextLine();
        }
        return list;
    }

    /**
     * Creates an array with elements being the syllables of the word.
     *
     * @param word String for the word to find syllables
     * @return String array as described, otherwise returns an empty array if the syllables could not be found.
     */
    public String[] getSyllableArray(String word) { // throws FileNotFoundException, IOException
        String[] syllables = {};
        try {
            String line = datasetReader.readLine();
            while (line != null) {
                String[] wordArray = line.split("=");
                if (wordArray[0].equals(word)) {
                    syllables = wordArray[1].split("�");
                    return syllables;
                }
                line = datasetReader.readLine();
            }
        }
        catch (IOException ioe){
            System.out.println(ioe.getMessage());
            System.exit(-1);
        }
        return syllables;
    }

    /**
     * Reads the dataset containing words and their syllables
     *
     * @return BufferReader object that can be used to access the dataset
     */
    private BufferedReader readDataSet() {
        try {
            return new BufferedReader(new FileReader("./resources/Syllables.txt"));
        }
        catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.toString());
            System.exit(-1);
        }
        return null;
    }

    /**
     * Checks if an inputted string contains white space or not
     *
     * @param str String
     * @return boolean as described
     */
    private boolean containsWhiteSpace(String str) {
        for (char c : str.toCharArray()) {
            if (c == ' '){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if an inputted word is valid or not
     *
     * (one that can be checked for how many syllables that it has)
     *
     * @param word String as described
     * @return boolean as described
     */
    private boolean wordIsValid(String word) {
        if (word == null) {
            return false;
        }
        return (!containsWhiteSpace(word) & containsOnlyLetters(word) & !word.equals(""));
    }

    /**
     * Checks if an inputted str contains only letters or not
     *
     * @param str String
     * @return boolean as described
     */
    private boolean containsOnlyLetters(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Predicts the number of syllables for a given word
     *
     * If the word can be found in the dataset, then the number of syllables is predicted using a regular expression
     *
     * @param word String for word to find syllables for
     * @throws AssertionError if the inputted word is not valid as per wordIsValid(String)
     * @return int for the number of syllables as described
     */
    private int syllableCount(String word) throws AssertionError {
        assert wordIsValid(word) : "Inputted word is not valid!";
        String[] syllables = getSyllableArray(word);
        if (syllables.length == 0) {
            return syllableCountRegex(word);
        }
        return syllables.length;
    }

    /**
     * Predicts the number of syllables in a word using regular expressions
     *
     * @param word String for a word to find syllables for
     * @return int for a prediction of number of syllables as described
     */
    private int syllableCountRegex(String word) {
        // (0) Initialise the counter.

        int counter = 0;

        // (1) Define a regular expression to find all of the vowel groups (syllables)

        // For more information about how this works, refer to the Java Pattern Class documentation at

        // https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html

        // (?i)                     ; Ignore the lettercase for when searching for the subsequences
        // [aeiouy]                 ; Match any of the vowels [a,e,i,o,u,y]
        // *                        ; This is the greedy quantifier. Matches if preceding pattern in brackets has zero, one or more occurences
        // (?i)[aeiouy][aeiouy]*    ; Matches any case insensitive vowel subsequence that starts with [aA,eE,iI,oO,uU,yY] and is followed with any number of [aA,eE,iI,oO,uU,yY]

        String regex = "(?i)[aeiouy][aeiouy]*";

        // (2) Create a new class matcher object

        Matcher match = Pattern.compile(regex).matcher(word);

        // (3) Loop the Matcher Class find() method until the regex has matched all of the syllable subsequences in the inputWord

        while (match.find()) {
            counter++;
        }

        // (4) Return the number of matches found by the regex

        return counter;
    }
}