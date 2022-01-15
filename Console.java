public abstract class Console {
    private String name;
    private int versionsNummer;
    private Software[] softwares;
    private ProcessingUnit processingUnit;
    private Producer producer;

    protected Console(String name, int versionsNummer,
            ProcessingUnit processingUnit, Software[] softwares,
            Producer producer) {
        this.name = name;
        this.versionsNummer = versionsNummer;
        this.processingUnit = processingUnit;
        this.softwares = softwares;
        this.producer = producer;
    }

    public Software[] getSoftwares() {
        return this.softwares;
    }

    public float getPerformanceValue() {
        return this.processingUnit.getPerformanceValue();
    }

    public Producer getProducer() {
        return this.producer;
    }

    public String getName() {
        return this.name;
    }

    public int getVersionsNummer() {
        return this.versionsNummer;
    }
}
