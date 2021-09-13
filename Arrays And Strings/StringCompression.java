/*
-- String Compression --

Implement a method to perform basic string compression using the counts of repeated
characters. For example, the string "aabcccccaaa" would become "a2b1c5a3". If the
compressed string would not become smaller than the original string, your method should
return the original string. You can assume the string has only uppercase and lowercase
letters (a - z).
*/

public class StringCompression {

    /*
     * We use the StringBuilder object to create a new string because this is more
     * efficient than string concatenation.
     * 
     * What we'll do here is count the number of consecutive frequencies.
     * 
     * When we encounter a character that is different than our consecutive count,
     * we add that character to the StringBuilder object as well as its current
     * count. We then reset the count to 0 to start on the new character.
     * 
     * The last condition is a conditional operator. Although compressed, if the new
     * string is longer than the original, we return the original. If it is shorter,
     * we return the new, compressed string
     * 
     * Time Complexity: O(N) where N is the length of our string.
     * 
     * Space Complexity: O(1)
     */

    public static String stringCompression(String str) {
        // Use StringBuilder to build the new compressed string.
        StringBuilder compressedStr = new StringBuilder();

        // We count the number of characters that are consecutive.
        int count = 0;

        // We iterate through the length of our string.
        for (int i = 0; i < str.length(); i++) {
            // Grab the current character.
            char currentChar = str.charAt(i);
            // Increase the consecutive count.
            count++;

            // If we reach the end of the string OR the next character is NOT the same as
            // our current character.
            if (i + 1 >= str.length() || currentChar != str.charAt(i + 1)) {
                // Append the current character AND its count.
                compressedStr.append(currentChar);
                compressedStr.append(count);
                // Reset the count to 0.
                count = 0;
            }
        }

        // We only return our new compressed string IF the new string is smaller than
        // the original.
        return compressedStr.toString().length() < str.length() ? compressedStr.toString() : str;
    }

    public static void main(String[] args) {
        String sampleOne = "aabcccccaaa";
        System.out.println(stringCompression(sampleOne));
    }
}
