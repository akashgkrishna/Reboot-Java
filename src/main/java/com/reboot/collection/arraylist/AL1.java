package com.reboot.collection.arraylist;

import java.util.*;

public class AL1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 5, 20, 8, 20, 15));
        Collections.sort(list);

        Set<Integer> set = new LinkedHashSet<>(list);

        list.clear();
        list.addAll(set);

        System.out.println(list.get(list.size() - 2));

    }
}
