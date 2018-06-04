import java.util.*;

/**
 * 1.2
 * Check Permutation: Given two strings,
 * write a method to decide if one is a permutation of the other.
 */
class CheckPermutation {

    // HashMap solution. O(n) where n is length of both strings. O(1) if the strings have different length.
    public static boolean isPermutation(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }
        Map<Character, Integer> char_count_a = new HashMap<>();
        Map<Character, Integer> char_count_b = new HashMap<>();

        for(int i = 0; i < a.length(); i++) {
            Character c_a = Character.valueOf(a.charAt(i));
            Character c_b = Character.valueOf(b.charAt(i));
            char_count_a.put(c_a, char_count_a.getOrDefault(c_a, 0) + 1);
            char_count_b.put(c_b, char_count_b.getOrDefault(c_b, 0) + 1);
        }

        if (char_count_a.equals(char_count_b)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "qqqqwertyuiop";
        String b = "poiuytrewqqqq";
        String c = "asdfghjkl;;;;";


        System.out.println(isPermutation(a, b)); // true
        System.out.println(isPermutation(a, c)); // false
        System.out.println(isPermutation(b, c)); // false
    }

}

