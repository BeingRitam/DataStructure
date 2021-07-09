package array;

/* Rainwater Trapping: Given array of positive integers representing an elevation map, compute how much water it is able to trap after raining.
 *  URL: https://www.geeksforgeeks.org/trapping-rain-water/
 * */
public class RainwaterTrapping {
    public static int trap(final int[] A) {
        int[] maxLeftSoFar = new int[A.length];
        int[] maxRightSoFar = new int[A.length];
        int maxLeft = 0,maxRight = 0;
        for(int i=0;i<A.length;i++) {
            maxLeftSoFar[i] = maxLeft;
            maxLeft = Math.max(A[i], maxLeft);
        }
        for(int i=A.length-1;i>=0;i--) {
            maxRightSoFar[i] = maxRight;
            maxRight = Math.max(A[i], maxRight);
        }

        int sum = 0;
        for(int i=0;i<A.length;i++) {
            if(maxLeftSoFar[i] < A[i] || maxRightSoFar[i] < A[i])
                continue;
            int min = Math.min(maxLeftSoFar[i], maxRightSoFar[i]);
            int value = min - A[i];
            sum+=value;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(arr));
    }
}
