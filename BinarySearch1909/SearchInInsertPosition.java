package BinarySearch1909;

public class SearchInInsertPosition {
    // Driver Code
    public static void main(String[] args) {
        SearchInInsertPosition sip = new SearchInInsertPosition();
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(sip.searchInsert(nums,target));
    }

    // Binary Search - Iterative Approach
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public int searchInsert(int[] nums, int target) {
       int n = nums.length;
       int low=0,high=n-1;
       int mid;

       while(low<=high){
        mid = (low+high)/2;
        if(nums[mid]==target){
            return mid;
        }
        else if(nums[mid]>target){
            high = mid-1;
        }
        else low = mid+1;
       }
       return low;
    }
}
