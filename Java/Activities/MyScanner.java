package activities;

import java.util.Scanner;

public class MyScanner {

    //public final class Scanner extends Object implements Iterator<String>

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter UserName: ");

        String userName = myScanner.nextLine();
        System.out.println("Username is: "+userName);
    }
}
