package BinarySearch1909;

public class MinInRotatedSortedArr {
    // Function to find the minimum element in a rotated sorted array
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            // If mid element is greater than the rightmost element,
            // the minimum is in the right half
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else { // Minimum is in the left half including mid
                r = mid;
            }
        }
        return nums[l]; // or nums[r], since l == r
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(MinInRotatedSortedArr.findMin(nums));
    }
}
