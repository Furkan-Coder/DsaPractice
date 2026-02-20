package arrays.subarrayandprefixSum;

public class Solution {
    public static void main(String[] args) {
    int arr[]={3,5,6,8,9,12};
        System.out.println(maxSubArraySum(arr));
        int k=8;
        System.out.println(countSumEqualToK(arr,k));
    }
//   1. Maximum subarray sum (Kadane’s)
    public static int maxSubArraySum(int arr[]){
        int maxSum=0;
        for(int i=0;i<arr.length;i++){
            int currSum=0;
            for(int j=i;j<arr.length;j++){
                currSum+=arr[j];

            }

            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
    }

//   2. Subarray with given sum

//   3. Count subarrays with sum = K
    public  static int countSumEqualToK(int arr[],int k){

        int count=0;
        for(int i=0; i<arr.length;i++){
            int sum=0;
            for (int j=i;j<arr.length;j++) {
                sum += arr[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
//   4. Longest subarray with equal 0s and 1s

//   5. Equilibrium index

//   6. Product of array except self

//   7. Find subarrays with sum divisible by K

//   8. Maximum product subarray

//   9. Circular subarray sum

//   10. Find smallest subarray with sum ≥ K

}
