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
public class Alphabet {
    char[] alphabet;
    Integer  alphabetSize = 25;
    
    public Alphabet(){
        alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    }
    
    /**
     * pass in an integer, this returns the corresponding 
     * letter in the alphabet. 
     * 
     * @param letterPositionInAlphabet
     * @return 
     */
    public char getLetter(Integer letterPositionInAlphabet){
        return alphabet[letterPositionInAlphabet];
    }
    
    /**
     * returns the position in the alphabet from 
     * integer 0 = A .... 25 = Z
     * 
     * 
     * @param letter char - letter to check
     * @return integer position of letter in alphabet. 
     */
    public Integer getPositionOfLetter(char letter){
        return getPositionOfLetterAux(letter,0);
    }
    
    /**
     * tail recursive aux method for getPositionOfLetter
     * 
     * @param letter
     * @param position
     * @return 
     */
    private Integer getPositionOfLetterAux(char letter, Integer position){
        if(alphabet[position] == letter){
            return position;
        }
        else if(position < alphabetSize){
            position++;
            return getPositionOfLetterAux(letter,position);
        }
        else{
            return -1;
        }
    }
}
