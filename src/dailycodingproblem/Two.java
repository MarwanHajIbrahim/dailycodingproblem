package dailycodingproblem;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers, return a new array such that each element at index i of the new array is
the product of all the numbers in the original array except the one at i.
For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
If our input was [3, 2, 1], the expected output would be [2, 3, 6].
Follow-up: what if you can't use division?
 */

public class Two {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};

        int[] multiplicationWithoutIndex = multipicate(numbers);

        for (int i=0;i<multiplicationWithoutIndex.length;i++)
            System.out.print(multiplicationWithoutIndex[i]+" ");
    }

    private static int[] multipicate(int[] numbers) {

        int[] returnArray = new int[numbers.length];
        Set<Integer> copy = new HashSet<Integer>();
        for (int num : numbers)
            copy.add(num);

        for (int i=0;i<numbers.length;i++) {
            copy.remove(numbers[i]);
            int count = 0;
            int num = 0;
            for (int number : copy)
                if (count++ == 0)
                    num = number;
                else
                    num *= number;
            returnArray[i]=num;
            copy.add(numbers[i]);
        }
        return returnArray;
    }

}
