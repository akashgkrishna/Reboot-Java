package com.reboot.collection.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Problem: Remove duplicates from an {@code ArrayList<Integer>} while preserving
 * the ORIGINAL order of first appearance.
 *
 * <pre>
 * Input:  [1, 2, 2, 3, 1, 4, 5, 3]
 * Output: [1, 2, 3, 4, 5]
 * </pre>
 *
 * <p>Why LinkedHashSet?</p>
 * <ul>
 *   <li>{@code Set} &rarr; removes duplicates automatically.</li>
 *   <li>{@code HashSet} &rarr; removes duplicates but does NOT preserve order.</li>
 *   <li>{@code LinkedHashSet} &rarr; removes duplicates AND preserves insertion order.</li>
 * </ul>
 *
 * <p>
 * Time Complexity : O(n) &rarr; single pass to build the set + single pass to build the list<br>
 * Space Complexity: O(n) &rarr; extra set + new list
 * </p>
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 4, 5, 3));
        System.out.println("List after removing duplicates: " + removeDuplicates(list));
    }

    /**
     * Removes duplicates while preserving insertion order.
     *
     * <p><b>Steps:</b></p>
     * <ol>
     *   <li>Pass {@code list} into a {@code LinkedHashSet}.
     *     <ul>
     *       <li>Duplicates are dropped automatically.</li>
     *       <li>Because it's a {@code LinkedHashSet}, first-seen order is kept.</li>
     *     </ul>
     *   </li>
     *   <li>Convert the set back into an {@code ArrayList} and return it.</li>
     * </ol>
     *
     * <p><b>Interview tip:</b></p>
     * <ul>
     *   <li>Don't use {@code HashSet} here &mdash; it would lose the order.</li>
     *   <li>Don't use {@code Collections.sort} + {@code Set} &mdash; that would change the order too.</li>
     * </ul>
     *
     * @param list the input list which may contain duplicates (not modified)
     * @return a new {@code ArrayList} with duplicates removed, original order preserved
     */
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }
}
