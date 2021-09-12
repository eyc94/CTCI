/*
-- URLify --

Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the
"true" length of the string. (Note: If implementing in Java, please use a character array so
that you can perform this operation in place).
*/

public class URLify {

    /*
     * We utilize our character array and start from the back. We are only given the
     * true length of our input string, so we need to find our final index of our
     * final array. To do this, we count the number of spaces.
     * 
     * Our first iteration counts the spaces.
     * 
     * Calculate our new index by multiplying our space count by 2 and adding it to
     * the true length. This works because we already have a space for the empty
     * space. We just need two more spaces for each empty space. So, we multiply by
     * 2.
     * 
     * I don't really think we need to mark the end of the array.
     * 
     * Iterate backwards and for every space we encounter, we add '0' then '2' then
     * '%'. Then decrement index by 3. If we encounter a non-space, we just add that
     * character.
     * 
     * We do not return anything and solve it in place.
     * 
     * Time Complexity: O(N) where N is the length of our input character array.
     * 
     * Space Complexity: O(1) because we solve it in-place.
     */

    public static void urlify(char[] str, int trueLength) {
        // We count spaces first to see how long our actual length is going to be.
        int spaceCount = 0; // Starts at 0.
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++; // Increment space count when we encounter a space.
            }
        }

        // Grab the last index of the new character array.
        // We need 3 spaces for every ' ' character.
        // We we already have 1 space for every count, we just multiply spaceCount by 2.
        int index = trueLength + spaceCount * 2;

        // We don't really need this I think.
        if (trueLength < str.length) {
            str[trueLength] = '\0'; // End array
        }

        // Iterate from the back of the true string.
        for (int i = trueLength - 1; i >= 0; i--) {
            // If we encounter a space, add '%20' to the BACK of the character array.
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3; // Decrement index pointer three spaces down.
            } else { // If we do not encounter a space, just add that character.
                str[index - 1] = str[i]; // Add character.
                index--; // Decrement index pointer.
            }
        }
    }

    public static void main(String[] args) {
        char[] sampleOne = new char[] { 'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ',
                ' ' };
        int trueLength = 13;
        urlify(sampleOne, trueLength);
        System.out.println(sampleOne);
    }
}
