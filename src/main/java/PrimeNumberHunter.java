
import org.apache.commons.math3.primes.Primes;



public class PrimeNumberHunter {
    private final long MAX_VALUE = 9999;
    private final long MIN_VALUE = 1000;
    private long maxPolindrom = 0;
    private long firstMultiplier = 0;
    private long secondMultiplier = 0;

    public static void main(String[] args) {
        new PrimeNumberHunter().run();
    }

    private void run() {
        for (long i = MAX_VALUE; i > MIN_VALUE; i -= 2) {
            if (isNumberPrime(i)) {
                for (long j = i-2; j > MIN_VALUE; j -= 2) {
                    if (isNumberPrime(j) && isNumberPolindrome(i*j)) {
                        if (maxPolindrom < i*j) {
                            maxPolindrom = i*j;
                            firstMultiplier = i;
                            secondMultiplier = j;
                        }
                    }
                }
            }
        }
        System.out.println(firstMultiplier + " * "+ secondMultiplier + " = "+ maxPolindrom);

    }




    private boolean isNumberPolindrome(long number) {
        String rightOrder = Long.toString(number);
        String reverseOrder = new StringBuilder(Long.toString(number)).reverse().toString();
        return rightOrder.equals(reverseOrder);
    }

    private boolean isNumberPrime(long number) {
        return Primes.isPrime((int) number);

    }
}
