/*
-- String Rotation --

Assume you have a method isSubstring which checks if one word is a substring of
another. Given two strings, s1 and s2, write code to check if s2 is a rotation
of s1 using only one call to isSubstring (e.g. "waterbottle" is a rotation of 
"erbottlewat").
*/

public class StringRotation {

    /*
     * If we imagine that s2 is a rotation of s1, we can ask what the rotation point
     * is.
     * 
     * If you rotate "waterbottle" after "wat", you get "erbottlewat". In a
     * rotation, we cut s1 into two parts, x and y, and rearrange to get s2.
     * 
     * Let s1 = xy = waterbottle
     * 
     * x = wat
     * 
     * y = erbottle
     * 
     * s2 = yx = erbottlewat
     * 
     * Split s1 into x and y such that xy = s1 and yx = s2. Regardless of where the
     * division between x and y is, we see that yx will always be a substring of
     * xyxy. That is, s2 will always be a substring of s1s1.
     */

    public static boolean stringRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
