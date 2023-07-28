package activities;
interface BicycleParts
{
    public int gears = 0;
    public int speed = 0;
}
interface BicycleOperations
{
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations
{
    public int gears;
    public int speed;
    public Bicycle(int gear, int currentSpeed){
        this.gears = gear;
        this.speed = currentSpeed;
    }


    @Override
    public void applyBrake(int decrement) {
        speed -= decrement;
        System.out.println("Current speed: " + speed);
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Current speed: " + speed);
    }

    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nCurrent Speed of bicycle is " + speed);
    }
}

class MountainBike extends Bicycle
{
    //The MountainBike subclass adds one more field
    public int seatHeight;

    public MountainBike(int gears, int currentSpeed, int sHeight){
        super(gears, currentSpeed);
        seatHeight = sHeight;
    }

    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nCurrent Speed of bicycle is " + speed + "\nSeat height " + seatHeight);
    }
}

public class Activity7{

    public static void main(String args[]) {
        MountainBike mb = new MountainBike(3, 0, 25);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);
    }
}
