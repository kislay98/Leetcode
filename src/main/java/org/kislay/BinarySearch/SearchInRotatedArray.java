package org.kislay.BinarySearch;

import java.util.stream.IntStream;

class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length <= 2) {
            return searchArrayLessThanTwo(0, length-1, nums, target);
        }
        int start  = 0;
        int end  = length - 1;
        int mid;
        while (start < end) {
            if (end - start <= 2) {
                return searchArrayLessThanTwo(start, end, nums, target);
            }
            mid = start + (end - start)/2;
            if (nums[start] < nums[mid] && nums[start] <= target && nums[mid] >= target) {
                end = mid;
            } else if (nums[start] < nums[mid]) {
                start = mid;
            } else if (target > nums[mid] && target <= nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return -1;
    }

    int searchArrayLessThanTwo(int start, int end, int[] nums, int target) {
        if (start > end) return -1;
        return  IntStream.range(0, nums.length).filter(i -> nums[i] == target).findFirst().orElse(-1);
    }

    public static void main(String[] args) {
        SearchInRotatedArray searchInRotatedArray = new SearchInRotatedArray();
        searchInRotatedArray.search(new int[]{1, 3}, 2);
    }

}
