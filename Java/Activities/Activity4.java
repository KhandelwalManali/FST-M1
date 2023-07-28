package activities;

public class Activity4 {

    public static void main(String[] args) {
        int[] num = { 9, 5, 1, 4, 3 };
        int temp;

        for(int i =0; i<num.length; i++)
        {
            for(int j =i+1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    temp = num[i];
                    num[i] = num[j];
                    num[j] = temp; //{3, 4, 6, 2};
                }
            }
            System.out.println(num[i]);
        }

    }
}
