package recursion;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * SumOfDigits
 *
 * @author r0d05mv
 * @since 28/12/22
 **/
public class SumOfDigits {
  private static int addDigits(int number) {
    if (number <= 0) {
      return 0;
    }
    return (number % 10) + addDigits(number / 10);
  }

  @Test
  void sumOfDigitsTest() {
    int number1 = 123;
    int number2 = 555;
    int number3 = 3;
    int number4 = 0;
    assertAll(
        () -> assertEquals(6, addDigits(number1)),
        () -> assertEquals(15, addDigits(number2)),
        () -> assertEquals(3, addDigits(number3)),
        () -> assertEquals(0, addDigits(number4))
    );
  }
}
