import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyllableCounter {
    
    public static int count(String inputWord) {

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

        Matcher match = Pattern.compile(regex).matcher(inputWord);
        
        // (3) Loop the Matcher Class find() method until the regex has matched all of the syllable subsequences in the inputWord

        while (match.find()) {
            counter++;
        }

        // (4) Return the number of matches found by the regex

        return counter;

    } 


}
