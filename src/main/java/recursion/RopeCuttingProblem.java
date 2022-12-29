package recursion;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * RopeCuttingProblem: You are given N ropes. A cut operation is performed on ropes such that all of
 * them are reduced by the length of the smallest rope. Display the number of ropes left after every
 * cut operation until the length of each rope is zero.
 * <p>
 * https://practice.geeksforgeeks.org/problems/rope-cutting3334/1
 *
 * @author Ritam Das
 * @since 28/12/22
 **/
public class RopeCuttingProblem {
  private static List<Integer> getRemainingRopes(List<Integer> arr,
                                                 ArrayList<Integer> currentNumberOfRopes) {
    if (arr.size() == 0) {
      return currentNumberOfRopes;
    }
    int shortestRope = arr.remove(0);
    List<Integer> lengthPostCut = arr.stream()
        .map(length -> length -= shortestRope)
        .filter(length -> length > 0)
        .collect(Collectors.toList());
    if (lengthPostCut.size() > 0) {
      currentNumberOfRopes.add(lengthPostCut.size());
    }
    return getRemainingRopes(lengthPostCut, currentNumberOfRopes);
  }

  @Test
  void sumOfDigitsTest() {
    List<Integer> arr1 = new ArrayList<>(Arrays.asList(5, 1, 1, 2, 3, 5));
    List<Integer> arr2 = new ArrayList<>(Arrays.asList(5, 1, 6, 9, 8, 11, 2, 2, 6, 5));
    Collections.sort(arr1);
    Collections.sort(arr2);

    assertAll(
        () -> assertEquals(Arrays.asList(4, 3, 2), getRemainingRopes(arr1, new ArrayList<>())),
        () -> assertEquals(Arrays.asList(9, 7, 5, 3, 2, 1),
            getRemainingRopes(arr2, new ArrayList<>()))
    );
  }
}
