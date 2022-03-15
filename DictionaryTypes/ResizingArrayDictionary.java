package DictionaryTypes;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import DictionaryTypes.abstractClasses.ArrayTypeDictionary;

public class ResizingArrayDictionary extends ArrayTypeDictionary implements DictionaryInterface {

    private Scanner scan;
    private int count = -1;
    private long lines;
    private int convert;
    private int n = 0;
    private String[] array1 = new String[5];

    /**
     * constructor
     */
    public ResizingArrayDictionary() {
        //todo

    }
    /* GENERAL METHODS handin 1*/

    /**
     * @param fileName take in the file path of  a text file,
     * @return returns how many lines are in the textfile
     */
    public static long countLine(String fileName) {
        //function to get the number of lines in the text file so i can create an array with the necessary lines + 5
        Path path = Paths.get(fileName);
        long lines = 0;
        try {
            lines = Files.lines(path).count();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //testt System.out.print(lines);
        return lines;
    }

    /**
     * @param array1 our old array in our case array1 the temp array
     * @param newSize the size we want to convert the array to
     * @return the new array with a different size with the content of the old array
     * //code help from the internet https://www.tutorialspoint.com/how-to-resize-an-array-in-java
     */
    private static Object resizeArray (Object array1, int newSize) {
        //get size of old array
        int oldSize = java.lang.reflect.Array.getLength(array1);
        //checks what the type of the old array is
        Class elementType = array1.getClass().getComponentType();
        //create a new array object
        Object array2 = java.lang.reflect.Array.newInstance(elementType, newSize);
        //checks the smallest size between the old array and the new one
        int preserveLength = Math.min(oldSize, newSize);
        //array needs to be greater than 0 to be created
        if (preserveLength > 0)
            //copies contents of the old array into the new array
            System.arraycopy(array1, 0, array2, 0, preserveLength);
        //returns new array with all the old arrays conents
        return array2;
    }

    /**
     * @param filepath take in the file path of  a text file,
     *                 takes lines in the text file and creates a new array with array1 added to it
     *                 the new array is filled with all the words in the textfile
     */
    public void CreateDictionary(String filepath) {
        //todo
        try {
            File file = new File(filepath);
            scan = new Scanner(file);
            int convert = (int)countLine(filepath);

            while(scan.hasNextLine()){
                //count starts at 0
                count++;
                if (count >= array1.length) {
                    array1 = (String[]) resizeArray(array1, array1.length + convert);
                }
                array1[count] = scan.nextLine();
                // test
                // System.out.println(array1[count]);
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
        for (String wordInDict : array1) {
            if (word.equalsIgnoreCase(wordInDict)) {
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
     *             if the array is full then we double the size of the array and then add the word
     */
    public void addNewWord(String word) {
       //todo
        count++;
            if (count >= array1.length) {
                array1 = (String[]) resizeArray(array1, array1.length * 2);
            }
                if (!isWord(word)) {
                    array1[count] = word;
                }
//      test
//      for(int i = 0; i <array1.length; i++){
//            System.out.println(array1[i]);
//        }
        }

    /**
     * @param word takes in any word of type string
     *             if the word is in the array then it get removed, if the word isnt in the array nothing happens
     */
    public void removeWord(String word) {
        //todo
        //index
        int index = IntStream.range(0, count)
                .filter(i -> word.equalsIgnoreCase(array1[i]))
                .findFirst().orElse(-1);

        if (index != -1) {
            array1[index] = null;
        }
        //System.out.println(Arrays.toString(array1));
    }

    /**
     * @return takes in nothing, but returns an arraylist
     *          using the array we have updated throughout the class we convert it into a list and then into an arraylsit
     */
    public ArrayList<String> getDictionaryWords() {
        //todo
        List<String> DictionaryList = new ArrayList<String>();
        for(String text:array1) {
            DictionaryList.add(text);
        }
        ArrayList<String> MyList = new ArrayList<String>();
        MyList.addAll(DictionaryList);
        //System.out.println(MyList);
        return MyList;

    }

    /**
     * @return takes no input returns an integer of all the words in the array
     *          completely ignores all the null values and only gives the number of actual words
     */
    public int getNumberOfElements() {
        //todo
        int number = 0;
        for(String word :array1)
            if( word != null)
                ++number;
        System.out.println(number);
        return number;

    }



}
