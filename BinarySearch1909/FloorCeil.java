package BinarySearch1909;

public class FloorCeil {
    // Driver Code
    public static void main(String[] args) {
        FloorCeil fc = new FloorCeil();
        int[] nums = {1,2,8,10,10,12,19};
        int target = 5;
        int[] result = fc.findFloorCeil(nums,target);
        System.out.println("Floor: " + result[0] + ", Ceil: " + result[1]);
    }

    // Find Floor and Ceil of a target in a sorted array
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public int[] findFloorCeil(int[] nums, int target) {
        int n = nums.length;
        int low=0,high=n-1;
        int mid;
        int floor=-1,ceil=-1;
        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid]==target){
                floor = nums[mid];
                ceil = nums[mid];
                return new int[]{floor,ceil};
            }
            else if(nums[mid]>target){
                ceil = nums[mid];
                high = mid-1;
            }
            else {
                floor = nums[mid];
                low = mid+1;
            }
        }
        return new int[]{floor,ceil};
    }
}
