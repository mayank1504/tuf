package TwoPointer1409;

public class MinWindowSubstr {
    // Function to find the minimum window substring
    // using the two-pointer technique
    // Time Complexity: O(n)
    // Space Complexity: O(1) assuming the character set is fixed (e.g., ASCII)
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        int[] charCount = new int[128];
        for (char c : t.toCharArray()) {
            charCount[c]++;
        }

        int left = 0, right = 0, required = t.length();
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (charCount[rightChar] > 0) {
                required--;
            }
            charCount[rightChar]--;

            while (required == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                charCount[leftChar]++;
                if (charCount[leftChar] > 0) {
                    required++;
                }
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window substring: " + minWindow(s, t));
    }
}
