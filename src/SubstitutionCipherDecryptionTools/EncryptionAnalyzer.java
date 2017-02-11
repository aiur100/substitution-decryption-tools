/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubstitutionCipherDecryptionTools;

/**
 * 
 * @author theCaptain
 */
public class EncryptionAnalyzer {
    
    private final String              textToAnalyze;
    private final Integer[]           aLetterCountList;
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
        initializeLetterCountList();
        countLetters();
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
