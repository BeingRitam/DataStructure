package array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/* Minimum Platform Counter
* Description: Given arrival and departure times of all the trains on a station, calculate the minimum number of
* platforms required to serve all the trains without making any train waiting.
* URL: https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
* */
public class MinimumNumberOfPlatforms {
    static int minimumPlatformsCounter(int[] arr, int[] dep){
        int maxPlatformAtATime =1, currentUtilizedPlatform = 0, i=1, j=0;
        Arrays.sort(arr); Arrays.sort(dep);

        while(i<arr.length){
            if(arr[i] <= dep[j]){ //New Train arrived when previous one not yet departed
                currentUtilizedPlatform++;
                i++;
            }
            else {
                currentUtilizedPlatform = Math.max(0, --currentUtilizedPlatform);
                j++;
            }
            maxPlatformAtATime = Math.max(currentUtilizedPlatform, maxPlatformAtATime);
        }
        return maxPlatformAtATime;
    }

    @Test
    void minPlatformCounterTest(){
        int[] arr1 = {900, 940, 950, 1100, 1500, 1800};
        int[] dep1 = {910, 1200, 1120, 1130, 1900, 2000};
        int[] arr2 = {900, 940};
        int[] dep2 = {910,1200};

        assertAll(
            () -> assertEquals(3, minimumPlatformsCounter(arr1, dep1)),
            () -> assertEquals(1, minimumPlatformsCounter(arr2, dep2))
        );
    }
}
