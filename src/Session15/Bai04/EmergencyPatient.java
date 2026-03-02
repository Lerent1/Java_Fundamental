package Session15.Bai04;

public class EmergencyPatient {
    private String id;
    private String name;
    private int priority;

    public EmergencyPatient(String id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        String level = (priority == 1) ? "Cap cuu" : "Thong thuong";
        return id + " - " + name + " (" + level + ")";
    }
}