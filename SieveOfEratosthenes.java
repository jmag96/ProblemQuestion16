import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        final int LIMIT = 1000;
        boolean[] isPrime = new boolean[LIMIT];

        // Step a: Initialize all elements to true
        for (int i = 2; i < LIMIT; i++) {
            isPrime[i] = true;
        }

        // Step b: Sieve algorithm
        for (int i = 2; i * i < LIMIT; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Write to file
        int count = 0;
        try (PrintWriter writer = new PrintWriter("primes.txt")) {
            for (int i = 2; i < LIMIT; i++) {
                if (isPrime[i]) {
                    writer.println(i + " is prime.");
                    count++;
                }
            }

            writer.println(); // empty line
            writer.println(count + " primes found.");

            System.out.println("Primes written to primes.txt");

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
