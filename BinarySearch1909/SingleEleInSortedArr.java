package BinarySearch1909;

public class SingleEleInSortedArr {
    // Function to find the single element in a sorted array where every other element appears twice
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            // Ensure mid is even for comparison
            if (mid % 2 == 1) {
                mid--;
            }

            // Check if the pair is valid
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2; // Move to the right half
            } else {
                r = mid; // Move to the left half
            }
        }
        return nums[l]; // or nums[r], since l == r
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(SingleEleInSortedArr.singleNonDuplicate(nums));
    }
}
