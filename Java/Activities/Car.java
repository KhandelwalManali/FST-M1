package activities;

public class Car {

    // Class Variables
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;


    //Constructor
    Car(){
        tyres = 4;
        doors = 4;
    }

    //Class Methods
    public void displayCharacteristics(){
        System.out.println("Color - "+color);
        System.out.println("Transmission - "+transmission);
        System.out.println("Make - "+make);
        System.out.println("Tyres - "+tyres);
        System.out.println("Doors - "+doors);
    }
    public void accelarate() {
        System.out.println("Car is moving forward.");
    }
    public void brake()
    {
        System.out.println("Car has stopped.");
    }

}
