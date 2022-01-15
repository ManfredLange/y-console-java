public class CheatBenchmark extends Benchmark
{
    public float performBenchmark(Console console)
    {
        float benchmarkValue = super.performBenchmark(console);
        String producerName = console.getProducer().getName();
        
        if(producerName == "Ninwando")
        {
            benchmarkValue = benchmarkValue * 1.3f;
        }

        return benchmarkValue;
    }
}
