package array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * MinimumRoundsToCompleteTasks: given a 0-indexed integer array tasks, where tasks[i] represents
 * the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same
 * difficulty level. Return the minimum rounds required to complete all the tasks,
 * or -1 if it is not possible to complete all the tasks.
 *
 * https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
 *
 * @author Ritam Das
 * @since 04/01/23
 **/
public class MinimumRoundsToCompleteTasks {
  private static int minimumRounds(int[] tasks) {
    Map<Integer, Integer> taskFrequencyMap = new HashMap<>();
    int rounds = 0;
    for (int task : tasks) {
      taskFrequencyMap.put(task, taskFrequencyMap.getOrDefault(task, 0) + 1);
    }
    for (int difficulty : taskFrequencyMap.keySet()) {
      int frequency = taskFrequencyMap.get(difficulty);
      if (frequency == 1) {
        return -1;
      }
      // make task each contains group of 3 to keep the rounds minimum.
      rounds += frequency / 3;

      // possible reminder task can be 1 or 2 post group division, in both the cases, will
      // require one extra round. If reminder is to, last 2 in a group will be counted as extra
      // task round, If reminder is 1, borrow 1 task from previous 3-grouped ask and make last 2
      // task of 2 each.
      if (frequency % 3 > 0) {
        rounds++;
      }
    }
    return rounds;
  }

  @Test
  void minRoundTest() {
    assertAll(
        () -> assertEquals(4, minimumRounds(new int[] {2, 2, 3, 3, 2, 4, 4, 4, 4, 4})),
        () -> assertEquals(-1, minimumRounds(new int[] {2, 3, 3})),
        () -> assertEquals(-1, minimumRounds(new int[] {2})),
        () -> assertEquals(3, minimumRounds(new int[] {2, 2, 3, 3, 3, 101, 101}))
    );
  }
}
