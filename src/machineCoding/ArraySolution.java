package machineCoding;

import java.util.Arrays;

public class ArraySolution {
    public static void main(String[] args) {
        int arr[]={2,5,7,8,12,15};
        int target=12;
        int[]res=targetSum(arr,target);
        System.out.println(Arrays.toString(res));
        System.out.println(countSubArray(arr,target));
        int res1=trappedWater(arr);
        System.out.println(res1);
        System.out.println(Arrays.toString(product(arr)));
        int arr1[]={2,3,4,7,5,4,1};
        int target1=4;
        System.out.println(searchInRotated(arr1,target1));
        int arr2[]={8,9,-4,2,-5,12};
        System.out.println(maxSubArraySum(arr2));
    }
//       ARRAY – 8 Questions
//1 Two Sum
//    Return indices of two numbers that add up to target.
        public static int[] targetSum(int[] arr,int target){
           int i=0;
           int j=arr.length-1;
           while(i<j){
               int sum=arr[i]+arr[j];
               if(sum==target){
                   return new int[]{i,j};
               }else if(sum>target){
                   j--;
               }else {
                   i++;
               }
           }
           return new int[]{-1,-1};
        }
//            2 Product of Array Except Self
//    Return array where each element is product of all other elements. No division allowed.
    public  static  int[] product(int[]arr){
        int res[]=new int[arr.length];
        for (int i=0;i<arr.length;i++){
            int product=1;
            for(int j=0;j<arr.length;j++){
                if(arr[i]!=arr[j]){
                    product*=arr[j];
                }
            }
            res[i]=product;
        }
         return res;
    }
//
//3 Merge Overlapping Intervals
//    Merge overlapping intervals.
//
//4 Subarray Sum Equals K
//    Count number of subarrays whose sum equals K.

    public  static  int countSubArray(int arr[],int target){
        int count=0;
        int i=0;
        int sum=0;
        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            if(sum>target&&i<j){
                sum-=arr[i];
                i++;
            }
            if(sum==target){
                count++;
            }
        }
        return count;
    }
//
//            5 Maximum Subarray Sum Circular
//    Array is circular; find max sum.
public static int maxSubArraySum(int arr[]){
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int currSum=0;
            for(int j=i;j<arr.length;j++){
                int index=(i+j)%arr.length;
                currSum+=arr[index];
                maxSum=Math.max(maxSum,currSum);
            }
        }
        return maxSum;
}
//6 Trapping Rain Water
//    Calculate trapped water between bars.
  public static int trappedWater(int[]arr){
        int i=0;
        int j=arr.length-1;
        int leftMax=0;
        int rightMax=0;
        int water=0;
        while (i<j){
        if(arr[i]<=arr[j]){
            leftMax=Math.max(leftMax,arr[i]);
            water+=leftMax-arr[i];
            i++;
        }else{
            rightMax=Math.max(rightMax,arr[j]);
            water+=rightMax-arr[j];
            j--;
        }
        }
        return water;
  }
//7 Search in Rotated Sorted Array
//    Find target in rotated sorted array in O(log n).

    public static int searchInRotated(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while (left<=right) {
            int mid = left + (right - left) / 2;
            if (arr[mid]==target) {
                return mid;
            }
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > arr[mid] && target < arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
//
//            8 Largest Rectangle in Histogram
//    Return maximum rectangular area in histogram.
}
