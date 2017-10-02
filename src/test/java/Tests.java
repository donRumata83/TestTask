import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Tests {
    private PrimeNumberHunter hunter;
    @Before
    public void before(){
        hunter = new PrimeNumberHunter();
    }
    @Test
    public void IsPOlindromWorks() {
        PrimeNumberHunter hunter = new PrimeNumberHunter();

        Assert.assertTrue(hunter.isNumberPolindrome(1234554321));
        Assert.assertFalse(hunter.isNumberPolindrome(1234554322));
    }

    @Test
    public void isPrimeWorks(){
        Assert.assertTrue(hunter.isPrime(3));
        Assert.assertTrue(hunter.isPrime(7));
        Assert.assertTrue(hunter.isPrime(11));
    }
}
