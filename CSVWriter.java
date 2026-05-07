/*
CSVWriter.java
Created by Mel
This class contains a method to save tasks to a CSV file. The method takes the task array and the file name as parameters, and writes each task to the file in CSV format.
*/

package TodoList;
import java.io.*;


public class CSVWriter {
    public static void saveTasksToCSV(String[][] tasks, String fileName) {
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            for (String[] task : tasks) {
                pw.println(task[0] + "," + task[1]);
            }
            System.out.println("Tasks successfully saved to " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while saving tasks: " + e.getMessage());
        }
    }
}
