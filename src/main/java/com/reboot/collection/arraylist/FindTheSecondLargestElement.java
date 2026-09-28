package com.reboot.collection.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Given an {@code ArrayList<Integer>}, find the second-largest
 * <i>distinct</i> element in a single pass.
 *
 * <pre>
 * Input:  [10, 5, 20, 8, 20, 15]
 * Output: 15
 * </pre>
 *
 * <p><b>Edge cases handled:</b></p>
 * <ul>
 *   <li>List with fewer than 2 distinct elements &rarr; returns {@code null}.</li>
 *   <li>Duplicate largest values (e.g. two 20s) &rarr; still returns the next distinct value.</li>
 *   <li>Empty list &rarr; returns {@code null}.</li>
 * </ul>
 *
 * <p>
 * Time Complexity : O(n) &rarr; single pass over the list<br>
 * Space Complexity: O(1) &rarr; only two variables used
 * </p>
 */
public class FindTheSecondLargestElement {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 5, 20, 8, 20, 15));
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 6, 8, 20, 6, 0, 9, 9));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(1));

        System.out.println("Second largest is: " + findTheSecondLargestElementFromArray(list));
        System.out.println("Second largest is: " + findTheSecondLargestElementFromArray(list1));
        System.out.println("Second largest is: " + findTheSecondLargestElementFromArray(list2));
    }

    /**
     * Finds the second-largest <b>distinct</b> element in the given list.
     *
     * <p><b>Algorithm (single pass):</b></p>
     * <ol>
     *   <li>Keep two trackers: {@code largest} and {@code secondLargest}, both initially {@code null}.</li>
     *   <li>For each {@code element} in the list:
     *     <ul>
     *       <li>If {@code element} is bigger than {@code largest}:
     *         <ul>
     *           <li>Demote old {@code largest} into {@code secondLargest}.</li>
     *           <li>Set {@code largest = element}.</li>
     *         </ul>
     *       </li>
     *       <li>Otherwise, if {@code element} is <b>not equal</b> to {@code largest}
     *           and is bigger than current {@code secondLargest}, update {@code secondLargest}.</li>
     *     </ul>
     *   </li>
     *   <li>Return {@code secondLargest} (may be {@code null} if it doesn't exist).</li>
     * </ol>
     *
     * <p><b>Why the {@code !largest.equals(element)} check matters:</b></p>
     * <ul>
     *   <li>Prevents duplicates of the largest value (e.g. two 20s) from
     *       being wrongly counted as the "second largest".</li>
     * </ul>
     *
     * <p><b>Interview tip:</b> Don't sort — sorting is O(n log n). A single
     * pass with two trackers is O(n) and requires no extra space.</p>
     *
     * @param list the input list (may contain duplicates; not modified)
     * @return the second-largest distinct value, or {@code null} if it doesn't exist
     */
    public static Integer findTheSecondLargestElementFromArray(ArrayList<Integer> list) {

        // Trackers: null means "not yet set".
        // Using Integer (not int) so we can represent "no value yet" safely.
        Integer largest = null, secondLargest = null;

        for (Integer element : list) {

            // Case 1: found a new largest value.
            if (largest == null || largest < element) {
                secondLargest = largest;   // old largest becomes second largest
                largest = element;         // update largest
            }
            // Case 2: element is smaller than largest.
            //  - Skip if it equals largest (avoid duplicates of max).
            //  - Update secondLargest only if it's bigger than the current one.
            else if (!largest.equals(element)
                    && (secondLargest == null || secondLargest < element)) {
                secondLargest = element;
            }
        }

        return secondLargest;
    }
}