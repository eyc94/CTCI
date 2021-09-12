/*
Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?
*/

import java.util.*;

public class IsUnique {

    /*
     * This solution uses a Hash Set to determine whether our string has duplicate
     * characters. We iterate through our string and determine whether we have
     * already seen the character in the string or not. If we did see the character,
     * we return false because that's a duplicate. If we have not, we NOW see it, so
     * add this character to the Hash Set.
     * 
     * Time Complexity: O(N) where N is the length of our string.
     * 
     * Space Complexity: O(N) where N is the length of our string. If our string has
     * no duplicate characters, the Hash Set will have the same length as our
     * string.
     */

    public static boolean isUnique(String str) {
        // We create a Hash Set that keeps track of characters seen.
        HashSet<Character> seen = new HashSet<>();

        // Iterate through our character array.
        for (char c : str.toCharArray()) {
            if (seen.contains(c)) { // If we have seen the character before.
                return false; // Return false.
            } else { // If we have not seen the character.
                seen.add(c); // Add the character to the Hash Set.
            }
        }

        // Return true if we make it to the end with no duplicates found.
        return true;
    }

    public static void main(String[] args) {
        String sampleOne = "alphabet";
        String sampleTwo = "unique";
        System.out.println(sampleOne + " is unique: " + isUnique(sampleOne));
        System.out.println(sampleTwo + " is unique: " + isUnique(sampleTwo));
    }
}