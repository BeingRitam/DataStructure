package string;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * WordPatternMatching: Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern
 * and a non-empty word in s.
 * 1. each character in pattern represents a word in s
 * 2. No two distinct characters in pattern can represent the same word in s
 * 3. No single character in pattern can represent two distinct words in s.
 *
 * https://leetcode.com/problems/word-pattern/
 *
 * @author Ritam Das
 * @since 01/01/23
 **/
public class WordPatternMatching {
  private static boolean wordPattern(String pattern, String s) {

    String[] words = s.split("\\s+");
    Map<Character, String> charToWordsMap = new HashMap<>();
    if (words.length == pattern.length()) {
      for (int i = 0; i < pattern.length(); i++) {
        char currentPatternLetter = pattern.charAt(i);

        // Single character in pattern mapped to different words in string.
        if (charToWordsMap.containsKey(currentPatternLetter) &&
            !charToWordsMap.get(currentPatternLetter).equals(words[i])) {
          return false;
        } else {
          // Multiple characters in pattern is mapped to same word in string
          if (charToWordsMap.containsValue(words[i])) {
            return false;
          } else {
            charToWordsMap.put(currentPatternLetter, words[i]);
          }
        }
      }
      return true;
    }
    return false;
  }

  @Test
  void testWordPatternMatcher() {
    assertAll(
        () -> assertTrue(wordPattern("abab", "dog cat dog cat")),
        () -> assertTrue(wordPattern("abcb", "dog cat hat cat")),
        () -> assertFalse(wordPattern("abcb", "dog cat dog cat")),
        () -> assertFalse(wordPattern("abba", "dog cat cat fish")),
        () -> assertFalse(wordPattern("aaaa", "dog cat cat dog")),
        () -> assertTrue(wordPattern("abba", "dog cat cat dog"))
    );
  }
}
