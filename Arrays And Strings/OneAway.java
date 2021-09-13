/*
-- One Away --

There are three types of edits that can be performed on strings: insert a character, remove
a character, or replace a character. Given two strings, write a function to check if they
are one edit (or zero edits) away.

EXAMPLE:
pale,   ple  ->  true
pales,  pale ->  true
pale,   bale ->  true
pale,   bae  ->  false
*/

public class OneAway {

    /*
     * We need to understand what it means to edit. We have an option of one edit to
     * make the strings equal. Possible edits are replacements, insertions, and
     * deletions. Insertions and deletions can be combined.
     * 
     * To determine which operation we do, we use the string lengths to determine
     * it. If the strings are of equal lengths, we can only perform a replacement
     * operation. We look to see if we require more than one or not.
     * 
     * If the strings are of different lengths, we can perform either an insertion
     * or removal.
     * 
     * Time Complexity: O(N) where N is the length of the smallest string length.
     * 
     * Space Complexity: O(1).
     */

    public static boolean oneAway(String first, String second) {
        // If the string lengths are equal, we look for replacement possibility.
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) { // If first string is longer by 1.
            // Look for remove or insert.
            return oneEditInsert(first, second);
        } else if (first.length() == second.length() + 1) { // If second string is longer by 1.
            // Look for remove or insert.
            return oneEditInsert(second, first);
        }
        // Return false if it fits in none of the categories above.
        return false;
    }

    // This is run when the lengths of the strings are equal.
    // If this happens, we look for just ONE value that we can replace.
    public static boolean oneEditReplace(String s1, String s2) {
        // First, we did not find a difference.
        boolean foundDifference = false;
        // Iterate through the length of the string.
        for (int i = 0; i < s1.length(); i++) {
            // If the two characters are not equal.
            if (s1.charAt(i) != s2.charAt(i)) {
                // Check again if this is the first difference encounter.
                if (foundDifference) { // If we already found a difference before.
                    return false; // Return false.
                }
                // If we have not found one, mark as found.
                foundDifference = true;
            }
        }
        // Return true if this is the only difference.
        return true;
    }

    // Function for insertion or removal.
    public static boolean oneEditInsert(String s1, String s2) {
        // Index of the two strings.
        int index1 = 0;
        int index2 = 0;
        // Iterate while our indices are within bounds.
        while (index2 < s2.length() && index1 < s1.length()) {
            // If the characters are not equal to each other.
            if (s1.charAt(index1) != s2.charAt(index2)) {
                // When the indices are not equal and the characters are not equal.
                // This means there are two update spots NOT one. Return false.
                if (index1 != index2) {
                    return false;
                }
                // If the indices are equal, we just increment the second index.
                // Increment second string index because this is the shorter string.
                index2++;
            } else { // If the characters are equal.
                // We increment both pointers forward.
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String sampleOne = "pale";
        String sampleTwo = "ple";
        System.out.println(oneAway(sampleOne, sampleTwo));
    }
}
