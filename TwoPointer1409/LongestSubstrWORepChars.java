package TwoPointer1409;

public class LongestSubstrWORepChars {
    //Brute Force Approach
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    public int lengthOfLongestSubstring_BruteForce(String s) {
        int maxLen = 0;
        for(int i=0;i<s.length();i++){
            boolean[] charSet = new boolean[128];
            for(int j=i;j<s.length();j++){
                char c = s.charAt(j);
                if(charSet[c]){
                    break;
                } else {
                    charSet[c] = true;
                    maxLen = Math.max(maxLen,j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // Optimal Approach
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int longestNonRepeatingSubstring(String s) {
        int n = s.length();
        int l=0,r=0,maxlen=0;
        int[] hash = new int[256];
        for(int i=0;i<256;i++){
            hash[i]=-1;
        }
        while(r<n){
            char ch = s.charAt(r);
            if(hash[ch]!=-1){
                if(hash[ch]>=l){
                    l=hash[ch]+1;
                }
            }
            maxlen = Math.max(maxlen,r-l+1);
            hash[ch]=r;
            r++;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        LongestSubstrWORepChars lsworc = new LongestSubstrWORepChars();
        String s = "abcabcbb";
        System.out.println(lsworc.longestNonRepeatingSubstring(s));
    }   
}
