import DictionaryTypes.*;
import DictionaryTypes.abstractClasses.Dictionary;

import java.util.Scanner;

public class SpellChecker_SU22703918 {

    DictionaryInterface spellChecker;

    /**
     * @param checkerType not dont by me but basically used to determine which dictionary to use
     */
    public SpellChecker_SU22703918(String checkerType) {
        if (checkerType.equals("Trie")) {
            spellChecker = new TrieDictionary();
        } else if (checkerType.equals("Array")) {
            spellChecker = new ArrayDictionary();
        } else if (checkerType.equals("ResizingArray")) {
            spellChecker = new ResizingArrayDictionary();
        } else {
            System.out.println("Invalid command line input, use one of: Trie, Array, or ResizingArray");
            System.exit(0);
        }
    }

    /**
     * @param word input a word
     * @return boolean value if the word is in the input language(text file) true if it is and false if it isnt.
     */
    public boolean check(String word) {
        return spellChecker.isWord(word);
    }

    /**
     * @param wordToCheck puts in a incorrectly spelt word
     * @return returns a word that is the closest spelt word to it
     */
    public String getBestSuggestion(String wordToCheck) {
        //todo
        String[] wordclose = spellChecker.getTopNSuggestions(spellChecker.getDictionaryWords(), wordToCheck, 1);
        return wordclose[0];
    }
}
