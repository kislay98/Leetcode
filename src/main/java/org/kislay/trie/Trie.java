package org.kislay.trie;

import java.util.HashMap;
import java.util.Map;

class Trie {
    Map<Character, Trie> children;

    public Trie() {
        this.children = new HashMap<>();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        if (!this.children.containsKey('*')) {
            this.children.put('*', new Trie());
        }
        Trie node = this.children.get('*');
        for (Character ch: word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new Trie());
            }
            node = node.children.get(ch);
        }
        node.children.put('#', null);
    }

    public boolean search(String word) {
        boolean isPresent = true;
        Trie node = this.children.getOrDefault('*', new Trie());
        for (Character c: word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                isPresent = false;
                break;
            }
            node = node.children.get(c);
        }
        if (isPresent && !node.children.containsKey('#')) {
            isPresent = false;
        }
        return isPresent;
    }

    public boolean startsWith(String prefix) {
        boolean isPrefix = true;
        Trie node = this.children.getOrDefault('*', new Trie());
        for (Character c: prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                isPrefix = false;
                break;
            }
            node = node.children.get(c);
        }
        return isPrefix;
    }
}
