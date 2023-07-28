package activities;

public class Activity2 {

    public static void main(String[] args) {
        //Initialize the array
        int[] arrNum = {10, 77, 10, 54, -11, 10};


        int searchNum = 10;
        int totalSum = 30;

        //Print result
        System.out.println("Result: " + result(arrNum, searchNum, totalSum));
    }

public static boolean result(int[] num, int searchNum, int totalSum)
{
        int sum = 0;
        //Search  number 10 in the array
        for (int number: num) {
            if (number == searchNum) {
                //Add all 10's
                sum += number;
            }


            //sum should be exact 30
            if (sum == totalSum) {
                break;
            }
        }return sum==totalSum;
    }

}
