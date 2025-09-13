package Arrays1009;

import java.util.HashMap;

public class NoOfSubArrXORK {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(countSubarraysWithXor(arr, k));
    }
    // Brute Force Approach
    // O(n^2)
    public static int countSubarraysWithXor(int[] arr, int k) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {   
                xor ^= arr[j];
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // Better Approach
    // O(n)
    // Using HashMap
    public int subarraysWithXorK(int[] nums, int k) {
      int n = nums.length;
      int xr=0;
      int cnt=0;
      HashMap<Integer,Integer> map = new HashMap<>();
      map.put(0,1);
      for(int i=0;i<n;i++){
        xr = xr^nums[i];
        int req_element = xr^k;
        map.put(xr,map.getOrDefault(xr,0)+1);
        if(map.containsKey(req_element)){
            cnt+= map.getOrDefault(req_element,0);
        }
      }
      return cnt;
    }
}
