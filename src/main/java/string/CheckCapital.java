package string;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * CheckCapital: We define the usage of capitals in a word to be right when
 * one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 *
 * https://leetcode.com/problems/detect-capital/
 *
 * @author Ritam Das
 * @since 02/01/23
 **/
public class CheckCapital {
  private boolean detectCapitalUse(String word) {
    if (word.length() <= 1) {
      return true;
    }
    boolean areRestLowerCase = true, areRestUpperCase = true;
    boolean isFirstCharCapital = Character.isUpperCase(word.charAt(0));

    for (int i = 1; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (!Character.isUpperCase(currentChar)) {
        areRestUpperCase = false;
      } else {
        areRestLowerCase = false;
      }
    }
    return (isFirstCharCapital && (areRestLowerCase || areRestUpperCase)) ||
        (!isFirstCharCapital && areRestLowerCase);
  }

  @Test
  void testWordPatternMatcher() {
    assertAll(
        () -> assertTrue(detectCapitalUse("USA")),
        () -> assertTrue(detectCapitalUse("the")),
        () -> assertFalse(detectCapitalUse("FlaG")),
        () -> assertTrue(detectCapitalUse("Ritam"))
    );
  }
}
