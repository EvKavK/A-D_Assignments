import java.util.ArrayList;
import java.util.List;

public class UndoRedoManager<T> {
    private final List<T> history = new ArrayList<>();
    private int currentIndex = -1;

    public void addState(T state) {
        // Remove all redoable states
        while (history.size() > currentIndex + 1) {
            history.remove(history.size() - 1);
        }

        history.add(state);
        currentIndex++;
    }

    public boolean undo() {
        if (currentIndex > 0) {
            currentIndex--;
            return true;
        }
        return false;
    }

    public boolean redo() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public T getCurrentState() {
        if (currentIndex >= 0 && currentIndex < history.size()) {
            return history.get(currentIndex);
        }
        return null;
    }
}