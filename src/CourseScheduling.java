/**
 * @Author lty
 * @Date 2024/4/14 20:26
 * @Description
 */

import java.util.Arrays;

public class CourseScheduling {
    public static int maxValue(int[][] courses) {
        // 按照结束时间对课程进行排序
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        int n = courses.length;
        int[] endTimes = new int[n];
        int[] prefixSum = new int[n];

        // 存储课程的结束时间和前缀和
        for (int i = 0; i < n; i++) {
            endTimes[i] = courses[i][1];
            prefixSum[i] = courses[i][2] + (i > 0 ? prefixSum[i - 1] : 0);
        }

        int maxValue = 0;

        for (int i = 0; i < n; i++) {
            int currentValue = courses[i][2];

            // 二分搜索找到与当前课程不冲突的最大价值
            int prevIndex = binarySearch(endTimes, courses[i][0], 0, i - 1);
            int prevValue = prevIndex >= 0 ? prefixSum[prevIndex] : 0;

            // 更新最大价值
            maxValue = Math.max(maxValue, currentValue + prevValue);
        }

        return maxValue;
    }

    // 二分搜索找到不大于目标值的最大索引
    private static int binarySearch(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static int two(int[][] nums) {
        // 按照结束时间排序
        Arrays.sort(nums, (int[] a, int[] b) -> a[1] - b[1]);
        // 以时间i结束
        int[] dp = new int[nums[nums.length - 1][1] + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i][1]] = Math.max(dp[nums[i][0]] + nums[i][2], dp[nums[i][1]]);
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] courses = {
                {1, 5, 50},
                {1, 4, 20},
                {2, 3, 30}
        };

        int maxValue = two(courses);
        int maxValue2 = maxValue(courses);
        System.out.println("Maximum value: " + maxValue);
        System.out.println("Maximum value: " + maxValue2);
    }
}
