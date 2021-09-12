/*
-- Is Unique --

Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?
*/

public class IsUnique {

    /*
     * This solution uses a hash table to determine whether our string has unique
     * characters. We iterate through our string and determine whether we have
     * already seen the character in the string or not. If we did see the character,
     * we return false because that's a duplicate. If we have not, we NOW see it, so
     * mark our hash table spot as true.
     * 
     * Time Complexity: O(N) where N is the length of our string.
     * 
     * Space Complexity: O(1) because there is a fixed amount of characters at any
     * time and this does not depend on the length of the string.
     */

    public static boolean isUnique(String str) {
        // If we have more characters in our string than there are available, at least
        // one is not unique.
        if (str.length() > 128)
            return false;

        // We create a hash table that keeps track of characters seen.
        // True means the character is in the set.
        boolean[] charSet = new boolean[128];

        // Iterate through our string.
        for (char c : str.toCharArray()) {
            if (charSet[c]) { // If our character has already been seen (is true).
                return false; // Return false.
            }
            // This means we have not seen the character in our string.
            charSet[c] = true; // Set that position to true because NOW we see it.
        }

        // Return true if we make it to the end with no duplicates found.
        return true;
    }

    public static void main(String[] args) {
        String sampleOne = "alphabet";
        String sampleTwo = "extra";
        System.out.println(sampleOne + " is unique: " + isUnique(sampleOne));
        System.out.println(sampleTwo + " is unique: " + isUnique(sampleTwo));
    }
}