package DictionaryTypes.abstractClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public abstract class Dictionary {

    private String[] topSuggestions;


    /**
     * @param dictionaryWords arraylist we converted from our arrays and linkedlist
     * @param word an incorrect word
     * @param N int to determine size of the array
     * @return  take an array list and remove all the null values
     *          make 2 arrays one for the words in arraylist and one for the lavenstein distance
     *          find lavenstein distance for each word in the arraylist
     *          store the word in closeword array and the respective levenstein distance in distance array
     *          sort the distance array and the closeword array in ascending order
     *          make a string array called topsuggestions of size N determined by the input integer
     *          store the words that have the smallest lavenstein distance in the topsuggestions array
     *          return the topsuggestions array
     */
    public String[] getTopNSuggestions(ArrayList<String> dictionaryWords, String word, int N) {
        // todo
        dictionaryWords.removeAll(Collections.singleton(null));

        int lengthofdict = dictionaryWords.size();
        String[] closewords = new String[lengthofdict];
        int[] distance = new int[lengthofdict];

        int counter = -1;
        for (String words: dictionaryWords){
                counter++;
                //System.out.println(words);
                int a = getLevenshteinDistance(word, words);
                closewords[counter] = words;
                distance[counter] = a;

        }
        for(int i = 0 ; i < lengthofdict; i++){
            for(int j = i +1; j<lengthofdict ; j++){
                int tmp = 0;
                String wordtmp;
                if(distance[i] > distance[j]){
                    tmp = distance[i];
                    distance[i] = distance[j];
                    distance[j] = tmp;
                    wordtmp = closewords[i];
                    closewords[i] = closewords[j];
                    closewords[j] = wordtmp;
                }
            }
        }
        String[] topSuggestions = new String[N];
        for(int i = 0; i<N; i++){
                topSuggestions[i] = closewords[i];
        }

        return topSuggestions;
    }

    /**
     * @param wrongWord take in a incorrectly spelt word
     * @param actualWord take in the word that is correctly spelt
     * @return how many words are different between the wrong and actual word
     *
     * help for #GeeksforGeeks
     */
    public int getLevenshteinDistance(String wrongWord, String actualWord) {
        // todo
        //The Levenshtein distance gives how many words are different between two Strings.
        //go through the two strings word for word,
        //if the word is the same cool, if the word is different 0.

        int[][] lev = new int[wrongWord.length()+1][actualWord.length()+1];

        for (int i = 0; i <= wrongWord.length(); i++){
            for (int j = 0; j <= actualWord.length(); j++){
                //if wrrongword is empty then distance is all of the actualword
                if (i == 0) {
                    lev[i][j] = j;
                }
                //if actualword is empty then distance is all of the wrongword
                else if (j == 0) {
                    lev[i][j] = i;
                }
                else {
                    // find the min
                    lev[i][j] = min(lev[i - 1][j - 1] + sub(wrongWord.charAt(i - 1), actualWord.charAt(j - 1)),//replace
                            lev[i - 1][j] + 1, //delete
                            lev[i][j - 1] + 1); //insert
                }
            }
            }
        //System.out.print(lev[wrongWord.length()][actualWord.length()]);

        return lev[wrongWord.length()][actualWord.length()];
        }


    /**
     * @param a a character
     * @param b another character
     * @return comes two characters and checks if they are the same
     */
    public static int sub(char a, char b) {
        // check for distinct characters
        // in str1 and str2
        return a == b ? 0 : 1;
    }

    /**
     * @param numbers takes the count  of the different
     * @return  minimum value among them
     */
    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }



    }
    

