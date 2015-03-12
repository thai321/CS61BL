import java.util.*;

public class PrimeGenerator implements Iterator<Integer> {
	
	public static void main (String[] args) {
		// Make sure there is exactly one argument, an integer.
		// Store the argument, converted to an int, in n.
		int n = new Integer(args[0]);
		PrimeGenerator primeGen = new PrimeGenerator (n);
		int mostRecentPrime = 0;
		while (primeGen.hasNext()) {
			mostRecentPrime = primeGen.next();
		}
		System.out.println("The nth prime is: " + mostRecentPrime + " where n was: " + n);
	}
	
	private int begin = 1;
	private int times;
	private int prime;
	public PrimeGenerator (int n) {
		// Make sure n is positive; throw IllegalArgumentException if not.
		// Initialize the iterator of the first n prime numbers.
		if(n < 0) {
			throw new IllegalArgumentException("n has to be positive");
		}
		times = n;
	}
	
	// Return true if there are more primes to return.
	public boolean hasNext() {
		return begin <= times;
	}
	
	// Return the next prime number.
	public Integer next() {
		int count = 0;
		boolean found = false;
		if(begin == 1) {
			prime = 2;
			found = true;
		}
		while(!found) {
			prime++;
			if(isPrime(prime)) {
				found = true;
			}
		}

		begin++;
		return prime;
	}
	public boolean isPrime(int n) {
		if(n%2 == 0) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
	}
	// This is only here because the Iterator interface requires it.
	public void remove() {
	}

}
