public class User {
    private String name;       // The user's name
    private TaskList taskList; // The user's to-do list, represented as a linked list of tasks

    // Constructor initializes the user's name and an empty TaskList for their to-do list
    public User(String name) {
        this.name = name;
        this.taskList = new TaskList(); // Each user has their own TaskList
    }

    // Method to add a task to the user's to-do list
    public void addTask(String taskDescription) {
        taskList.addTask(taskDescription); // Calls TaskList's addTask method
        System.out.println("Task added to " + name + "'s to-do list: " + taskDescription);
    }

    // Method to mark a task as completed in the user's to-do list
    public void markTaskAsCompleted(String taskDescription) {
        taskList.markTaskAsCompleted(taskDescription); // Calls TaskList's markTaskAsCompleted method
    }

    // Method to display all tasks in the user's to-do list
    public void displayTasks() {
        System.out.println("Tasks for " + name + ":");
        taskList.displayTasks(); // Calls TaskList's displayTasks method to print all tasks
    }

    // Getter for the user's name, if needed elsewhere
    public String getName() {
        return name;
    }
}
