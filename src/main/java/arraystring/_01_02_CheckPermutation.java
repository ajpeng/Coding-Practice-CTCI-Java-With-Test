package arraystring;

import java.util.HashMap;

/**
 * Given two strings,write a method to decide if one is a permutation of the other.
 */
class _01_02_CheckPermutation {
    boolean check(String a, String b) {

        int[] flags = new int[256];
        for (int i = 0; i < a.length(); i++) {
            flags[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length(); i++) {
            flags[b.charAt(i)]--;
        }
        for (int i : flags) {
            if (i != 0 ) return false;
        }

        return true;
    }
}
