package TwoPointer1409;

public class MaxPointsFromCards {
    // Time Complexity: O(k)
    // Space Complexity: O(1)
    public int maxScore(int[] cardScore, int k) {
        int lSum = 0;
        int rSum = 0;
        int maxSum = 0;
        for(int i=0;i<k;i++){
            lSum += cardScore[i];
        }
        maxSum = lSum;
        int rIndex = cardScore.length - 1;
        for(int i=k-1;i>=0;i--){
            lSum -= cardScore[i];
            rSum += cardScore[rIndex--];
            maxSum = Math.max(maxSum,lSum+rSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxPointsFromCards mpfc = new MaxPointsFromCards();
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(mpfc.maxScore(cardPoints,k));
    }
}
