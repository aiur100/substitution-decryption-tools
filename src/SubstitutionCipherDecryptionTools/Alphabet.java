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
    String[] alphabet;
    
    public Alphabet(){
        alphabet = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    }
    
    public String getLetter(Integer letterPositionInAlphabet){
        return alphabet[letterPositionInAlphabet];
    }
}
