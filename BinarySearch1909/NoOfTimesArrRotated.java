package BinarySearch1909;

public class NoOfTimesArrRotated {
    // Function to find the number of times a sorted array is rotated
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int countRotations(int[] nums) {
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
        return l; // or r, since l == r
    }

    public static void main(String[] args) {
        int[] nums = {15,18,2,3,6,12};
        System.out.println(NoOfTimesArrRotated.countRotations(nums));
    }
}
