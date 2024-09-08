package org.kislay;

public class ProductOfArrayExceptItself {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int right = 1;
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        for(int i = length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right*nums[i];
        }
        return result;
    }

    public int[] productExceptSelfUsingExtraMem(int[] nums) {
        int length = nums.length;
        int[] prefixProduct = new int[length];
        int[] suffixProduct = new int[length];
        int[] result = new int[length];
        prefixProduct[0] = 1;
        suffixProduct[length-1] = 1;
        for (int i = 1; i < length; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }
        for(int i = length - 2; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i+1] * nums[i+1];
        }

        for (int i = 0; i < length; i++) {
            result[i] = prefixProduct[i] * suffixProduct[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptItself exceptItself = new ProductOfArrayExceptItself();
        exceptItself.productExceptSelf(new int[]{1, 2, 3, 4});
    }

}
