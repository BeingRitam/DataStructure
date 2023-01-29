package array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

/**
 * MinimumNumberOfArrows: There are some balloons taped onto a flat wall that represents the XY-plane.
 * The balloons are represented as a 2D integer array points where points[i] = [X(start), X(end)]
 * denotes a balloon whose horizontal diameter stretches between X(start) and X(end).
 * You do not know the exact y-coordinates of the balloons.
 * Arrows can be shot up directly vertically (in the positive y-direction) from different points
 * along the x-axis. A balloon with X(start) and X(end) is burst by an arrow shot at x if
 * X(start) <= X <= X(end). There is no limit to the number of arrows that can be shot.
 * A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
 *
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
 *
 * @author Ritam Das
 * @since 05/01/23
 **/
public class MinimumNumberOfArrows {
  private static int findMinArrowShots(int[][] points) {
    // Sort the array based on X(start)
    Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
    int minArrows = 1, currRight = points[0][1]; // CurrRight points to X(end) of first balloon.
    for (int i = 1; i < points.length; i++) {
      // If balloon overlaps, narrow it down to te overlapping path by keeping the currEnd
      // as minimum of two balloons.
      if (points[i][0] <= currRight) {
        currRight = Math.min(currRight, points[i][1]);
      // In case no overlap, further overlaps needs to be checked from current balloon, since they
      // are sorted by X(start)
      } else {
        minArrows++;
        currRight = points[i][1];
      }
    }
    return minArrows;
  }

  @Test
  void testMinimumNumberOfArrows() {
    assertAll(
        () -> assertEquals(2, findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}})),
        () -> assertEquals(4, findMinArrowShots(new int[][] {{1, 2}, {3, 4}, {5, 6}, {7, 8}})),
        () -> assertEquals(2, findMinArrowShots(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}})),
        () -> assertEquals(1, findMinArrowShots(new int[][] {{1, 2}})),
        () -> assertEquals(1, findMinArrowShots(new int[][] {{2, 3}, {2, 3}})),
        () -> assertEquals(2,
            findMinArrowShots(new int[][] {{-2147483646, -2147483645}, {2147483646, 2147483647}}))
    );
  }
}
