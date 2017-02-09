/**
 * 
 */
package SubstitutionCipherDecryptionTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

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
         Scanner in         = new Scanner(System.in);
         System.out.print("Enter file path: ");
         filePath           = in.nextLine();
         String fileData    = getFileTextAsString(filePath);
         System.out.println(fileData);
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
    
}
