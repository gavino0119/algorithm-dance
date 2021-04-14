package tree;

/**
 * @Author yanwg
 * @Date 2021/4/14 12:58
 * @Description: 前缀树
 * Trie，又称前缀树或字典树，是一棵有根树，根节点不存储数据，其每个节点包含以下字段：
 *  指向子节点的指针数组 children。
 *  布尔字段 isEnd，表示该节点是否为字符串的结尾。
 * <p>
 * 一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * 这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    /**
     * 初始化前缀树对象
     */
    public Trie() {
        // 下一个字符
        children = new Trie[26];
        // 是否为结束字符
        isEnd = false;
    }

    /**
     * 向前缀树中插入字符串 word
     * @param word
     */
    public void insert(String word) {
        // 从第一个节点开始，可以想象成一个空节点
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            // 如果当前节点的下一个字符处还没有开辟，那就新创建一个
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            // 节点指针后移
            node = node.children[index];
        }
        // 循环结束，当前节点指向的字符为结束字符
        node.isEnd = true;
    }

    /**
     * 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
     * @param word
     * @return
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        // 字符全部匹配，且最后一个字符为结束字符
        return node != null && node.isEnd;
    }

    /**
     * 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        // 字符全部匹配
        return searchPrefix(prefix) != null;
    }

    /**
     * 抽取方法
     * @param prefix
     * @return
     */
    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            // 如果当前节点的对应字符处尚未开辟，说明没有对应的word插入
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
