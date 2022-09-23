package binarySearch;


import java.util.Arrays;

public class AggressiveCows {

    public static int chessTournament(int[] positions, int n,  int c)
    {
        Arrays.sort(positions);
        int left = 1;
        int right = positions[n-1]-positions[0];
        while (left<=right){
            int mid = (left+right)/2;
            if(check(positions,mid,c))
                left = mid+1;
            else
                right=mid-1;
        }
        return right;
    }

    public static boolean check(int[] arr,int val,int c){
       int count = 1;
       int lastCount = arr[0];
       for(int i=1;i<arr.length;i++){
           if(arr[i]-lastCount>=val) {
               count++;
               lastCount = arr[i];
           }
       }
        return count >= c;
    }

}
