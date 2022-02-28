package linkedList;


public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > max)
                max = height[i];
            prefix[i] = max;
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (height[i] > max)
                max = height[i];
            suffix[i] = max;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int abs = Math.min(prefix[i], suffix[i]);

            if (abs - height[i] > 0)
                answer += abs - height[i];
        }
        return answer;
    }

    public int trap2Pointer(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1, leftMax = 0, rightMax = 0;
        int answer = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (height[l] > leftMax)
                    leftMax = height[l];
                else
                    answer += leftMax - height[l];
                l++;
            } else {
                if (height[r] > rightMax)
                    rightMax = height[r];
                else
                    answer += rightMax - height[r];
                r--;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(obj.trap2Pointer(arr));
    }

}
