public class Main {
	public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Simulating typing and actions
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! How");
        editor.addState("Hello World! How are");
        editor.addState("Hello World! How are you?");
        editor.displayCurrentState();

        // Performing undo operations
        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        // Performing redo operations
        editor.redo();
        editor.displayCurrentState();

        // Adding new action (discarding redo history)
        editor.addState("Hello World! How are you doing?");
        editor.displayCurrentState();

        // Testing undo beyond available states
        for (int i = 0; i < 15; i++) {
            editor.undo();
        }
        editor.displayCurrentState();

        // Testing redo beyond available states
        for (int i = 0; i < 5; i++) {
            editor.redo();
        }
        editor.displayCurrentState();
    }
}