import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 16.5 FactorialZeros
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 */
class FactorialTrailingZeros {

    private Map<Integer, BigInteger> _nth_factorial = new HashMap<>();

    public BigInteger factorial(int n) throws IllegalArgumentException {
        if (n < 0) throw new IllegalArgumentException("Factorial of a negative number is undefined.");
        if (n < 2) return BigInteger.ONE;
        if (_nth_factorial.containsKey(n)) {
            return _nth_factorial.get(n);
        }
        _nth_factorial.put(n, factorial(n-1).multiply(BigInteger.valueOf(n)));
        return _nth_factorial.get(n);


    }

    public int countTrailingZerosInFactorial(int n) {
        BigInteger f = factorial(n);
        int zero_count = 0;
        while (f.compareTo(BigInteger.ZERO) == 1) {
            if (f.mod(BigInteger.TEN) == BigInteger.ZERO) {
                zero_count++;
                f = f.divide(BigInteger.TEN);
            } else {
                break;
            }
        }
        return zero_count;
    }


    // this is the trick to it.
    public int coolSolution(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }


    public static void main(String[] args) {
        FactorialTrailingZeros sut = new FactorialTrailingZeros();

        for (int i = 10; i < 1000; i = i + 10) {
            System.out.println(sut.factorial(i));
            System.out.println(sut.coolSolution(i));
            System.out.println(sut.countTrailingZerosInFactorial(i));
        }

    }

}

