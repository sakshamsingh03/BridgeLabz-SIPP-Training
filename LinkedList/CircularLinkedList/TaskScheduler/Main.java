
public class Main {
	public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding sample tasks
        scheduler.addAtEnd(1, "Task A", 2, "2025-07-10");
        scheduler.addAtBeginning(2, "Task B", 1, "2025-07-05");
        scheduler.addAtEnd(3, "Task C", 3, "2025-07-15");
        scheduler.addAtPosition(2, 4, "Task D", 2, "2025-07-08");

        // Display all tasks
        scheduler.displayAllTasks();

        // View current task and move to next
        System.out.println("\nCycling through tasks:");
        scheduler.viewCurrentAndMoveNext();
        scheduler.viewCurrentAndMoveNext();
        scheduler.viewCurrentAndMoveNext();

        // Search by priority
        System.out.println("\nSearching for tasks with priority 2:");
        scheduler.searchByPriority(2);

        // Remove a task
        System.out.println("\nRemoving task with ID 4:");
        scheduler.removeByTaskId(4);
        scheduler.displayAllTasks();
    }
}