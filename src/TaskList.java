public class TaskList {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }
    private Node head;

    public TaskList() {
        this.head = null;
    }
    public void addTask(String description) {
        Task newTask = new Task(description);
        Node newNode = new Node(newTask);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void markTaskAsCompleted(String description) {
        Node current = head;
        while (current != null) {
            if (current.task.getDescription().equals(description)) {
                current.task.markAsCompleted();
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found: " + description);
    }

    public void displayTasks() {
        Node current = head;
        if (current == null) {
            System.out.println("No tasks available.");
        } else {
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }
    }
}

