package DictionaryTypes;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import DictionaryTypes.TrieStructureComponents.Edge;
import DictionaryTypes.TrieStructureComponents.State;
import DictionaryTypes.abstractClasses.Dictionary;
import org.w3c.dom.Node;

public class TrieDictionary extends Dictionary implements DictionaryInterface {


    private String dictionary;
    LinkedList<String> dictionarylist = new LinkedList<>();
    private Scanner scan;
    int count = -1;
    Edge root;
    private ArrayList<String> words = new ArrayList<String>();


    public TrieDictionary() {
       //root = new Node('\0');
    }


    /* SPECIFIC METHODS - Hand in 2 */
    public ArrayList<Character> BFS() {
        //todo
        return null;
    }

    public ArrayList<Character> DFS() {
        //todo
        return null;
    }

    /* GENERAL METHODS - Hand in 1*/
    public static String findCommonPrefix(String word){
        //todo
        String commonPrefix = "";
        return commonPrefix;
    }


    /**
     * @param word1 inputs a string if the word is in the linkedlist then the word is removed
     */
    public void removeWord(String word1) {
        //todo
        if (isWord(word1) == true) {
            dictionarylist.remove(word1);
        }

    }

//    public void CreateDictionary(String filePath) {
//        //todo
//        try {
//            File file = new File(filePath);
//            scan = new Scanner(file);
//            State startState = new State(0, false, "");
//            char letter;
//            while(scan.hasNextLine()){
//                String word = scan.nextLine();
//                String wordUpTill = "";
//                State newState;
//                for(int i = 0; i < word.length(); i++){
//                    letter = word.charAt(i);
//                    wordUpTill = wordUpTill + letter;
//                    if(i == 0){
//                        Edge edge = new Edge(letter, startState);
//                        System.out.println(edge.getCh());
//                        System.out.println(edge.getS());
//
//                    }else {
//
//                        if (i == word.length() - 1) {
//                            newState = new State(i, true, word);
//                        } else {
//                            newState = new State(i, false, wordUpTill);
//                        }
//                        Edge edge = new Edge(letter, newState);
//                        System.out.println(edge.getCh());
//                        System.out.println(edge.getS());
//                    }
//                }
////                count++;
////                words.add(scan.nextLine());
//                //words[count] = scan.nextLine();
//                //LinkedList<String>
//                //dictionarylist.add(words[count]);
//
////                //test
////                System.out.println(words[count]);
//            }
//        }catch (IOException e){
//            System.out.println(e);
//        }
//    }

    /**
     * @param filePath take in the file path of  a text file,
     *                 returns nothing but creates a linkedlist containing all the words in the textfile
     */
    public void CreateDictionary(String filePath) {
        //todo
        try {
            File file = new File(filePath);
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String word = scan.nextLine();
                dictionarylist.add(word);
//                for(String yess: dictionarylist) {
//                    //System.out.println(yess);
//                }
            }
        }catch(IOException e){
                System.out.println(e);
            }


    }

    /**
     * @param word inputs a string
     * @return returns true if word is in linked list and false if it isnt
     */
    public boolean isWord(String word) {
        //todo
        for(String wordInDict: dictionarylist) {
            if(word.equalsIgnoreCase(wordInDict)){
                return true;
            }
        }
        return false;
    }

    /**
     * @param w inputs a string if the word is in the linkedlist then the word is added
     */
    public void addNewWord(String w) {
        //todo
        if (!isWord(w)) {
            dictionarylist.add(w);
        }
    }

    /**
     * @return converts linkedlist into an arraylist
     */
    public ArrayList<String> getDictionaryWords() {
        //todo
        ArrayList<String> myList = new ArrayList<>(dictionarylist);

        return myList;
    }

    /**
     * @return takes no input returns an integer of all the words in the linked list that arent null
     */
    public int getNumberOfElements() {
        //todo
         int number = 0;
                for(String word :dictionarylist)
                    if( word != null)
                        ++number;
                    return number;
    }


}
