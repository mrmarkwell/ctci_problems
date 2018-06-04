import java.util.*;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 *
 */
class IsUnique {

    // Using hashset... O(n)
    public static boolean allCharsUnique(String s) {
        // I didn't think of this, but this is a great simplification if the string is ascii:
        if (s.length() > 128) {
            return false; // can't be false if there are more characters in the string than there are in the set of all characters.
        }
        Set<Character> chars_seen = new HashSet<>();

        for(int i=0; i < s.length(); i++) {
            Character c = Character.valueOf(s.charAt(i));
            if (chars_seen.contains(c)) {
                return false;
            }
            chars_seen.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "qwertyuioplkjhgfdsamnbvcxz"; // Should return true.
        String test2 = "and;vjwnev;owien"; // Should return false.
        String test3 = "asdfjkl;iee"; // Should return false.
        System.out.println(allCharsUnique(test1));
        System.out.println(allCharsUnique(test2));
        System.out.println(allCharsUnique(test3));
    }

}
