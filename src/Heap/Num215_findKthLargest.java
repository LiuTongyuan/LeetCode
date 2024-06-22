package Heap;

import java.util.PriorityQueue;

/**
 * @Author lty
 * @Date 2024/1/4 11:16
 * @Description 215. 数组中的第K个最大元素
 */
public class Num215_findKthLargest {
    // public static void main(String[] args) {
    //     new Num215_findKthLargest().findKthLargest(new int[]{99, 99}, 1);
    // }

    public int findKthLargest(int[] nums, int k) {
        return m2(nums, k);
    }

    /**
     * 思路一：利用小顶堆，留下最大的k个
     *
     * @param nums
     * @param k
     * @return
     */
    public int m1(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            heap.add(nums[i]);
            heap.poll();
        }
        return heap.poll();
    }


    /**
     * 思路二：利用快排，不断缩小第k大所在的范围
     *
     * @param nums
     * @param k
     * @return
     */
    public int m2(int[] nums, int k) {
        return quickSearch(nums, 0, nums.length-1, nums.length - k);
    }

    public int quickSearch(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int key = nums[end];
        int l = start, r = end;
        while (l < r) {
            if (nums[l] > key) {
                nums[r--] = nums[l];
                nums[l] = nums[r];
            } else {
                l++;
            }
        }
        nums[l] = key;

        return l > k ? quickSearch(nums, start, l - 1, k) : quickSearch(nums, l, end, k);
    }
}
