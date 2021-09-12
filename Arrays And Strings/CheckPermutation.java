/*
-- Check Permutation --

Given two strings, write a method to decide if one is a permutation of the other.
*/

public class CheckPermutation {

    /*
     * So we use a hash table to solve this problem. There is a different method.
     * 
     * We first check if the two strings are the same lengths. This is because the
     * permutations of a string will be the same lengths because they use the same
     * amount of characters to make it. If the strings are not of the same length,
     * return false off the bat.
     * 
     * We next create a hash table. Our hash table will hold 26 spots representing
     * the 26 alphabets. We use the characters' ASCII values and subtract by the
     * ASCII value of 'a' to get an index value from 0 to 25.
     * 
     * We iterate through one string and increment the value of the character's
     * spot. For example, if the character is 'c', it's ASCII value is 99. We
     * subtract that ASCII value by a's ASCII value (97) to get 2. Index 2 is the
     * third spot of the array, representing c's spot.
     * 
     * We iterate through the second string. This time, we decrement the frequency.
     * 
     * Our goal is to get an array (hash table) with frequencies of 0. Afterwards,
     * we iterate through our hash table and look for a non-zero value. If we find a
     * non-zero value, we return false immediately.
     * 
     * If we get to the end of that loop above, the two strings are palindromes. So,
     * return true.
     * 
     * Time Complexity: O(N) where N is the length of our two strings.
     * 
     * Space Complexity: O(1) because our hash table does NOT rely on the lengths of
     * our strings. It will always be of length 26.
     */

    public static boolean checkPermutation(String str1, String str2) {
        // Check the lengths of the strings.
        // Permutation of a string results in a string with the SAME length.
        if (str1.length() != str2.length()) {
            return false;
        }

        // Make a hash table to keep track of character frequency in the string.
        // 26 spots in the hash table because there are 26 alphabets.
        int[] charFreq = new int[26];

        // Loop through a string and use ASCII values to count frequency of characters.
        for (char c : str2.toCharArray()) {
            charFreq[c - 'a']++;
        }

        // Loop through the other string and decrement its frequency.
        for (char c : str1.toCharArray()) {
            charFreq[c - 'a']--;
        }

        // Loop through our hash table.
        // If we encounter a value that is NOT a zero, this means this is NOT a
        // permutation.
        for (int freq : charFreq) {
            if (freq != 0) {
                return false;
            }
        }

        // If we reach this point, the two strings are permutations of one another.
        return true;
    }

    public static void main(String[] args) {
        String sampleOne = "tacooekkols";
        String sampleTwo = "octa";
        System.out.println(
                sampleTwo + " is a permutation of " + sampleOne + ": " + checkPermutation(sampleOne, sampleTwo));
    }
}
