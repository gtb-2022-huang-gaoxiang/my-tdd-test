package App;

public class Task {
    private boolean isCompleted;
    private String name;

    public Task(boolean isCompleted, String name) {
        this.isCompleted = isCompleted;
        this.name = name;
    }

    public Task(String name) {
        this.isCompleted = false;
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

    @Override
    public String toString() {
        String result;
        if (isCompleted) {
            result = "* ";
        } else {
            result = "+ ";
        }

        return result + name;
    }
}
