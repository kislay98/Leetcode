package org.kislay;

import java.util.HashMap;
import java.util.Map;

public class UnionFind<T> {

    private Map<T, T> parent;
    private Map<T, Integer> rank;

    public UnionFind() {
        this.parent = new HashMap<>();
        this.rank = new HashMap<>();
    }

    public void addElement(T element) {
        if (!parent.containsKey(element)) {
            parent.put(element, element);
            rank.put(element, 0);
        }
    }

    public T find(T element) {
        if (parent.get(element).equals(element)) {
            return element;
        }
        return find(parent.get(element));
    }

    public void union(T x, T y) {
        T rootX = find(x);
        T rootY = find(y);
        if (rootY != rootX) {
            Integer yRank = rank.get(rootY);
            Integer xRank = rank.get(rootX);
            if (xRank > yRank) {
                parent.put(rootY, rootX);
            } else if (xRank < yRank) {
                parent.put(rootX, rootX);
            } else {
                parent.put(rootX, rootY);
                rank.put(rootY, rank.get(rootY) + 1);
            }
        }
    }

}
