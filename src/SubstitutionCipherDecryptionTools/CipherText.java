/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubstitutionCipherDecryptionTools;

import java.util.HashMap;
/**
 *
 * @author Won
 */
public class CipherText {
    
    private final String textToAnalyze;
    
    public CipherText(String fileText)
    {
        textToAnalyze = fileText;
    }
    
    public HashMap matchLetters(String enInput,String deInput)
    {
        
        HashMap<String, String> map = new HashMap<>();
        
        String encryptedLetter = "";
        String decryptedLetter = "";
        String stringCh;
        for (char ch = 'A'; ch <= 'Z'; ++ch)
        {
            stringCh = String.valueOf(ch);
            for(int i = 0; i < enInput.length(); i++)
            {
                if(String.valueOf(enInput.charAt(i)).equalsIgnoreCase(stringCh))
                {
                    encryptedLetter = String.valueOf(enInput.charAt(i));
                    decryptedLetter = String.valueOf(deInput.charAt(i));
                    //i = enInput.length();
                }   
            }
            
            map.put(stringCh,(encryptedLetter.equalsIgnoreCase(stringCh) ? decryptedLetter : null )); 
            
            
        }
        
        return map;
    }
    
    public String textReplacement(String word, HashMap<String, String> map)
    {
         
         String tmp = word;
         String stringToReturn = "";
         
         for(int i = 0; i < tmp.length(); i++)
         {

            if(!(String.valueOf(map.get(String.valueOf(tmp.charAt(i)).toUpperCase())).equals("null")))
                stringToReturn += String.valueOf(map.get(String.valueOf(tmp.charAt(i)).toUpperCase()));
             
            else
                stringToReturn += String.valueOf(tmp.charAt(i));
         }
            
         
           
      
           return stringToReturn;
    }
    
    
}
