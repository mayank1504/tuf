package TwoPointer1409;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWithKDistinctChars {
    // Driver Code
    public static void main(String[] args) {
        LongestSubstrWithKDistinctChars lsk = new LongestSubstrWithKDistinctChars();
        String s = "eceba";
        int k = 2;
        System.out.println(lsk.lengthOfLongestSubstringKDistinct(s, k));
    }

    // Longest Substring with at most K distinct characters
    // Time Complexity: O(2n)
    // Space Complexity: O(n)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = 0, r = 0, maxlen = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();
        while (r < s.length()) {
            charCountMap.put(s.charAt(r), charCountMap.getOrDefault(s.charAt(r), 0) + 1);
            while (charCountMap.size() > k) {
                char leftChar = s.charAt(l);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                if (charCountMap.get(leftChar) == 0) {
                    charCountMap.remove(leftChar);  
                }
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }

    // Optimal Approach
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int lengthOfLongestSubstringKDistinctOptimal(String s, int k) {
        int l = 0, r = 0, maxlen = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();
        while (r < s.length()) {
            charCountMap.put(s.charAt(r), charCountMap.getOrDefault(s.charAt(r), 0) + 1);
            if (charCountMap.size() <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            } else {
                while (charCountMap.size() > k) {
                    char leftChar = s.charAt(l);
                    charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                    if (charCountMap.get(leftChar) == 0) {
                        charCountMap.remove(leftChar);  
                    }
                    l++;
                }
            }
            r++;
        }
        return maxlen;
    } 
       
    // Using Array
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int kDistinctChar(String s, int k) {
        int l=0,r=0,maxlen=0;
        int n = s.length();
        int[] hash = new int[128];
        int distinctCount=0;
        while(r<n){
            char ch = s.charAt(r);
            if(hash[ch]==0)distinctCount++;
            hash[ch]++;
            if(distinctCount>k){
                char leftChar = s.charAt(l);
                hash[leftChar]--;
                if(hash[leftChar]==0){
                    distinctCount--;
                }
                l++;
            }
            if(distinctCount<=k){
                maxlen = Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}
