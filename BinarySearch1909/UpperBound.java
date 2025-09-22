package BinarySearch1909;

public class UpperBound {
    // Driver Code
    public static void main(String[] args) {
        UpperBound ub = new UpperBound();
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(ub.upperBound(nums,target));
    }

    // Binary Search - Iterative Approach to find Upper Bound
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public int upperBound(int[] nums, int target) {
       int n = nums.length;
       int low=0,high=n-1;
       int mid;
       int ans = n; // Default answer if target is greater than all elements
        while(low<=high){
        mid = (low+high)/2;
        if(nums[mid]>target){
            ans = mid; // Potential answer found
            high = mid-1; // Look for a smaller index
        }
        else {
            low = mid+1;
        }
        }
         return ans;
    }
}
