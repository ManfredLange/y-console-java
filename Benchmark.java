public class Benchmark {
    public float performBenchmark(Console console) {
        float consumption = 0.0f;
        for (Software software : console.getSoftwares()) {
            consumption = consumption + software.getConsumption();
        }
        float performanceValue = console.getPerformanceValue();
        return performanceValue / consumption * 100;
    }
}
