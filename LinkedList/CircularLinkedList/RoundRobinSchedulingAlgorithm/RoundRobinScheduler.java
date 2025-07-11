
public class RoundRobinScheduler {
    private Process head = null;
    private Process current = null;

    // Add process at end
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    // Remove a process after execution by process ID
    public void removeProcess(int processId) {
        if (head == null) return;

        Process temp = head, prev = null;

        // Find the process to remove
        do {
            if (temp.processId == processId) break;
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (temp.processId != processId) return; // Process not found

        // Removing head node
        if (temp == head) {
            if (head.next == head) {
                head = null;
            } else {
                Process last = head;
                while (last.next != head) last = last.next;
                head = head.next;
                last.next = head;
            }
        } else {
            prev.next = temp.next;
        }
    }

    // Simulate round robin scheduling
    public void simulateScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalTime = 0;
        int totalProcesses = countProcesses();

        current = head;
        while (head != null) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(current.remainingTime, timeQuantum);
                System.out.println("Executing Process ID: " + current.processId + " for " + executionTime + " units");
                current.remainingTime -= executionTime;
                totalTime += executionTime;

                if (current.remainingTime == 0) {
                    current.turnAroundTime = totalTime;
                    current.waitingTime = current.turnAroundTime - current.burstTime;
                    System.out.println("Process ID " + current.processId + " completed.");
                    int completedProcessId = current.processId;
                    current = current.next;
                    removeProcess(completedProcessId);
                    if (head == null) break; // All processes done
                    continue;
                }
            }
            current = current.next;
            displayProcesses();
        }

        System.out.println("\nAll processes completed.");
        displayAverageTimes(totalProcesses);
    }

    // Display processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }
        System.out.println("\nCurrent Process Queue:");
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Remaining Time: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    // Count total number of processes
    private int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    // Calculate and display average waiting time and turn-around time
    private void displayAverageTimes(int totalProcesses) {
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        // Traverse completed processes
        Process temp = head;
        do {
            if (temp == null) break;
            totalWaitingTime += temp.waitingTime;
            totalTurnAroundTime += temp.turnAroundTime;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Average Waiting Time: " + (totalWaitingTime / (double) totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnAroundTime / (double) totalProcesses));
    }
}