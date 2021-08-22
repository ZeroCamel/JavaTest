package algorithm;

/**
 * LeetCode 1480 一维数组的和
 * 第1遍 执行用时0ms 内存消耗 38.3Mb
 */
public class runningFun {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] nums2 = {1, 1, 1, 1, 1};
        int[] nums3 = {3, 1, 2, 10, 1};
        int[] numsSum = mainLogic(nums3);
        for (int i = 0; i < numsSum.length; i++) {
            System.out.println(numsSum[i]);
        }
    }

    public static int[] mainLogic(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[i] = nums[i];
                continue;
            }
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}


