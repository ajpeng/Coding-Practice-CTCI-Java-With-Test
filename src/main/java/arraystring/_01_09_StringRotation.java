package arraystring;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, sl and s2, write code to check if s2 is a rotation of s1
 * using only one call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
 */
class _01_09_StringRotation {
    boolean rotated(String original, String result) {
        if (original.length() != result.length()) return false;
        if (original.length() == 0) return true;
        String kmp = original + original;
        if (kmp.contains(result)) {
            return true;
        }
        return false;
    }

    boolean rotatedBruteForced(String original, String result) {
        if (original.length() != result.length()){ return false; }
        if (result.length() == 0) return true;

        String comparator = original;
        for (int i = 0; i < original.length(); i++) {
            char c = comparator.charAt(0);
            comparator = comparator.substring(1) + c;
            if (comparator.equals(result)) return true;
        }
        return false;
    }
}
