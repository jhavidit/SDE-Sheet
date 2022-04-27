package array.day3;

public class MajorityElements1 {

    public static int majorityElement(int[] nums) {
        int max = 0,maxV=-1;
        for (int num : nums) {
            if (max == 0) {
                max++;
                maxV = num;
            } else if (max > 0 && maxV == num) {
                max++;
            } else if (max > 0) {
                max--;
            }
        }
        return maxV;
    }

    public static void main(String[] args){
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr));
    }
}
