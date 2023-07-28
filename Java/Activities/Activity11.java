package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String[] args) {
        Map<Integer, String> colours = new HashMap<>();
        colours.put(1, "Blue");
        colours.put(2, "Orange");
        colours.put(3, "Black");
        colours.put(4, "Red");
        colours.put(5, "White");

        System.out.println(colours);

        System.out.println("Remove the one colour: "+ colours.remove(3));
        if (colours.containsValue("Green"))
        {
            System.out.println("Green Colour exists");
        }else {
            System.out.println("Green Colour does exists");
        }

        System.out.println("Size of the map " +colours.size());
    }

}
