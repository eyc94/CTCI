/*
-- Palindrome Permutation --

Given a string, write a function to check if it is a permutation of a palindrome. A
palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.
*/

public class PalindromePermutation {

    /*
     * Our strategy here is to use a hash table to count frequencies of characters.
     * 
     * It is important to know what defines a permutation of a palindrome. We know
     * that a string that's a palindrome is the same forwards and backwards. Knowing
     * this, We know that every character frequency should be even. It can have at
     * most 1 odd frequency for odd length strings.
     * 
     * So, we use the hash table to count frequencies.
     * 
     * We first replace all whitespaces in our string with empty spaces to remove
     * spaces.
     * 
     * We then increment frequency of all characters in our string inside our hash
     * table.
     * 
     * We count how many odd frequencies there are in the hash table.
     * 
     * If our string length is even, there should NOT be any odd frequencies. If our
     * string length is odd, there should be only ONE odd frequency. Knowing this,
     * we return true or false depending on the condition.
     * 
     * Time Complexity: O(N) where N is the length of our string input.
     * 
     * Space Complexity: O(1) because we only use a 26 length hash table to count
     * frequency.
     */

    public static boolean palindromePermutation(String str) {
        // This removes all white spaces from the string.
        str = str.replaceAll("\\s", "");

        // We create a hash table that stores frequencies of 26 alphabet characters.
        int[] charFreq = new int[26];

        // Count the frequencies of the characters in our string.
        for (char c : str.toCharArray()) {
            charFreq[c - 'a']++;
        }

        // Count how many odd frequencies there are.
        int oddCount = 0;
        for (int freq : charFreq) {
            if (freq % 2 != 0) {
                oddCount++;
            }
        }

        // If our input string is even AND there is no odd frequencies.
        if (str.length() % 2 == 0 && oddCount == 0) {
            return true; // Return true.
        }

        // If our input string is odd AND there is an odd frequency.
        if (str.length() % 2 != 0 && oddCount != 0) {
            return true; // Return true.
        }

        // Otherwise, return false.
        return false;
    }

    public static void main(String[] args) {
        String sampleOne = "tactcoapapaz";
        System.out.println(palindromePermutation(sampleOne));
    }
}
