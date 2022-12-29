package recursion;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * For a given string, return a boolean value if it is palindrome or not
 * https://practice.geeksforgeeks.org/problems/palindrome-string0817/1
 *
 * @author Ritam Das
 * @since 28/12/22
 **/
public class CheckPalindrome {

  private static boolean isPalindrome(String str, int startIndex, int endIndex) {
    if (startIndex >= endIndex) {
      return true;
    }
    if (str.charAt(startIndex) == str.charAt(endIndex)) {
      return isPalindrome(str, ++startIndex, --endIndex);
    } else {
      return false;
    }
  }

  @Test
  void isPalindromeTest() {
    String str1 = "abcba";
    String str2 = "madam";
    String str3 = "b";
    String str4 = "tanzeel";
    assertAll(
        () -> assertTrue(isPalindrome(str1, 0, str1.length() - 1)),
        () -> assertTrue(isPalindrome(str2, 0, str2.length() - 1)),
        () -> assertTrue(isPalindrome(str3, 0, str3.length() - 1)),
        () -> assertFalse(isPalindrome(str4, 0, str4.length() - 1))
    );
  }
}
