package BinarySearch1909;

public class Search {
    // Driver Code
    public static void main(String[] args) {
        Search search = new Search();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search.search(nums,target));
    }

    // Binary Search - Iterative Approach
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public int search(int[] nums, int target) {
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
       return -1;
    }

    
}
