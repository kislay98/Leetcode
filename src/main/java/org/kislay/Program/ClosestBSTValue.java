package org.kislay.Program;
class ClosestBSTValue {
    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        int answer = 0;
        boolean ansInit = false;
        BST curr = tree;
        while (curr != null) {
            answer = findClosestForNode(target, curr.value, answer, ansInit);
            ansInit = true;
            if (curr.value <= target) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return answer;
    }

    static int findClosestForNode(int target, int currValue, int currAnswer, boolean ansInit) {
        if (!ansInit) {
            return currValue;
        }
        int itrationDiff = Math.abs(target - currValue);
        int diff = Math.abs(target - currAnswer);
        if (itrationDiff < diff) {
            return currValue;
        }
        return currAnswer;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ClosestBSTValue.BST bst100 = new ClosestBSTValue.BST(100);
        ClosestBSTValue.BST bstminus51 = new ClosestBSTValue.BST(-51);
        ClosestBSTValue.BST bstminus403 = new ClosestBSTValue.BST(-403);

        ClosestBSTValue.BST bst1_1 = new ClosestBSTValue.BST(1);
        ClosestBSTValue.BST bst1_2 = new ClosestBSTValue.BST(1);
        ClosestBSTValue.BST bst2 = new ClosestBSTValue.BST(2);
        ClosestBSTValue.BST bst5_1 = new ClosestBSTValue.BST(5);
        ClosestBSTValue.BST bst5_2 = new ClosestBSTValue.BST(5);
        ClosestBSTValue.BST bst10 = new ClosestBSTValue.BST(10);
        ClosestBSTValue.BST bst13 = new ClosestBSTValue.BST(13);
        ClosestBSTValue.BST bst14 = new ClosestBSTValue.BST(14);
        ClosestBSTValue.BST bst15 = new ClosestBSTValue.BST(15);
        ClosestBSTValue.BST bst22 = new ClosestBSTValue.BST(22);
        bst100.right = null;
        bst100.left = bst5_1;
        bst5_1.left = bst2;
        bst2.left = bst1_1;
        bst1_1.right = bst1_2;
        bst1_1.left = bstminus51;
        bstminus51.left = bstminus403;

        int closestValueInBst = findClosestValueInBst(bst100, -70);
        System.out.println(closestValueInBst);
    }
}