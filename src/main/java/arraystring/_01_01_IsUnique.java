package arraystring;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 */

class _01_01_IsUnique {

    boolean isUnique(String str) {
        // if the charSet is Ascii only
        boolean[] flagCheck = new boolean[256];
        for (char c : str.toCharArray()) {
            if (flagCheck[c]) {
                return false;
            } else {
              flagCheck[c] = true;
            }
        }
        return true;
    }

}
