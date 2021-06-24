package algorithms.other;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author : Avizii
 * @Create : 2021.03.12
 */
public class DisjointSet {

    private int count;
    private int[] parent;

    public DisjointSet() {}

    public void makeSet(int n) {
        count = n;
        parent = new int[n];
        IntStream.range(0, n).forEach(i -> parent[i] = i);
    }

    public void unionSet(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) return;
        parent[xRoot] = yRoot;
        count--;
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int getCount() {
        return count;
    }
}
