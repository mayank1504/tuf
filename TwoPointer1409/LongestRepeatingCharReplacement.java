package TwoPointer1409;

public class LongestRepeatingCharReplacement {
    // Driver method to test the function
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println("Longest substring length: " + characterReplacement(s, k));
    }

    // Brute Force Approach (Commented Out)
    
    public static int characterReplacementBrute(String s, int k) {
        int maxLength = 0;
        int n = s.length(); 
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String substring = s.substring(i, j + 1);
                if (canMakeUniform(substring, k)) {
                    maxLength = Math.max(maxLength, substring.length());
                }
            }
        }
        return maxLength;
    }

    private static boolean canMakeUniform(String substring, int k) {
        int[] count = new int[26];
        for (char c : substring.toCharArray()) {
            count[c - 'A']++;
        }
        int maxCount = 0;
        for (int cnt : count) {
            maxCount = Math.max(maxCount, cnt);
        }
        return substring.length() - maxCount <= k;
    }

    // Function to find the length of the longest substring that can be obtained
    // by replacing at most k characters to make all characters the same
    // using the two-pointer technique
    // Time Complexity: O(n)
    // Space Complexity: O(1) assuming the character set is fixed (e.g., uppercase letters)
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            while (right - left + 1 - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
