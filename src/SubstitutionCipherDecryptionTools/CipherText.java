/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubstitutionCipherDecryptionTools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
                    i = enInput.length();
                }   
            }
            
            map.put(stringCh,(encryptedLetter.equalsIgnoreCase(stringCh) ? decryptedLetter : null )); 
            
            
        }
        
        return map;
    }
    
    public String patternConstructor(HashMap<String, String> map)
    {
        
        String key;        
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        String pattern = "";
        while(iterator.hasNext()) 
        {
           Map.Entry mentry = (Map.Entry)iterator.next();
           key = String.valueOf(mentry.getKey());
           
           if(mentry.getValue() != null)
               pattern +=  "(.*)" + key + "(.*)|(.*)" + key.toLowerCase() + "(.*)|";
           
        }
        pattern = pattern.substring(0,pattern.length()-1);
        
        
        
        return pattern;
    }
    
    public String textReplacement(String word, HashMap<String, String> map,String pattern)
    {
         
         String tmp = word;
         String stringToReturn = "";
         Set set = map.entrySet();
         Iterator iterator = set.iterator();
         String key, value;
         
         if(tmp.matches(pattern))
         {

            while(iterator.hasNext()) 
            {
               Map.Entry mentry = (Map.Entry)iterator.next();
               key = String.valueOf(mentry.getKey());
               value = String.valueOf(mentry.getValue());
               if(!(value.equals("null")))
               {
                   tmp = tmp.replaceAll("(?i)" + key, value);
               }
            } 
            stringToReturn = (tmp + " ");
         }  
            
      
           return stringToReturn;
    }
    
    
}
