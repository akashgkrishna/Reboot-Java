package com.reboot.imp.interview;

/**
 * Problem: Given an integer, determine whether it is a prime number.
 *
 * <pre>
 * Input:  1  &rarr; Not Prime
 * Input:  5  &rarr; Prime
 * Input:  0  &rarr; Not Prime
 * Input:  9  &rarr; Not Prime
 * </pre>
 *
 * <p><b>What is a prime number?</b></p>
 * <ul>
 *   <li>A number greater than 1 that has only two divisors: 1 and itself.</li>
 *   <li>1 is NOT prime. 0 and negative numbers are NOT prime.</li>
 *   <li>2 is the smallest (and only even) prime.</li>
 * </ul>
 *
 * <p>
 * Time Complexity : O(&radic;n) &rarr; loop runs up to {@code number / 2}<br>
 * Space Complexity: O(1)
 * </p>
 */
public class PrimeNumber {

    public static void main(String[] args) {
        // Quick sanity tests covering typical edge cases
        System.out.println(checkPrime(1));  // Not Prime
        System.out.println(checkPrime(5));  // Prime
        System.out.println(checkPrime(0));  // Not Prime
        System.out.println(checkPrime(9));  // Not Prime
        System.out.println(checkPrime(2));  // Prime (smallest prime)
        System.out.println(checkPrime(-7)); // Not Prime
    }

    /**
     * Returns "Prime" if {@code number} is prime, otherwise "Not Prime".
     *
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>If {@code number <= 1} &rarr; immediately return "Not Prime"
     *       (covers 0, 1, and all negatives).</li>
     *   <li>Loop {@code i} from 2 up to {@code number / 2}.
     *     <ul>
     *       <li>If {@code number % i == 0}, we found a divisor other than 1
     *           and itself &rarr; not prime, return early.</li>
     *     </ul>
     *   </li>
     *   <li>If no divisor was found, the number is prime.</li>
     * </ol>
     *
     * <p><b>Why early return?</b> The moment we find one divisor, we know the
     * answer. No need to keep scanning the rest of the range.</p>
     *
     * <p><b>Why start at 2?</b> Because every number is divisible by 1 —
     * checking 1 would mark every number as "not prime".</p>
     *
     * <p><b>Interview optimization:</b> Instead of {@code i <= number / 2},
     * use {@code i * i <= number}. Any composite number has a factor
     * &le; &radic;number, so this halves the loop range for large inputs.</p>
     *
     * @param number the integer to test (may be 0, negative, or positive)
     * @return "Prime" or "Not Prime"
     */
    public static String checkPrime(int number) {

        // Step 1: Reject 0, 1, and all negative numbers.
        if (number <= 1) return "Not Prime";

        // Step 2: Look for any divisor between 2 and number/2.
        for (int i = 2; i <= number / 2; i++) {  // (i * i <= number) slightly more efficient
            if (number % i == 0) return "Not Prime";   // found a divisor
        }

        // Step 3: No divisor found → it's prime.
        return "Prime";
    }
}