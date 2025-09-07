package Arrays0709;

public class RemoveDuplicatesSortedArr {
    public int removeDuplicates(int[] nums) {
        int new_index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[new_index]){
                new_index++;
                nums[new_index]=nums[i];
            }
        }
        return new_index+1;
    }
}
