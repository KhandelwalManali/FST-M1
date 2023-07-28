package activities;

public class Activity1 extends Car{


    public static void main(String[] args) {
        Car kiya = new Car();
        //Initialising Car class variables
        kiya.color  = "Grey";
        kiya.make = 2023;
        kiya.transmission = "Automatic";

        // Calling car class methods
        kiya.displayCharacteristics();
        kiya.accelarate();
        kiya.brake();
    }
}
