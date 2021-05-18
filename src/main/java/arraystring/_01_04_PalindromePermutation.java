package arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * <p>
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 */
class _01_04_PalindromePermutation {
    boolean check(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (c != ' ')  hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        boolean oddFlag = false;
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (oddFlag && entry.getValue() % 2 == 1) return false;
            if (entry.getValue() % 2 == 1)  oddFlag = true;
        }
        return true;
    }
}
