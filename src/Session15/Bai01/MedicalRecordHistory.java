package Session15.Bai01;

import java.util.Stack;

public class MedicalRecordHistory {
    private Stack<EditAction> history = new Stack<>();

    public void addEdit(EditAction action) {
        history.push(action);
        System.out.println("Da them chinh sua: " + action);
    }

    public EditAction undoEdit() {
        if (history.isEmpty()) {
            System.out.println("Khong co thao tac de Undo!");
            return null;
        }
        EditAction removed = history.pop();
        System.out.println("Undo: " + removed);
        return removed;
    }

    public EditAction getLatestEdit() {
        if (history.isEmpty()) {
            System.out.println("Stack rong!");
            return null;
        }
        return history.peek();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("Khong co lich su chinh sua");
            return;
        }

        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
    }
}
