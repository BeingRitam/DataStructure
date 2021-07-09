package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/* Problem: Find the maximum sub-array sum
* URL: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
* Data Structure Used: Kadane's Algorithm
* */
public class MaximumContiguousSubArraySum {
    static int maxSubArraySum(int a[], int size) {
        int maxSoFar =a[0], currentMax = a[0];

        for (int i = 1; i < size; i++) {
            currentMax = Math.max(a[i], currentMax+a[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }

    @Test
    void maximumSubArrayTest(){
        int[] arr1 = {-2,-3,4,-1,-2,1,5,-3};
        int[] arr2 = {1,2,3,-2,5};
        int[] arr3 = {-1,-2,-3,-4};
        assertAll(
                () -> assertEquals(7, maxSubArraySum(arr1, arr1.length)),
                () -> assertEquals(9, maxSubArraySum(arr2, arr2.length)),
                () -> assertEquals(-1, maxSubArraySum(arr3, arr3.length))
        );
    }

}
