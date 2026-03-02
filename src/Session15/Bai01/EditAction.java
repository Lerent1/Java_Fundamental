package Session15.Bai01;

public class EditAction {
    private String description;
    private String time;

    public EditAction(String description, String time) {
        this.description = description;
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return description + " | Time: " + time;
    }
}
