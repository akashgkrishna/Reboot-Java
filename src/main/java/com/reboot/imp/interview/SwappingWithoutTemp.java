package com.reboot.imp.interview;

/**
 * Demonstrates three ways to swap two integers WITHOUT using a temporary variable.
 *
 * <p><b>⚠️ Production Warning (applies to ALL methods in this class):</b></p>
 * <blockquote>
 *   These techniques are <b>interview tricks</b>, not production code.
 *   In real projects, ALWAYS use a temp variable:
 *   <pre>{@code
 *   int temp = a;
 *   a = b;
 *   b = temp;
 *   }</pre>
 *   It's readable, safe from overflow, and impossible to misread.
 * </blockquote>
 *
 * <p><b>Why do these tricks exist?</b> They're asked in interviews to test
 * whether you understand arithmetic, bitwise XOR, and Java's evaluation order.
 * Knowing them is good. Using them in real code is not.</p>
 */
public class SwappingWithoutTemp {

    public static void main(String[] args) {
        // Same input (10, 15) passed to each method to compare behaviour.
        swappingWithoutTemp(10, 15);
        swappingWithoutTempUsingXOR(10, 15);
        swappingWithoutTempSingleLine(10, 15);
    }

    /**
     * Swaps two numbers using pure ARITHMETIC (+, -).
     *
     * <p><b>How it works:</b></p>
     * <ol>
     *   <li>{@code a = a + b}  &rarr; a now holds the SUM of both values.</li>
     *   <li>{@code b = a - b}  &rarr; (sum) - (original b) = original a. b = old a.</li>
     *   <li>{@code a = a - b}  &rarr; (sum) - (new b = old a) = original b. a = old b.</li>
     * </ol>
     *
     * <p><b>⚠️ Warning:</b> If {@code a + b} exceeds {@link Integer#MAX_VALUE}
     * (2,147,483,647), the sum overflows and the swap produces WRONG results.
     * Example: a = 2_000_000_000, b = 2_000_000_000 → broken.</p>
     *
     * <p><b>🚫 Production advice:</b> I would never use this in production code
     * because of the overflow risk and reduced readability. Just use a temp variable.</p>
     *
     * <p>Time: O(1) &nbsp;|&nbsp; Space: O(1)</p>
     *
     * @param a first number
     * @param b second number
     */
    public static void swappingWithoutTemp(int a, int b) {
        System.out.println("Before a: " + a + ", b: " + b);

        a = a + b;   // a = sum of both numbers (risk: overflow)
        b = a - b;   // b = sum - original b = original a
        a = a - b;   // a = sum - new b (original a) = original b

        System.out.println("After a: " + a + ", b: " + b);
    }

    /**
     * Swaps two numbers using BITWISE XOR (^).
     *
     * <p><b>How it works (XOR identities):</b></p>
     * <ul>
     *   <li>{@code x ^ x = 0}</li>
     *   <li>{@code x ^ 0 = x}</li>
     *   <li>XOR is associative and self-inverse.</li>
     * </ul>
     *
     * <p><b>Trace</b> (a = 10 = 1010, b = 15 = 1111):</p>
     * <ol>
     *   <li>{@code a = a ^ b}  &rarr; a = 0101 (holds XOR of both)</li>
     *   <li>{@code b = a ^ b}  &rarr; b = 0101 ^ 1111 = 1010 (original a)</li>
     *   <li>{@code a = a ^ b}  &rarr; a = 0101 ^ 1010 = 1111 (original b)</li>
     * </ol>
     *
     * <p><b>✅ Advantage over arithmetic:</b> No overflow risk.</p>
     *
     * <p><b>⚠️ Gotcha:</b> Fails if {@code a} and {@code b} refer to the SAME
     * memory location (aliasing). Then {@code a ^ b} = 0 and both get wiped to 0.
     * Doesn't happen with primitives passed by value, but breaks with arrays/objects.</p>
     *
     * <p><b>🚫 Production advice:</b> I would never use this in production code
     * because it's harder to read and has hidden aliasing pitfalls. Use a temp variable.</p>
     *
     * <p>Time: O(1) &nbsp;|&nbsp; Space: O(1)</p>
     *
     * @param a first number
     * @param b second number
     */
    public static void swappingWithoutTempUsingXOR(int a, int b) {
        System.out.println("Before a: " + a + ", b: " + b);

        a = a ^ b;   // a = XOR of a and b
        b = a ^ b;   // b = (a^b)^b = a (original)
        a = a ^ b;   // a = (a^b)^a = b (original)

        System.out.println("After a: " + a + ", b: " + b);
    }

    /**
     * Swaps two numbers in a SINGLE LINE using arithmetic + inline assignment.
     *
     * <p><b>Expression:</b> {@code a = a + b - (b = a);}</p>
     *
     * <p><b>How Java evaluates it (left-to-right):</b></p>
     * <ol>
     *   <li>Read first {@code a}   &rarr; 10</li>
     *   <li>Read {@code b}         &rarr; 15</li>
     *   <li>Evaluate {@code (b = a)} &rarr; b becomes 10, expression returns 10</li>
     *   <li>Compute {@code 10 + 15 - 10 = 15}</li>
     *   <li>Assign result to {@code a} &rarr; a = 15</li>
     * </ol>
     * <p>Final: a = 15, b = 10 ✅</p>
     *
     * <p><b>⚠️ Why this is dangerous territory:</b></p>
     * <ul>
     *   <li>It relies on Java's guaranteed LEFT-TO-RIGHT evaluation order.</li>
     *   <li>In C and C++, this is UNDEFINED BEHAVIOR — the compiler may evaluate
     *       {@code (b = a)} first and produce garbage.</li>
     *   <li>Modifying {@code b} while also reading it in the same expression
     *       is a classic "sequence point" bug.</li>
     *   <li>Inherits the same integer-overflow risk as the arithmetic version.</li>
     * </ul>
     *
     * <p><b>🚫 Production advice:</b> I would NEVER use this in production code.
     * It's hard to read, relies on language-specific evaluation rules, and
     * invites bugs during maintenance. Just use a temp variable.</p>
     *
     * <p>Time: O(1) &nbsp;|&nbsp; Space: O(1)</p>
     *
     * @param a first number
     * @param b second number
     */
    public static void swappingWithoutTempSingleLine(int a, int b) {
        System.out.println("Before a: " + a + ", b: " + b);

        // 🔥 Clever but fragile: relies on Java's strict left-to-right evaluation.
        // Not portable to C/C++ (undefined behaviour there).
        a = a + b - (b = a);

        System.out.println("After a: " + a + ", b: " + b);
    }
}