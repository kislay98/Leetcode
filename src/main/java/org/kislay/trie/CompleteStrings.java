package org.kislay.trie;

import java.util.HashMap;
import java.util.Map;

class CompleteStrings {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }


    public static String completeString(int n, String[] a) {
        TrieNode root = new TrieNode();
        constructTrie(root, a);
        return getString(n, a, root);
    }

    private static void constructTrie(TrieNode root, String[] a) {
        for (String s : a) {
            TrieNode node = root;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                }
                node = node.children.get(c);
            }
            node.children.put('*', null);
        }
    }

    private static String getString(int n, String[] a, TrieNode root) {
        long maxLength = -1;
        String maxLengthString = "";
        for (int i = 0; i < n; i++) {
            String s = a[i];
            TrieNode node = root;
            long currentLength = 0;
            int j = 0;
            for (; j < s.length(); j++) {
                if (node.children.containsKey(s.charAt(j)) && node.children.get(s.charAt(j)).children.containsKey('*')) {
                    currentLength ++;
                } else {
                    break;
                }
                node = node.children.get(s.charAt(j));
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxLengthString = s.substring(0, j);
            }
        }
        return maxLengthString;
    }

    public static void main(String[] args) {
        CompleteStrings completeStrings = new CompleteStrings();
        System.out.println(completeStrings.completeString(6, new String[] { "n", "ni", "nin", "ninj", "ninja", "ning" }));
        System.out.println(completeStrings.completeString(2, new String[] { "ab", "bc"}));
        System.out.println(completeStrings.completeString(2, new String[] { "g", "a" ,"ak",  "szhkb", "hy"}));

//
    }

}
