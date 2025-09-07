package Arrays0709;

public class SecondLargest {
    public int secondLargestElement(int[] nums) {
        int largest=nums[0], second=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>largest){
                second=largest;
                largest=nums[i];
            }
            else if(nums[i]<largest && nums[i]>second){
                second=nums[i];
            }
        }
        return second;
    }
}
