package array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

/* Problem: Given an unsorted array `arr` of size `length` that contains only positive integers, find a continuous sub-array with adds to a given number `sum`.
 * URL: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
 * Data Structure Concept Used: Sliding Window
 */
public class SubarrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int length, int sum){
        ArrayList<Integer> pointers = new ArrayList<>();
        int leftPointer=0, rightPointer=1, arraySum = arr[0]+arr[1];
        for(int i=0; i<length; i++){
            if(arraySum == sum){
                pointers.add(leftPointer+1);
                pointers.add(rightPointer+1);
                break;
            }
            else if(arraySum>sum){
                if(rightPointer-leftPointer>1) arraySum -= arr[leftPointer++];
                else {
                    arraySum -= arr[leftPointer++];
                    arraySum += arr[++rightPointer];
                }
            }
            else {
                arraySum += arr[++rightPointer];
            }
            if(rightPointer == length) break;
        }
        return pointers;
    }

    public static void main(String[] args){
        int[] arr3 = {1,4,20,3,10,5};
        System.out.println(subarraySum(arr3, arr3.length, 33));
    }

    @Test
    void subArraySumTest(){
        int[] arr1 = {1,2,3,7,5};
        int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
        int[] arr3 = {1,4,20,3,10,5};
        int[] arr4 = {1,4,0,0,3,10,5};
        int[] arr5 = {135,101,170,125,79,159,163,65,106,146,82,28,162,92,196,143,28,37,192,5,103,154,93,183,22,117,119,96,48,127,172,139,70,113,68,100,36,95,104,12,123,134};
        assertAll(
                () -> assertEquals(new ArrayList<>(Arrays.asList(2,4)), subarraySum(arr1, arr1.length, 12)),
                () -> assertEquals(new ArrayList<>(Arrays.asList(1,5)), subarraySum(arr2, arr2.length, 15)),
                () -> assertEquals(new ArrayList<>(Arrays.asList(3,5)), subarraySum(arr3, arr3.length, 33)),
                () -> assertEquals(new ArrayList<>(Arrays.asList(2,5)), subarraySum(arr4, arr4.length, 7)),
                () -> assertEquals(new ArrayList<>(Arrays.asList(38,42)), subarraySum(arr5, arr5.length, 468))
        );
    }

}