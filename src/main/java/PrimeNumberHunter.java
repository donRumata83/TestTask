import org.apache.commons.math3.primes.Primes;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumberHunter {
    private static final long MAX_VALUE = 99999;
    private static final long MIN_VALUE = 10000;
    private long maxPalindrome = 0;
    private long firstMultiplier = 0;
    private long secondMultiplier = 0;
    private List<Long> primes;

    public static void main(String[] args) {
        new PrimeNumberHunter().run();
    }

    private void run() {
        primes = getAllPrimes(MIN_VALUE, MAX_VALUE);
        long temp;
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i; j < primes.size(); j++) {
                temp = primes.get(i) * primes.get(j);
                if (isNumberPalindrome(temp) && maxPalindrome < temp) {
                    maxPalindrome = temp;
                    firstMultiplier = primes.get(i);
                    secondMultiplier = primes.get(j);
                    break;
                }
            }
        }
        System.out.println(firstMultiplier + " * " + secondMultiplier + " = " + maxPalindrome);
    }

    private List<Long> getAllPrimes(long from, long to) {
        List<Long> result = new ArrayList<>();
        for (long i = to; i > from; i -= 2) {
            if (isNumberPrime(i)) result.add(i);
        }
        return result;
    }

    private boolean isNumberPalindrome(long number) {
        String numberInString = Long.toString(number);
        int length = numberInString.length();
        for (int i = 0; i < length /2; i++) {
            if (numberInString.charAt(i) != numberInString.charAt(length-1-i)) return false;
        }
        return true;
        //String rightOrder = Long.toString(number);
        //String reverseOrder = new StringBuilder(Long.toString(number)).reverse().toString();
        //return rightOrder.equals(reverseOrder);
    }

    private boolean isNumberPrime(long number) {
        return Primes.isPrime((int) number);
    }
}

