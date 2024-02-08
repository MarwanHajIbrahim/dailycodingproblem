package dailycodingproblem;

import java.util.Arrays;
import java.util.Scanner;


public class One {

    public static void main(String[] args) {

        int[] numbers = {5,6,7,10,9};
        Scanner scanner = new Scanner(System.in);
        int toAdd = scanner.nextInt();
        scanner.close();

        System.out.println(twoNumbers(numbers, toAdd));

    }

    private static boolean twoNumbers(int[] numbers, int toAdd) {

        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length-1;

        while(left < right){
            int num = numbers[left]+numbers[right];
            if(num==toAdd)
                return true;
            else{
                if (num < toAdd)
                    left++;
                else
                    right--;
            }
        }
        return false;
    }
}
