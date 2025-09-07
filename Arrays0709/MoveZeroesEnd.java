package Arrays0709;

public class MoveZeroesEnd {
    public void moveZeroes(int[] nums) {
        int j=-1,n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1)return;
        for(int i=j+1;i<n;i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    }
}
