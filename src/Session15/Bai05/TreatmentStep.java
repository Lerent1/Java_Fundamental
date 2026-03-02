package Session15.Bai05;

public class TreatmentStep {
    private String description;
    private String time;

    public TreatmentStep(String description, String time) {
        this.description = description;
        this.time = time;
    }

    @Override
    public String toString() {
        return time + " - " + description;
    }
}
