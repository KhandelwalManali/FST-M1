package activities;

import java.util.*;

public class Activity10 {

    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();

        hs.add(11);
        hs.add(12);
        hs.add(13);
        hs.add(14);
        hs.add(15);
        hs.add(16);

        System.out.println("Original HashSet: " + hs);
        System.out.println("Size of the HashSet: " + hs.size());
        System.out.println("Removed Element: " + hs.remove(12));
        System.out.println("Size of the HashSet: " + hs.size());
        System.out.println("Removed Element which is not in Set: " + hs.remove(2));
        System.out.println("Size of the HashSet: " + hs.size());
        System.out.println("Check if 15 is present in the set: " + hs.contains(15));
        System.out.println("Print the HashSet: " + hs);

        List<Integer> arrlist = Arrays.asList(3, 4, 6, 1, 2, 8, 5, 5);
        System.out.println("List: " +arrlist);
        Set<Integer> numbers = new HashSet<>(arrlist);
        System.out.println("Set: " +numbers);
    }


}
