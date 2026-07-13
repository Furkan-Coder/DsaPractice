package arrays.sortingplusgreedy;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
    int arr1[]={1,3,5,9};
    int arr2[]={2,5,8,9,10};
    int k=2;
        System.out.println(kThLargest(arr2,k));
    int res[]=mergeArray(arr2,arr1);
        System.out.println(Arrays.toString(res));

    }
//    Merge two sorted arrays
public static int[] mergeArray(int arr1[],int arr2[]){
        int result[]=new int[arr2.length+arr1.length];
        int i=0;
        int j=0;
        int k=0;
        while (i<arr1.length && j<arr2.length){
            if(arr1[i]<=arr2[j]){
                result[k++]=arr1[i++];
            }else{
                result[k++]=arr2[j++];
            }
        }
        while (i<arr1.length){
            result[k++]=arr1[i++];
        }
        while (j<arr2.length){
            result[k++]=arr2[j++];
        }
        return result;
}

//    Find kth largest element
    public static int kThLargest(int arr[],int k){
        Arrays.sort(arr);
        return arr[arr.length-k];
    }
//    Minimum platforms / meeting rooms
//
//
//    Minimum number of swaps to sort
//
//
//    Find minimum difference pair
//
//
//    Rearrange array alternately
//
//
//    Check if array can be sorted by reversing a subarray
//
//
//    Sort array by parity
//
//
//    Find inversion count
//
//
//    Minimum number of moves to make array equal



}
