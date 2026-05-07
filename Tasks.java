/*
Tasks.java
Created by Mel
This class controls the Tasks objects that are stored in the ArrayList in the main class.
Each Tasks object has a completion status (boolean) and a task description (String).
*/
package TodoList;

public class Tasks {
    private boolean completionStatus;
    private String taskDescription;

    public Tasks(boolean completionStatus, String taskDescription) {
        this.completionStatus = completionStatus;
        this.taskDescription = taskDescription;
    }
    public boolean getCompletionStatus() {
        return completionStatus;
    }
    public String getTaskDescription() {
        return taskDescription;
    }
    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    //why me .-.
}
