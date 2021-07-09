package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/* Problem: Find the missing number from an Array; Given an array of size N-1, it can contain positive non repeating numbers from 1 to N. Find the number missing in the array.
 * URL: https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
 * Data Structure Used: Summation of number from 1 to N
 * */
public class MissingNumberInArray {
    static int findMissingNumber(int[] arr, int possibleNumbers){
        int sumFrom1ToPossibleNumbers = (possibleNumbers*(possibleNumbers+1))/2, sum =0;
        for(int elem: arr)
            sum+=elem;

        return sumFrom1ToPossibleNumbers-sum;
    }

    @Test
    void missingNumbersInArrayTest(){
        int[] arr1 = {1,2,3,5};
        int[] arr2 = {1,2,3,4,5,6,7,8,10};
        assertAll(
                () -> assertEquals(4, findMissingNumber(arr1, arr1.length+1)),
                () -> assertEquals(9, findMissingNumber(arr2, arr2.length+1))
        );
    }
}
