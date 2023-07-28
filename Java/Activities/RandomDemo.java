package activities;

import java.util.Random;

public class RandomDemo{
    public static void main(String[] args) {
        Random randomno = new Random();
        System.out.println("Next int value: " + randomno.nextInt(5));
    }
}