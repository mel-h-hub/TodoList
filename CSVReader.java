/*
CSVReader.java
Created by Mel
This class contains a method to read tasks from a CSV file and load them into an ArrayList of Tasks objects. 
The method takes the file name and the task list as parameters, reads the file line by line, and parses the completion status and task description for each task. 
It also includes error handling for file operations and prints out the number of tasks loaded from the file to double-check that all tasks were loaded correctly.
*/

package TodoList;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {
    public static String[][] loadTasksFromCSV(String fileName, ArrayList<Tasks> taskList) {
        List<String[]> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
    
                boolean completionStatus = Boolean.parseBoolean(row[0]); //swaps the String value to a boolean value for the completion status to be utilized correctly.
                String taskDescription = row[1];                         

                tasks.add(row);
                taskList.add(new Tasks(completionStatus, taskDescription));
}
        } catch (IOException e) {
            System.out.println("An error occurred while reading tasks: " + e.getMessage());
        }
        System.out.println("Tasks loaded from: " + fileName );
        System.out.println(tasks.size() + " tasks loaded.");
        return tasks.toArray(new String[0][]);
        
        }
    }
