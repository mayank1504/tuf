package BinarySearch1909;

public class FirstLastOccurence {
    // Function to find the first and last occurrence of a target in a sorted array
    // using binary search
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public static int[] searchRange(int[] nums, int target) {
        int first = first(nums,target);
        int last = last(nums,target);
        return new int[]{first,last};
    }

    private static int first(int[] nums,int target){
        int n = nums.length;
        int low =0, high=n-1;
        int first=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                high=mid-1;
                first=mid;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return first;
    }

    private static int last(int[] nums,int target){
        int n = nums.length;
        int low =0, high=n-1;
        int last=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                low=mid+1;
                last=mid;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println("First and Last Occurrence of " + target + ": [" + result[0] + ", " + result[1] + "]");
    }
}
