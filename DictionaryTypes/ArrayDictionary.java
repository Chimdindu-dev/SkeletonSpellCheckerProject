package DictionaryTypes;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import DictionaryTypes.abstractClasses.ArrayTypeDictionary;

public class ArrayDictionary extends ArrayTypeDictionary implements DictionaryInterface {
    private Scanner scan;
    private final String[] words = new String[30000];
    private int count = -1;

    /**
     * constructor
     */
    public ArrayDictionary() {
        //todo
    }
    /* GENERAL METHODS Hand-in 1*/
    /**
     * @param filepath take in the file path of  a text file,
     *                 returns nothing but creates a array of size 30000 and fills it with text file contents.
     */
    public void CreateDictionary(String filepath) {
        //todo
        try {
            File file = new File(filepath);
            scan = new Scanner(file);

            while(scan.hasNextLine()){
                count++;
                words[count] = scan.nextLine();
                //test
                //System.out.println(words[count]);
            }
        }catch (IOException e){
            System.out.println(e);
        }

    }

    /**
     * @param word takes in any word of type string
     * @return checks if the word is in the array returns true if it is and returns false if its not
     */
    public boolean isWord(String word) {
        //todo
        for(String wordInDict: words) {
            if(word.equalsIgnoreCase(wordInDict)){
                return true;
            }
        }
        return false;
    }

    /**
     * @param word takes in any word of type string
     *             doesnt return anything but checks if the word is in the array using the isword method
     *             if the word is in the array nothing happens
     *             if the word isn't in the array the add it
     */
    public void addNewWord(String word) {
        //todo
                if (!isWord(word)) {
                    words[++count] = word;
               }
    }

    /**
     * @param word takes in any word of type string
     *             if the word is in the array then it get removed, if the word isnt in the array nothing happens
     */
    public void removeWord(String word) {
        //todo

        // Get index of the word
       int index = IntStream.range(0, count)
                .filter(i -> word.equalsIgnoreCase(words[i]))
                .findFirst().orElse(-1);

       if (index != -1)
        words[index] = null;
        //test
        //System.out.println(Arrays.toString(words));
    }

    /**
     * @return takes in nothing, but returns an arraylist
     *          using the array we have updated throughout the class we convert it into a list and then into an arraylsit
     */
    public ArrayList<String> getDictionaryWords() {
        //todo im gonna take my array and convert it to an array list to print out all the updates made in the dictionary etc
        List<String> Dictionarylist = new ArrayList<String>();
        for(String text:words) {
            Dictionarylist.add(text);
        }
        ArrayList<String> myList = new ArrayList<String>();
        myList.addAll(Dictionarylist);

        return myList;
    }

    /**
     * @return takes no input returns an integer of all the words in the array
     *          completely ignores all the null values and only gives the number of actual words
     */
    public int getNumberOfElements() {
       //todo
        int number = 0;
        for(String word :words)
            if( word != null)
                ++number;
            return number;
    }



}
