public class Software {
    private String name;
    private float consumption;

    public Software(String name, float consumption) {
        this.name = name;
        this.consumption = consumption;
    }

    public float getConsumption() {
        return this.consumption;
    }

    public String getName() {
        return this.name;
    }
}
