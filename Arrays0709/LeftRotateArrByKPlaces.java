package Arrays0709;

public class LeftRotateArrByKPlaces {
    public static void reverseArray(int[] arr,int left,int right){
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    public void rotateArray(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,n-1);
        reverseArray(nums,0,n-1);
    }
}
