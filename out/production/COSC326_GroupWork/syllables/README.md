# Syllable Slam
By Ben Forde, Hugo Phibbs and Laurel Hubbard.

## Compilation and Running
- Extract the zip folder, this is the top level directory for the next steps
- To compile SyllableSlam enter:
```shell
something
```
- Then to run enter:
```shell
something
```

## Using the program
- After running, you will be prompted to enter a list of words, one per each line. When you are ready, press enter on an empty line

## How our program works
- Consider finding the syllable count for a single word... 
- The word is first checked to be included in a dataset of words and their syllables (this can be found at http://www.delphiforfun.org/programs/Syllables.htm). 
- If the word is not found in this dataset, then regular expressions are used to guess the number of syllables.

## Test cases
- Our solution was found to have mixed results...

| Word            | SyllableCount | Actual Count |
|-----------------|---------------|--------------|
| Algorithmically |               |              |
| Can             |               |              |
| Space           |               |              |
| White           |               |              |
| Attitude        |               |              |
| Reader          |               |              |
| Locale          |               |              |