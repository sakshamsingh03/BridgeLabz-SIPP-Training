class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState current;
    private final int MAX_HISTORY = 10; // Limit history to last 10 states
    private int historySize = 0;

    // Add new text state at end (on new action/typing)
    public void addState(String content) {
        TextState newState = new TextState(content);

        // If current is not the tail, discard all redo states
        if (current != tail && current != null) {
            current.next = null;
            tail = current;
            historySize = calculateHistorySize();
        }

        if (head == null) {
            head = tail = current = newState;
            historySize = 1;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = newState;
            historySize++;

            // Maintain history limit
            if (historySize > MAX_HISTORY) {
                head = head.next;
                head.prev = null;
                historySize--;
            }
        }
    }

    // Undo (move to previous state)
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo (move to next state)
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display current state of the text
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text State: \"" + current.content + "\"");
        } else {
            System.out.println("Text editor is empty.");
        }
    }

    // Helper to recalculate history size after clearing redo history
    private int calculateHistorySize() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}