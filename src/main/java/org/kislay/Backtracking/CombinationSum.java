package org.kislay.Backtracking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class CombinationSum {

    List<List<Integer>> validSolutions = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        candidates = IntStream.of(candidates).distinct().toArray();
        List<Integer> currentSolution = new ArrayList<>();
        int currentSolutionSize = 0;
        backtrack(currentSolution, candidates, target, 0, 0);
        return validSolutions;
    }

    void backtrack(List<Integer> currentSolution, int[] candidates, int target, int startIdx, int currentSolutionSize) {
        if (target == 0) {
            List<Integer> validSolution = new ArrayList<>(currentSolution);
            validSolution.sort(Comparator.comparing(x-> x));
            validSolutions.add(validSolution);
        } else if (target > 0) {
            for (int i = startIdx; i < candidates.length; i++) {
                currentSolution.add(candidates[i]);
                currentSolutionSize++;
                backtrack(currentSolution, candidates, target - candidates[i], i, currentSolutionSize);
                currentSolutionSize--;
                currentSolution.remove(currentSolutionSize - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,5}, 8));
    }
}
