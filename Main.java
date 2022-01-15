public class Main {
    public static void main(String[] args) {
        Producer insomny = new Producer("Insomny");
        Producer ninwando = new Producer("Ninwando");
        Software[] softwares = new Software[] {
                new Software("T1", 33.0f),
                new Software("T2", 50.0f),
                new Software("T3", 66.0f),
        };

        ProcessingUnit processingUnit1 = new ProcessingUnit(75.0f);
        LearnStation learnStation = new LearnStation(processingUnit1, softwares, insomny);

        ProcessingUnit processingUnit2 = new ProcessingUnit(66.0f);
        Studitch studitch = new Studitch(processingUnit2, softwares, ninwando);

        Benchmark benchmark = new Benchmark();

        BenchmarkFramework benchmarkFramework = new BenchmarkFramework();
        float studitchResult = benchmarkFramework.performBenchmark(studitch, benchmark);
        float learnStationResult = benchmarkFramework.performBenchmark(learnStation, benchmark);

        System.out.println("Studitch: " + studitchResult);
        System.out.println("LearnStation: " + learnStationResult);

        CheatBenchmark cheatBenchmark = new CheatBenchmark();
        float studitchResultFudged = benchmarkFramework.performBenchmark(studitch, cheatBenchmark);
        float learnStationResultFudged = benchmarkFramework.performBenchmark(learnStation, cheatBenchmark);

        System.out.println("Studitch (fudged): " + studitchResultFudged);
        System.out.println("LearnStation (fudged): " + learnStationResultFudged);
    }
}
