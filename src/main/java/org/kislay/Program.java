package org.kislay
        ;
class Program {
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
        Program.BST bst100 = new Program.BST(100);
        Program.BST bstminus51 = new Program.BST(-51);
        Program.BST bstminus403 = new Program.BST(-403);

        Program.BST bst1_1 = new Program.BST(1);
        Program.BST bst1_2 = new Program.BST(1);
        Program.BST bst2 = new Program.BST(2);
        Program.BST bst5_1 = new Program.BST(5);
        Program.BST bst5_2 = new Program.BST(5);
        Program.BST bst10 = new Program.BST(10);
        Program.BST bst13 = new Program.BST(13);
        Program.BST bst14 = new Program.BST(14);
        Program.BST bst15 = new Program.BST(15);
        Program.BST bst22 = new Program.BST(22);
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