package BinarySearch1909;

public class SearchEleInRotatedSortedArr1 {
    // Function to search an element in a rotated sorted array
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int search(int[] nums, int k) {
       int n = nums.length;
       int low=0, high=n-1;
       while(low<=high){
        int mid=(low+high)/2;
        if(nums[mid]==k){
            return mid;
        }
        if(nums[low]<= nums[mid]){
            if(k>=nums[low] && k<nums[mid]){
                high=mid-1;
            }
            else{
                low = mid+1;
            }
        }
        else{
            if(k>nums[mid] && k<nums[high]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
       }
       return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("Index of target " + target + ": " + search(nums, target));
    }
}
