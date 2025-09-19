package TwoPointer1409;

public class NoOfSubstrContainAllChar {
    // Function to count substrings containing all characters of the string
    // using the two-pointer technique
    // Time Complexity: O(n)
    // Space Complexity: O(1) assuming the character set is fixed (e.g., lowercase letters)
    public static int countSubstrings(String str) {
        int n = str.length();
        int k = 3;
            // Assuming the string contains only lowercase letters a, b, c
            // If the string can contain other characters, we need to adjust this part
        int count = 0;
        int left = 0;
        int[] charCount = new int[256];
        int distinctCount = 0;
        for (int right = 0; right < n; right++) {
            charCount[str.charAt(right)]++;
            if (charCount[str.charAt(right)] == 1) {
                distinctCount++;
            }
            while (distinctCount == k) {
                count += (n - right);
                charCount[str.charAt(left)]--;
                if (charCount[str.charAt(left)] == 0) {
                    distinctCount--;
                }
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abcabc";
        System.out.println("Number of substrings containing all characters: " + countSubstrings(str));
    }
}
