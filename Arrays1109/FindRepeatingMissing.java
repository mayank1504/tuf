package Arrays1109;

public class FindRepeatingMissing {
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans = findMissingRepeatingNumbers3(a);
        System.out.println("The repeating and missing numbers are: {"
                           + ans[0] + ", " + ans[1] + "}");
    }

    // Brute Force Approach
    // O(n^2)

    private static int[] findMissingRepeatingNumbers(int[] a) {
        int n=a.length;
        int repeating =-1 , missing=-1;
        for(int i=1;i<=n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(a[j]==i)cnt++;
            }
            if(cnt==2)repeating=i;
            else if(cnt==0)missing=i;

            if(repeating!=-1 && missing!=-1)break;
        }
        int[] ans = {repeating,missing};
        return ans;
    }

    //Better Approach 
    // TC - O(2n)
    // SC - O(n)

    private static int[] findMissingRepeatingNumbers2(int[] a) {
        int n=a.length;
        int[] hash = new int[n+1];

        for(int i=0;i<n;i++){
            hash[a[i]]++;
        }
        int repeating=-1,missing=-1;
        for(int i=1;i<=n;i++){
            if(hash[i]==2)repeating=i;
            else if(hash[i]==0)missing=i;

            if(repeating!=-1 && missing!=-1)break;
        }
        int[] ans = {repeating,missing};
        return ans;
    }

    //Optimal Approach 
    // TC - O(n)
    // SC - O(1)

    private static int[] findMissingRepeatingNumbers3(int[] a) {
        long n=a.length;
        long sn = (n*(n+1))/2;
        long s2n = (n*(n+1)*(2*n+1))/6;
        
        long s=0,s2=0;

        for(int i=0;i<n;i++){
            s+=a[i];
            s2 += (long)a[i] * (long)a[i];
        }

        //x-y
        long val1 = s-sn;

        //x2-y2
        long val2 = s2-s2n;

        //x+y
        val2 = val2/val1;
        long x = (val1+val2)/2;
        long y = val2-x;
        int[] ans = {(int)x,(int)y};
        return ans;
    }

    //Optimal Approach 2 using xor
    // TC - O(3n) multiple iterations
    // SC - O(1)
    public int[] findMissingRepeatingNumbers4(int[] nums) {
        int n = nums.length;
        int xr =0;
        for(int i=0;i<n;i++){
            xr = (xr^nums[i])^(i+1);
        }
        int bitNo = 0;
        while(true){
            if((xr & (1<<bitNo))!=0)break;
            bitNo++;
        }

        int zero =0;
        int one=0;

        for(int i=0;i<n;i++){
            if((nums[i] & (1<<bitNo))!=0){
                one = one^nums[i];
            }
            else{
                zero = zero^nums[i];
            }

            if(((i+1)&(1<<bitNo))!=0){
                one = one^(i+1);
            }
            else{
                zero = zero^(i+1);
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]==zero)cnt++;
        }
        if(cnt==2) return new int[]{zero,one};
        else return new int[]{one,zero};
    }
    
}
