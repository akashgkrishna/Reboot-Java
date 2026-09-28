package com.reboot.imp.interview;

/**
 * Problem: Given an integer, return whether it is "Even" or "Odd".
 *
 * <pre>
 * Input:  8
 * Output: Even
 *
 * Input:  7
 * Output: Odd
 * </pre>
 *
 * <p><b>Approach:</b></p>
 * <ul>
 *   <li>Use the modulo operator {@code %} to find the remainder after dividing by 2.</li>
 *   <li>If remainder is 0 &rarr; the number is even.</li>
 *   <li>Otherwise &rarr; the number is odd.</li>
 * </ul>
 *
 * <p>
 * Time Complexity : O(1)<br>
 * Space Complexity: O(1)
 * </p>
 */
public class OddOrEven {

    public static void main(String[] args) {
        // Test the method and print the result
        System.out.println(checkOddOrEven(8));   // Even
        System.out.println(checkOddOrEven(7));   // Odd
        System.out.println(checkOddOrEven(0));   // Even
        System.out.println(checkOddOrEven(-3));  // Odd
    }

    /**
     * Returns "Even" if {@code number} is even, otherwise "Odd".
     *
     * <p><b>How it works:</b></p>
     * <ul>
     *   <li>{@code number % 2} gives the remainder when divided by 2.</li>
     *   <li>Remainder {@code 0}  &rarr; number is exactly divisible by 2 &rarr; Even.</li>
     *   <li>Remainder {@code 1} or {@code -1} &rarr; number is not divisible by 2 &rarr; Odd.</li>
     * </ul>
     *
     * <p><b>Why ternary here?</b> It collapses a 5-line if/else into one
     * readable line. Perfect for tiny binary decisions like this one.</p>
     *
     * @param number the integer to check (can be positive, zero, or negative)
     * @return the string "Even" or "Odd"
     */
    public static String checkOddOrEven(int number) {
        // Ternary: condition ? valueIfTrue : valueIfFalse
        return (number % 2 == 0) ? "Even" : "Odd";
    }
}