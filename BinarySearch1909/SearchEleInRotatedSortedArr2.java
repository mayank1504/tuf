package BinarySearch1909;

public class SearchEleInRotatedSortedArr2 {
    // Function to search an element in a rotated sorted array with duplicates
    // Time Complexity: O(n) in the worst case due to duplicates
    // Space Complexity: O(1)
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;   
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // If we have duplicates, we can just move the left pointer
            if (nums[l] == nums[mid] && nums[r] == nums[mid]) {
                l++;
                r--;
            } 
            // Check if the left half is sorted
            else if (nums[l] <= nums[mid]) {
                // Target is in the left half
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else { // Target is in the right half
                    l = mid + 1;
                }
            } else { // Right half is sorted
                // Target is in the right half
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else { // Target is in the left half
                    r = mid - 1;
                }
            }
        }
        return false; // Target not found
    }
}
