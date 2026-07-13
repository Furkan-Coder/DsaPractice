package sortingalgorithm;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static  void mergeSort(int arr[],int left,int right){
        if(left>=right){
            return;
        }
        int mid=(left+right)/2;

        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);

        merge(arr,left,mid,right);
    }
    public static void  merge(int arr[],int left, int mid, int right){
        int[] temp=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;

        while( i <= mid && j <= right ){
            if(arr[i]<=arr[j]) {
                temp[k++] = arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=right){
            temp[k++]=arr[j++];
        }
        for (int p=0; p< temp.length; p++){
            arr[left+p]=temp[p];
        }
    }
}
