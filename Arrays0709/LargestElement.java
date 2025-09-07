package Arrays0709;

public class LargestElement {
    public int largestElement(int[] nums) {
        int largest = nums[0];
        for(int i=1;i<nums.length;i++){
            largest = Math.max(largest,nums[i]);
        }
        return largest;
    }
}
