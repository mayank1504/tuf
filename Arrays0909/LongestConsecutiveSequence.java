package Arrays0909;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }

    // Brute Force Approach
    // O(n^2)

    private static int longestSuccessiveElements(int[] a) {
        int n = a.length;
        int longest = 1;

        for(int i=0;i<n;i++){
            int x = a[i];
            int cnt=1;
            while(linearSearch(a,x+1)==true){
                x++;
                cnt++;
            }
            longest = Math.max(cnt, longest);
        }
        return longest;
    }

    private static boolean linearSearch(int[] a, int target) {
        int n=a.length;
        for(int i=0;i<n;i++){
            if(a[i]==target)return true;
        }
        return false;
    }

    // Better Sorting Approach
    // O(n+ nlogn)

    private static int longestSuccessiveElements2(int[] a) {
        int n = a.length;
        if(n==0)return 0;
        int lastSmaller = Integer.MIN_VALUE;
        int cnt=0;
        int longest = 1;
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            if(a[i]-1 == lastSmaller){
                cnt++;
                lastSmaller=a[i];
            }
            else if(a[i]!=lastSmaller){
                cnt=1;
                lastSmaller=a[i];
            }
            longest = Math.max(cnt, longest);
        }
        return longest;
    }

    // Optimal Set Approach
    // O(n+ 2n)

    private static int longestSuccessiveElements3(int[] a) {
        int n = a.length;
        if(n==0)return 0;
        Set<Integer> set = new HashSet<>();
        int longest = 1;
        for(int i=0;i<n;i++){
            set.add(a[i]);
        }
        for(int it:set){
            if(!set.contains(it-1)){
                int cnt=1;
                int x=it;
                while(set.contains(x+1)){
                    x++;
                    cnt++;
                }
                longest=Math.max(cnt, longest);
            }
        }
        return longest;
    }
}
