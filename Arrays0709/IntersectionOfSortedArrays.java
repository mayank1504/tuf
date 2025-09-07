package Arrays0709;

import java.util.Arrays;

public class IntersectionOfSortedArrays {
    public int[] intersectionArray(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int i=0;
        int j=0;
        int[] ans = new int[Math.min(n1, n2)];
        int idx=0;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums2[j]<nums1[i]){
                j++;
            }
            else{
                ans[idx++]=nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOf(ans,idx);
    }
}
