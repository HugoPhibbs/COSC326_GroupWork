# Syllable Slam
By Ben Forde, Hugo Phibbs and Laurel Hubbard.

## Compilation and Running
- Extract the zip folder, this is the top level directory for the next steps
- To compile SyllableSlam enter:
```shell
javac -d out -cp src src/syllables/SyllableSlam.java
```
- Then to run enter:
```shell
java -cp out syllables/SyllableSlam
```

## Using the program
- After running, you will be prompted to enter a list of words, one per each line. When you are ready, press enter on an empty line
- The result will be a list of integers, one per line. These are the predictions of the number of syllables for the words you entered (in order they were entered)

## How our program works
- Consider finding the syllable count for a single word... 
- The word is first checked to be included in a dataset of words and their syllables (this can be found at http://www.delphiforfun.org/programs/Syllables.htm). 
- If the word is not found in this dataset, then regular expressions are used to guess the number of syllables.

## Libraries used
- We used java.util.regex to help with regular expressions. 

## Test cases
- Our solution was found to have mixed results...

| Word            | SyllableCount | Actual Count |
|-----------------|---------------|--------------|
| Algorithmically | 6             | 6            |
| Can             | 1             | 1            |
| Space           | 2             | 1            |
| White           | 2             | 1            |
| Attitude        | 4             | 3            |
| Reader          | 2             | 2            |
| Locale          | 3             | 2            |
