public class EvenNumbersGenerator {
    private static int MAX = 42;

    private int previous = 0;

    public int next() {
        previous += 2;
        previous %= MAX;
        return previous;
    }
}