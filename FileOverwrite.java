/*
FileOverwrite.java
Created by Mel
This class contains a method to confirm whether or not the user wants to overwrite an existing file. 
Links to the main class when the user selects the option to "save tasks to a CSV file." 
The method checks if a file with the specified name already exists, and if it does, it prompts the user to confirm whether they want to overwrite the file. 
The method returns true if the user confirms that they want to overwrite the file, and false if they do not.
*/
package TodoList;
import java.io.File;
import java.util.Scanner;

public class FileOverwrite {
    public static boolean confirmOverwrite(String fileName, Scanner scanner) {
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("File '" + fileName + "' already exists. Do you want to overwrite it? (y/n)");   
            String response = scanner.nextLine().toLowerCase();
            return response.equals("y");
        }
        return true; // No file exists, so it's safe to save.
    }
}
