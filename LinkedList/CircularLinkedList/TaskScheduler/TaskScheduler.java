
class TaskScheduler {
    private Task head = null;
    private Task current = null;

    // Add task at beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            head = newTask;
            temp.next = head;
        }
    }

    // Add task at end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Add task at a specific position (1-based index)
    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        if (count < position - 1) {
            System.out.println("Position out of bounds.");
            return;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task temp = head, prev = null;
        boolean found = false;

        do {
            if (temp.taskId == taskId) {
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Task not found.");
            return;
        }

        // Removing the head node
        if (temp == head) {
            if (head.next == head) { // Only one node
                head = null;
            } else {
                Task last = head;
                while (last.next != head) {
                    last = last.next;
                }
                head = head.next;
                last.next = head;
            }
        } else {
            prev.next = temp.next;
        }

        System.out.println("Task with ID " + taskId + " removed successfully.");
    }

    // View current task and move to next task
    public void viewCurrentAndMoveNext() {
        if (current == null) {
            current = head;
        }
        if (current != null) {
            displayTask(current);
            current = current.next;
        } else {
            System.out.println("No tasks in the scheduler.");
        }
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        System.out.println("Tasks in Scheduler:");
        Task temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search tasks by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }

    // Helper method to display task details
    private void displayTask(Task task) {
        System.out.println("Task ID: " + task.taskId);
        System.out.println("Task Name: " + task.taskName);
        System.out.println("Priority: " + task.priority);
        System.out.println("Due Date: " + task.dueDate);
        System.out.println("----------------------------------");
    }
}