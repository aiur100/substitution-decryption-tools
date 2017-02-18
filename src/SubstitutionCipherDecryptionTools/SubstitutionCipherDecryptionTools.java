/**
 * 
 */
package SubstitutionCipherDecryptionTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @authors Christopher Hill, Charles Haggerty... and others.
 */
public class SubstitutionCipherDecryptionTools {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String filePath;
        // TODO code application logic here
         Scanner in                     = new Scanner(System.in);
         System.out.print("Enter file path: ");
         filePath                       = in.nextLine();
         String fileData                = getFileTextAsString(filePath);
         EncryptionAnalyzer analyzer    = new EncryptionAnalyzer(fileData);
         CipherText cipher              = new CipherText(fileData);
        analyzer.printLetterCounts();
        HashMap<String, Integer> words = analyzer.getWords();
        //Display content using Iterator
        Set set = words.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
           Map.Entry mentry = (Map.Entry)iterator.next();
           System.out.print("Potentional Word:   "+ mentry.getKey() + " -- Word Count:   ");
           System.out.println(mentry.getValue());
        }
    }
    
    /**
     * this function returns a file's 
     * text as string.  This assumes the 
     * file path given is a for a file that is
     * a plaintext file. 
     * 
     * @param realFilePath
     * @return String text of file as a large string block
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static String getFileTextAsString(String realFilePath) throws FileNotFoundException, IOException{
        File file           = new File(realFilePath);
        FileInputStream fis = new FileInputStream(file);
        byte[] data         = new byte[(int) file.length()];
        fis.read(data);//read data in file
        fis.close();//close file
        String fileText     = new String(data, "UTF-8");
        return fileText;
    }
    
    /**
     * testing method. 
     */
    public static void testing(){
        
    }
    
}
