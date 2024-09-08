package org.kislay.BinarySearch;

class BinarySearch {

    public int search(int[] nums, int target) {
        int index = -1;
        int start  = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > target)
                end = mid - 1;
            else if (nums[mid] < target)
                start = mid + 1;
            else {
                index = mid;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(new int[]{-1,0,3,5,9,12}, 2));
    }

}
