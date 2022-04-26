package array.day2;

public class DuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicateModifyingArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            num = Math.abs(num);
            if (nums[num] > 0) nums[num] = -nums[num];
            else return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        DuplicateNumber obj = new DuplicateNumber();
        int[] arr = {1, 2, 2, 3, 5, 4};
        System.out.println(obj.findDuplicate(arr));
        System.out.println(obj.findDuplicateModifyingArray(arr));
    }


}
