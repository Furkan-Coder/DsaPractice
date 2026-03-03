package arrays.basics;

import java.util.*;

public class ArrayBasics {
    public static void main(String[] args) {
        int arr[] = {4, 0, 7, 0, 9, 12, 0, 2, 4, 2, 6, 10};
        int k=3;
//        System.out.println(Arrays.toString(arr));
//        int res1[] = findMax(arr);
//        System.out.println(Arrays.toString(res1));
//        int res2[] = reverseArrayInPlace(arr);
//        System.out.println(Arrays.toString(res2));
//        boolean res3 = sortedArray(arr);
//        System.out.println(res3 ? "Array is sorted" : "Array is not sorted");
//        int res4 = findSecondLargest(arr);
//        System.out.println(res4);
//        System.out.println(freqCount(arr));
//        System.out.println(removeDuplicate(arr));
//        int[] res5 = removeZeroAtTheEnd(arr);
//        System.out.println(Arrays.toString(removeZeroAtTheEnd(res5)));

        System.out.println(Arrays.toString(arr));
        int res6[]=rotateArray(arr,k);
        System.out.println(Arrays.toString(res6));
        int[] arr1={1,2,3,4,6,7,8};
        System.out.println(Arrays.toString(arr1));
        int res7=missingNumber(arr1);
        System.out.println(res7);
        List<Integer>res8=missingNumbers(arr);
        System.out.println(res8);

    }

    //     1.   Find the maximum and minimum in an array
    public static int[] findMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }

        }
        return new int[]{max, min};
    }

    //      2.  Reverse an array in-place
    public static int[] reverseArrayInPlace(int arr[]) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
            i++;
        }
        return arr;
    }

    //      3.  Check if array is sorted
    public static boolean sortedArray(int arr[]) {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //      4.  Find the second largest element
    public static int findSecondLargest(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
            }
            if (arr[i] > max2 && arr[i] != max1) {
                max2 = arr[i];
            }
        }
        return max2;
    }

    //      5.  Count frequency of each element
    public static Map<Integer, Integer> freqCount(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return freq;
    }


    //
//
//      6.  Remove duplicates from a sorted array
    public static Set<Integer> removeDuplicate(int arr[]) {
        Set<Integer> distinct = new HashSet<>();
        for (int num : arr) {
            distinct.add(num);
        }
        return distinct;
    }

    //      7.  Move all zeros to the end
    public static int[] removeZeroAtTheEnd(int arr[]) {
      int j=0;
      for(int i=0;i<arr.length;i++){
          if(arr[i]!=0){
              int temp=arr[i];
              arr[i]=arr[j];
              arr[j]=temp;
              j++;
          }
      }
      return arr;
    }


//      8.  Rotate array by k steps (left/right)
//    public static int[] rotateArray(int arr[]){
//        for(int i=0; i<3;i++){
//            int i1=arr[0];
//            for(int j=0;j< arr.length-1;j++){
//               arr[j]=arr[j+1];
//            }
//            arr[arr.length-1]=i1;
//        }
//        return arr;
//    }

    public static int[] reverse(int arr[],int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return arr;
    }
    public static int[] rotateArray(int[] arr,int k){
        reverse(arr,0,arr.length-1);
        reverse(arr,0,arr.length-k-1);
        reverse(arr,arr.length-k,arr.length-1);

        return arr;
    }

//      9.  Find missing number in 1..n
        public  static  int missingNumber(int arr1[]){
        int n=arr1.length+1;
        int sum=0;
        int expectedSum=n*(n+1)/2;
            System.out.println(expectedSum);
        for(int i=0; i<arr1.length;i++){
            sum=sum+arr1[i];

        }
        return expectedSum-sum;
        }
//      10.  Find all missing numbers in a range
    public static List<Integer>missingNumbers(int arr[]){
        Set<Integer>set=new HashSet<>();
        for(int num: arr){
            set.add(num);
        }
        List<Integer>missing=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(!set.contains(i)){
                missing.add(i);
            }
        }
        return  missing;
    }

}
