package org.kislay.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

    List<List<Integer>> validSolutions = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int maxLength = nums.length;
        backtrack(nums, new ArrayList<>(), new HashSet<>(), maxLength);
        return validSolutions;
    }

    private void backtrack(int[] nums, List<Integer> currentSol, Set<Integer> usedIndex, int maxLength) {
        if (currentSol.size() == maxLength) {
            validSolutions.add(new ArrayList<>(currentSol));
        } else {
            for (int i = 0; i < maxLength; i++) {
                if (usedIndex.contains(i)) {
                    continue;
                }
                currentSol.add(nums[i]);
                usedIndex.add(i);
                backtrack(nums, currentSol, usedIndex, maxLength);
                currentSol.remove(currentSol.size()-1);
                usedIndex.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.permute(new int[]{1,2,3});
    }

}
