/* 
ClearScreen.java 
Created by Mel
This class contains a method to clear the console screen. It uses a simple approach to print new lines and then attempts to clear the screen using system-specific commands. 
The method also includes a pause before clearing the screen to allow the user to read any messages before the screen is cleared. 
*/
package TodoList;
import java.util.concurrent.TimeUnit;

public class clearScreen {                   
    public static void ClearScreen() {
        System.out.println();
        System.out.println("Clearing screen... 3... 2... 1...");
        try { 
            TimeUnit.SECONDS.sleep(3); // Pauses the program for 3 seconds to give the user time to read the message.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
            System.out.println("Error: Pause was interrupted. " + e.getMessage());
        }
        try{
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen: " + e.getMessage()); 
        }

    }

}
