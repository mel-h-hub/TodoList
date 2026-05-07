/* To Do List Main Class 
Author: Melisa Hiatt
Completion/Publish Date: 5/6/2026

A terminal-based to do list application. This is the main class for the program.
The supporting classes are Tasks.java, CSVReader.java, CSVWriter.java, FileOverwrite.java, and clearScreen.java. 

This program allows the user to:
 - create a to do list
 - view the list of tasks
 - mark tasks as completed
 - delete tasks
 - save the list to a CSV file
 - load a list from a CSV file

The program also includes error handling for invalid input and file operations. The user interface is designed to be simple and intuitive for terminal use.
This program has been tested and run successfully on a Windows 11 machine. The clearScreen method may not work as intended on all operating systems.
*/

package TodoList;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListMain { 
    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args){
        
        ArrayList<Tasks> taskList = new ArrayList<>();
        int option;

        do {                                            // Main menu UI 
            System.out.println("==========================================");
            System.out.println("       Welcome to Mel's To Do List!");
            System.out.println("==========================================");   
            System.out.println("");
            System.out.println("[------------ To Do List Menu ------------]");
            System.out.println("1. Add a task               2. View current tasks");
            System.out.println("3. Mark a task completed    4. Create new to do list");
            System.out.println("5. Delete a task            6. Save tasks to CSV file");
            System.out.println("7. Load from CSV file       8. Exit program");
            System.out.println(""); 
            System.out.println("Enter your option:");

                                                        
           if (!userInput.hasNextInt()) {              // If statement to keep program from closing when an invalid option is entered.
                System.out.println("Invalid choice! Please try again... :)");
                option = -1;                            
            } else {
                option = userInput.nextInt();
                userInput.nextLine();
            }

            switch (option) {
                case 0:                                 // Easter egg :D Does nothing, just a fun little surprise for anyone who finds it.
                    System.out.println("You found the secret option! Congratulations! :)");
                    break;
                case 1:                                 // Add to the end of the array.
                    System.out.println("Enter task description: ");
                    String taskEntry = userInput.nextLine();
                    taskList.add(new Tasks(false, taskEntry));
                    System.out.println("Task added!");
                    break;
                case 2:                                // View the entire list of tasks.
                    System.out.println("Your task list:");
                    if (taskList.isEmpty()) {
                        System.out.println("Please add a new task.");
                    } else {
                        for(int i = 0; i < taskList.size(); i++){
                            Tasks task = taskList.get(i);
                            System.out.println((i+1) + ". [" + (task.getCompletionStatus() ? "X" : " ") + "] " + task.getTaskDescription());
                        }
                    }
                    break;
                case 3:                              // Mark a task completed.
                    System.out.println("Which task?");
                    int taskSelection = userInput.nextInt();
                    if (taskList.isEmpty()) {
                        System.out.println("Task list is empty! Please add a new task.");
                    } else if (taskSelection < 1 || taskSelection > (taskList.size()+1)) {
                        System.out.println("Invalid task number! Please try again.");
                    } else {
                        taskList.get(taskSelection - 1).setCompletionStatus(true);
                        System.out.println("Task marked as completed!");
                    }
                    break;
                case 4:                             //"creates" a new list by clearing the current data. 
                    System.out.println("Are you sure? (y/n)");
                    String confirmation = userInput.nextLine();
                    if (confirmation.equalsIgnoreCase("y")) {
                        taskList.clear();
                        System.out.println("New to do list created!");
                    } else {
                        System.out.println("Operation cancelled.");
                    }
                    break;
                case 5:                             // Delete selected task.
                    System.out.println("Which task?");
                    int taskDeleteSelection = userInput.nextInt();
                    if (taskList.isEmpty()) {
                        System.out.println("Task list is empty! Please add a new task.");
                    } else if (taskDeleteSelection < 1 || taskDeleteSelection > taskList.size()) {
                        System.out.println("Invalid task number! Please try again.");
                    } else {
                        taskList.remove(taskDeleteSelection - 1);
                        System.out.println("Task deleted!");
                    }
                    break;

                case 6:                             // Save tasks to CSV file.
                    System.out.println("Enter file name to save to (e.g., tasks.csv):");
                    if (taskList.isEmpty()) {
                        System.out.println("Task list is empty! Please add a new task.");
                        break;
                    }
                    if (!userInput.hasNextLine()) {
                        System.out.println("Invalid file name! Please try again.");
                        break;
                    }
                    String fileName = userInput.nextLine();
                    if (!FileOverwrite.confirmOverwrite(fileName, userInput)) {
                        System.out.println("Save cancelled. Returning to main menu.");
                        break;
                    }
                    CSVWriter.saveTasksToCSV(
                        taskList.stream()
                                .map(task -> new String[]{String.valueOf(task.getCompletionStatus()), task.getTaskDescription()})
                                .toArray(String[][]::new),
                        fileName);
                    break;
                    
                case 7:                             // Load tasks from CSV file.
                    System.out.println("Enter file name to load from (e.g., tasks.csv):");
                    String loadFileName = userInput.nextLine();
                    CSVReader.loadTasksFromCSV(loadFileName, taskList);
                    
                    break;
                case 8:                             //Exit program :D
                    System.out.println("Goodbye! Thank you for using Mel's To Do List!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again... :)");
                    break;
            }
               clearScreen.ClearScreen();           // Clears the screen after each action for better readability.
            
        } while (option != 8);                      // Loop continues until the user selects the exit option (8).
        userInput.close();
}
/* My To do list for this program....
[x] Utilize Scanner for terminal input
[x] Utilize ArrayList for input, editing, and reading.
[x] If text file "to do list.txt" does not exist, create new text file (ended up going with CSV format for better data management).
[x] If it does exist, overwrite information with new text file (created confirmation checkpoint before file overwrite).
[x] Optional function. ask user if want to create a backup of list.
[x] UI in terminal with options to select from.
[x] Exit call to end program.
[x] Create new todo list
[x] View list of to do list entries
[x] Mark entries as completed
[x] Options to delete entries in arraylist
[x] Upload to GitHub. */
}
