package App;

public class Task {
    private boolean isCompleted;
    private String name;

    public Task(boolean isCompleted, String name) {
        this.isCompleted = isCompleted;
        this.name = name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
