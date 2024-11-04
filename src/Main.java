import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static User[] users = new User[10]; // Array to hold up to 10 users
    private static int userCount = 0;           // Tracks the number of users added

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Main program loop
        while (running) {
            System.out.println("\nTo-Do List Manager");
            System.out.println("1. Add User");
            System.out.println("2. Add Task to User");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Display User Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Handling user choice
                switch (choice) {
                    case 1 -> addUser(scanner);
                    case 2 -> addTaskToUser(scanner);
                    case 3 -> markTaskAsCompleted(scanner);
                    case 4 -> displayUserTasks(scanner);
                    case 5 -> running = false;
                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        scanner.close();
    }

    // Method to add a new user
    private static void addUser(Scanner scanner) {
        if (userCount >= users.length) {
            System.out.println("User limit reached.");
            return;
        }

        System.out.print("Enter user name: ");
        String name = scanner.nextLine();

        // Check if a user with this name already exists
        if (findUserByName(name) != null) {
            System.out.println("User already exists.");
            return;
        }

        // Add new user
        users[userCount++] = new User(name);
        System.out.println("User " + name + " added.");
    }

    // Method to add a task to a specific user
    private static void addTaskToUser(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        User user = findUserByName(name);

        // Check if the user exists
        if (user == null) {
            System.out.println("User not found. Please try adding the user first.");
            return;
        }

        System.out.print("Enter task description: ");
        String taskDescription = scanner.nextLine();
        user.addTask(taskDescription); // Add task to the user’s task list
    }

    // Method to mark a task as completed for a specific user
    private static void markTaskAsCompleted(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        User user = findUserByName(name);

        // Check if the user exists
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter task description to mark as completed: ");
        String taskDescription = scanner.nextLine();
        user.markTaskAsCompleted(taskDescription); // Mark the specified task as completed
    }

    // Method to display all tasks for a specific user
    private static void displayUserTasks(Scanner scanner) {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        User user = findUserByName(name);

        // Check if the user exists
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        user.displayTasks(); // Display all tasks for the user
    }

    // Helper method to find a user by name
    private static User findUserByName(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equalsIgnoreCase(name)) {
                return users[i];
            }
        }
        return null; // Return null if user is not found
    }
}

