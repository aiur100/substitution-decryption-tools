/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubstitutionCipherDecryptionTools;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Provides information about a given string block. 
 * 
 * letter frequency, word frequency.  
 * 
 * @author theCaptain
 */
public class EncryptionAnalyzer {
    
    private final String              textToAnalyze;
    private final Integer[]           aLetterCountList;
    private final String[]            words;
    private final Integer             letterCountArraySize = 26;
    private final Alphabet            anAlphabet;
    
    /**
     * constructor 
     * @param fileText - String block from file to analyze
     */
    public EncryptionAnalyzer(String fileText){
        textToAnalyze       = fileText;
        aLetterCountList    = new Integer[26];
        anAlphabet          = new Alphabet();
        words               = new String[textToAnalyze.length()];
        initializeLetterCountList();
        countLetters();
    }
    
    /**
     * get words - using hash maps. 
     * 
     * it's like an array where key => value. 
     * except, you can have an array where the 
     * key is a string or any data type, and the data in that array
     * is any data type. 
     * 
     * The data structure here is 
     * [<word-we-are-keeping-count-of>] => [<number-of-times-word-found].
     */
    public HashMap getWords(){
        //this is the delimiter between words.  
        //i.e. space, tab which is \t, new line is \n, then commas and periods.
        String delims = "[  \t  \n , .]+";
        //split function divides all the strings by the delimiter given 
        //into a string array.
        String[] tokens = textToAnalyze.split(delims);
        
        //the map is like an array where [<key is some string>] and the value is some integer
        //as show by the HashMap<String, Integer> initilalization 
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        
        //loop through each token that was gotten by using split function above.
        //this is just each word.
        for (int i = 0; i < tokens.length; i++){
            
            //using .containsKey, we check to see if the
            //hasmap contains a key by that string (or word)
            //...if it does, we want to update the count, which is the
            //value of that key in this case.
            if(hmap.containsKey(tokens[i])){
                int count = hmap.get(tokens[i]) + 1;
                hmap.replace(tokens[i],count);
            }
            else{//...if the hash map doesn't have that key (or word)
                //then we want to put that key into it with a token 
                //represented by the word. 
                hmap.put(tokens[i], 1);
            }
        }
        //once complete, return completed hashmap. 
        return sortWords(hmap);
    }
    
    private HashMap sortWords(HashMap map){
        List list = new LinkedList(map.entrySet());
       // Defined Custom Comparator here
       Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
               return ((Comparable) ((Map.Entry) (o1)).getValue())
                  .compareTo(((Map.Entry) (o2)).getValue());
            }
       });

       // Here I am copying the sorted list in HashMap
       // using LinkedHashMap to preserve the insertion order
       HashMap sortedHashMap = new LinkedHashMap();
       for (Iterator it = list.iterator(); it.hasNext();) {
              Map.Entry entry = (Map.Entry) it.next();
              sortedHashMap.put(entry.getKey(), entry.getValue());
       } 
       return sortedHashMap;
    }
    
    /**
     * prints the amount of times each letter
     * in the alphabet appears in the provided file text.
     */
    public void printLetterCounts(){
        for(int i = 0; i < aLetterCountList.length; i++){
             System.out.println(anAlphabet.getLetter(i)+" count: "+aLetterCountList[i]);
         }
    }
    
    /**
     * returns the array from 0 - 25 
     * representing each letter in the alphabet. 
     * 
     * @return integer array
     */
    public Integer[] getLetterCountList(){
        return aLetterCountList;
    }
    
    /**
     * initializes the count of letters from array keys 0 - 25
     * setting each value to 0.
     */
    private void initializeLetterCountList(){
        for(int i = 0; i < letterCountArraySize; i++){
            aLetterCountList[i] = 0;
        }
    }
    
    /**
     * counts the amount of times each letter 
     * exists in the given file text. 
     */
    private void countLetters(){
        for (int i = 0; i < textToAnalyze.length(); i++){
            Integer position = anAlphabet.getPositionOfLetter(textToAnalyze.charAt(i));
            if(position > -1){
                aLetterCountList[position] = aLetterCountList[position] + 1;
            }   
        }
    }
    
}
