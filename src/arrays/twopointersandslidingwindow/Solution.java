package arrays.twopointersandslidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        int arr[]={4,2,6,8,2,8,1,12};
        int sum=1;
        int []res1=twoSum(arr,sum);
        System.out.println(Arrays.toString(res1));
        int []sortArr={1,3,3,5,5,6,8,9};
        int target=16;
        int res2[]=findPair(sortArr,target);
        System.out.println(Arrays.toString(res2));
        System.out.println(Arrays.toString(arr));
        int res3[]=removeDuplicate(sortArr);
        System.out.println(Arrays.toString(res3));
        int []res4=square(sortArr);
        System.out.println(Arrays.toString(res4));
        int res5=longestSubarray(arr,target);
        System.out.println(res5);
        int k=3;
        int res6=maxSubArrSum(arr,k);
        System.out.println(res6);
        int res7=longestDistinctSubarray(arr,k);
        System.out.println(res7);
    }
//    Two Pointers / Sliding Window
//    Two Sum
    public static int[] twoSum(int arr[],int sum){
        for(int i=0; i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]+arr[i]==sum){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1};
    }

//    Pair with given sum in sorted array
    public static int[] findPair(int sortArr[],int target){
        int i=0;
        int j=sortArr.length-1;
        while (i<j){
           if(sortArr[i]+sortArr[j]==target){
               return new int[] {i,j};
           } else if (sortArr[i]+sortArr[j]>target) {
               j--;

           }else{
               i++;
           }
        }
        return new int[]{-1};
    }
//    Remove duplicates (two pointers)
    public static int[] removeDuplicate(int arr[]){
        int i=0;
        for (int j = 1; j <arr.length ; j++) {
            if(arr[j]!=arr[i]){
                i++;
                arr[i]=arr[j];
        }
        }
        return Arrays.copyOf(arr,i+1);
    }
//    Squares of a sorted array
    public static int[] square(int arr[]){
        int res[]=new int[arr.length];
        for (int i=0;i<arr.length;i++){
            res[i]= arr[i]*arr[i];
        }
        return res;
    }
//    Container With Most Water
//
//
//    Longest subarray with sum ≤ K
    public static int longestSubarray(int arr[],int target){
        int maxLen=0;
        int i=0;
        int sum=0;
        for(int j=1;j<arr.length;j++){
           sum+=arr[j];
           if(sum>target){
               sum-=arr[i];
               i++;
           }
           if(sum==target){
               maxLen=Math.max(maxLen,j-i+1);
           }
        }
        return maxLen;
    }
//    Max sum subarray of size K
    public  static int maxSubArrSum(int arr[],int k){
        int currSum=0;
        int maxSum=0;
        int i=0;
        for(int j=0; j<arr.length;j++){
            currSum+=arr[j];
            if(j-i+1>k){
                currSum-=arr[i];
                i++;
            }
            if(j-i+1 ==k){
                maxSum=Math.max(maxSum,currSum);
            }
        }
        return maxSum;
    }
    //    Longest subarray with at most K distinct elements
    public  static int longestDistinctSubarray(int arr[],int k){
        int maxLen=0;
        for (int i=0;i<arr.length;i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < arr.length; j++) {
                set.add(arr[j]);
                if(set.size()>k){
                    break;
                }
                if (set.size() == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
          return maxLen;
    }

//    Trapping Rain Water
//
//
//    Sort colors (Dutch National Flag)

}
