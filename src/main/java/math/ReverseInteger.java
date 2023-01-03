package math;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * ReverseInteger: Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1],
 * then return 0.
 *
 * https://leetcode.com/problems/reverse-integer/
 *
 * @author Ritam Das
 * @since 02/01/23
 **/
public class ReverseInteger {
  private static int reverse(int x) {
    if (x >= -9 && x <= 9) {
      return x;
    }
    boolean isNegative = false;
    if (x < 0) {
      isNegative = true;
    }
    int reverseNum = 0;
    x = Math.abs(x);
    while (x > 0) {
      int lastDigit = x % 10;
      // 32 Bit overflow test
      if ((!isNegative && reverseNum > Integer.MAX_VALUE / 10) ||
          (isNegative && reverseNum * -1 < Integer.MIN_VALUE / 10)) {
        return 0;
      }

      reverseNum = reverseNum * 10 + lastDigit;
      x /= 10;
    }
    return isNegative ? reverseNum * -1 : reverseNum;
  }

  @Test
  void testWordPatternMatcher() {
    assertAll(
        () -> assertEquals(321, reverse(123)),
        () -> assertEquals(-321, reverse(-123)),
        () -> assertEquals(21, reverse(120)),
        () -> assertEquals(0, reverse(1534236469)),
        () -> assertEquals(-2143847412, reverse(-2147483412))
    );
  }
}
