package Week7b.Taylorial;

import Week7b.SJLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Tests for the Week7b.Taylorial.Palindrome class.
 */
public class PalindromeTest {


    /**
     * Tests the isPalindrome method with a string that is a palindrome.
     */
    @Test
    public void testIsPalindromeWithPalindrome() {
        String test = "racecar";
        assertTrue(Palindrome.isPalindrome(test));
    }

    /**
     * Tests the isPalindrome method with a string that is not a palindrome.
     */
    @Test
    public void testIsPalindromeWithNonPalindrome() {
        String test = "notapalindrome";
        assertFalse(Palindrome.isPalindrome(test));
    }

    /**
     * Tests the isPalindrome method with an empty string.
     */
    @Test
    public void testIsPalindromeWithEmptyString() {
        String test = "";
        assertTrue(Palindrome.isPalindrome(test));
    }

    /**
     * Tests the isPalindrome method with a string that is a palindrome with multiple characters.
     */
    @Test
    public void testIsPalindromeMultipleCharacters() {
        String test = "Able was I ere I saw Elba";
        assertTrue(Palindrome.isPalindrome(test));
    }

    /**
     * Tests the isPalindrome method with a string that is a palindrome with different cases.
     */
    @Test
    public void testIsPalindromeWithDifferentCases() {
        String test = "AbleWasIereISawElba";
        assertFalse(Palindrome.isPalindrome(test));
    }

    /**
     * Tests the isPalindrome method with an even-length string.
     */
    @Test
    public void testIsPalindromeWithEvenLength() {
        String test = "abba";
        assertTrue(Palindrome.isPalindrome(test));
    }

    /**
     * Tests the isPalindrome method with an odd-length string.
     */
    @Test
    public void testIsPalindromeWithOddLength() {
        String test = "abcba";
        assertTrue(Palindrome.isPalindrome(test));
    }
    @Test
    public void multipleWordsSameCase() {
        assertTrue(Palindrome.isPalindrome("I saw I was I"));
    }
    @Test
    public void multipleWordsDifferentCase() {
        assertTrue(Palindrome.isPalindrome
                ("Able was I ere I saw Elba"));
    }

}