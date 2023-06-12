package hot;

import java.util.HashMap;
import java.util.Map;

/**
 * 并查集
 */
public class UnionFind {
    private int count;
    private Map<Integer, Integer> parent; // (curr, leader)

    public UnionFind(int[] arr) {
        parent = new HashMap<>();
        for (int v : arr) {
            parent.put(v, v); // 初始时，各自为战，自己是自己的领队
        }

        count = parent.size(); // 而非 arr.length，因可能存在同 key 的情况
    }

    // 结盟
    public void union(int p, int q) {
        // 不只是 p 与 q 结盟，而是整个 p 所在队伍 与 q 所在队伍结盟
        // 结盟需各领队出面，而不是小弟出面
        Integer rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) return;
        if (rootP == null || rootQ == null) return;

        // 结盟
        parent.put(rootP, rootQ); // 谁大听谁
        // 应取 max，而本题已明确 p < q 才可这么写
        // 当前写法有损封装性，算法题可不纠结

        count--;
    }

    // 查找领队
    public Integer find(int p) {
        if (!parent.containsKey(p))
            return null;

        // 递归向上找领队
        int root = p;
        while (root != parent.get(root))
            root = parent.get(root);

        // 路径压缩：扁平化管理，避免日后找领队层级过深
        while (p != parent.get(p)) {
            int curr = p;
            p = parent.get(p);
            parent.put(curr, root);
        }

        return root;
    }
}
