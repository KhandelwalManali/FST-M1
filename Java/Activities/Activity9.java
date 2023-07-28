package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();

        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        myList.add("Four");
        myList.add("Five");

        System.out.println("Print All the names of the List: ");
        for(String name: myList)
        {
            System.out.println(name);
        }

        System.out.println("First Name in the List: "+myList.get(0));
        System.out.println("Check if Two exists: "+myList.contains("Two"));
        System.out.println("Third Name in the List: "+myList.get(2));
        System.out.println("Total size of the Array: "+ myList.size());
        myList.remove(4);
        System.out.println("New size of the Array: "+ myList.size());


    }

}
