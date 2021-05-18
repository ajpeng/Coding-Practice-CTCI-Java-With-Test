package arraystring;

/**
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * <p>
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
class _01_05_OneAway {
    boolean isOneAway(String a, String b) {
        if (a == null && b == null) return true;
        if (a == null) return b.length() <= 1;
        if (b == null) return a.length() <= 1;
        if (Math.abs(a.length() - b.length()) > 1) return false;
        int[] flags = new int[256];

        for (int i = 0; i < a.length() ; i++) {
            flags[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length() ; i++) {
            flags[b.charAt(i)]--;
        }
        int diff = 0;
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] > 1 || flags[i] < -1) {
                return false;
            }
            if (flags[i] != 0) diff++;

        }
        return diff == 0 || diff == 1 || diff == 2 ;
    }
}
