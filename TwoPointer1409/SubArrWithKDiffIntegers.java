package TwoPointer1409;

import java.util.HashSet;
import java.util.Set;

public class SubArrWithKDiffIntegers {
    // Driver method to test the function
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println("Number of subarrays with exactly " + k + " different integers: " + subarraysWithKDistinct(arr, k));
    }

    // Brute Force Approach (Commented Out)
    // TC O(n^3)
    // SC O(n)
    public static int subarraysWithKDistinctBrute(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (hasKDistinct(nums, i, j, k)) {
                    count++;
                }
            }
        }
        return count;
    }
    private static boolean hasKDistinct(int[] nums, int start, int end, int k) {
        Set<Integer> distinct = new HashSet<>();
        for (int i = start; i <= end; i++) {
            distinct.add(nums[i]);
        }
        return distinct.size() == k;
    }

    // Function to count the number of subarrays with exactly k different integers
    // using the two-pointer technique
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    private static int atMostKDistinct(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int count = 0;
        int[] freq = new int[n + 1];
        int distinctCount = 0;

        while (right < n) {
            if (freq[nums[right]] == 0) {
                distinctCount++;
            }
            freq[nums[right]]++;

            while (distinctCount > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    distinctCount--;
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}
