package arrays.subarrayandprefixSum;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
    int arr[]={3,5,6,8,6,5,3};
        System.out.println(maxSubArraySum(arr));
        int k=8;
        System.out.println(countSumEqualToK(arr,k));
        System.out.println(equilibriumIndex(arr));
        System.out.println(Arrays.toString(productOfArray(arr)));
        System.out.println(Arrays.toString(subArraysDivisibleByK(arr,k)));
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
    public static int equilibriumIndex(int arr[]){
        int totalSum=0;
        int leftSum=0;
        for(int i=0;i<arr.length;i++) {
            totalSum += arr[i];
        }
        for (int i = 0;i<arr.length;i++) {
            int rightSum = totalSum - leftSum + arr[i];
            if (rightSum == leftSum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

//   6. Product of array except self
    public static int[] productOfArray(int arr[]){
        int product[]=new int[arr.length];
        for(int i=0;i<arr.length;i++) {

            int pro = 1;
            for (int j = 1; j < arr.length; j++) {
                if (arr[i] != arr[j]) {
                    pro *= arr[j];
                }
                product[i] = pro;
            }
        }
            return product;
    }

//   7. Find subarrays with sum divisible by K
    public static int[] subArraysDivisibleByK(int arr[],int k){
        for (int left=0;left<arr.length;left++) {
            int sum = 0;
            for (int right = left+1; right < arr.length; right++) {
                sum += arr[right];
                if(sum%k==0){
                    int result[]=new int[]{right-left+1};
                    return result;
                }
            }

        }
        return new int[]{};
    }

//   8. Maximum product subarray

//   9. Circular subarray sum

//   10. Find smallest subarray with sum ≥ K

}
