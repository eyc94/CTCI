/*
-- Check Permutation --

Given two strings, write a method to decide if one is a permutation of the other.
*/

public class CheckPermutation {

    /*
    */

    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] charFreq = new int[26];
        for (char c : str2.toCharArray()) {
            charFreq[c - 'a']++;
        }
        for (char c : str1.toCharArray()) {
            charFreq[c - 'a']--;
        }
        for (int freq : charFreq) {
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String sampleOne = "tacooekkols";
        String sampleTwo = "octa";
        System.out.println(
                sampleTwo + " is a permutation of " + sampleOne + ": " + checkPermutation(sampleOne, sampleTwo));
    }
}
