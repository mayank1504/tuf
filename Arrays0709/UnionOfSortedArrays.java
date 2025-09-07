package Arrays0709;

import java.util.Arrays;

public class UnionOfSortedArrays {
    public int[] unionArray(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int i=0;
        int j=0;
        int[] unionArray = new int[n1+n2];
        int idx=0;
        while(i<n1 && j<n2){
            if(nums1[i]<=nums2[j]){
                if(idx==0 || unionArray[idx-1]!=nums1[i] ){
                    unionArray[idx++]=nums1[i];
                }
                i++;
            }
            else{
                if(idx==0 || unionArray[idx-1]!=nums2[j] ){
                    unionArray[idx++]=nums2[j];
                }
                j++;
            }
        }
        while(i<n1){
            if(idx==0 || unionArray[idx-1]!=nums1[i] ){
                    unionArray[idx++]=nums1[i];
                }
                i++;
        }
        while(j<n2){
            if(idx==0 || unionArray[idx-1]!=nums2[j] ){
                    unionArray[idx++]=nums2[j];
                }
                j++;
        }
        return Arrays.copyOf(unionArray,idx);
    }
}
