package mytx.class08;

public class Code_TrieTree {
    public static class Node {
        int pass;
        int end;
        Node[] next;

        public Node() {
            this.end = 0;
            this.pass = 0;
            this.next = new Node[26];
        }

        //note: 构建数据结构 .我直接用的Trie ，代码里用的 Trie ->Node ，更合理。整体是trie ,里边每个元素是node
       /* public Trie() {
            this.end = 0;
            this.pass = 0;
            this.next = new Node[26];
        }*/
        public class Trie {
            Node root;

            public Trie() {
                this.root = new Node();
            }

            public void insert(String str) {
                if (str == null && str.length() == 0) {
                    return;
                }
                char[] chars = str.toCharArray();
                Node cur = this.root;
                cur.pass++;
                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i] - 'a';
                    if (cur.next[index] == null) {
                        cur.next[index] = new Node();
                    }
                    cur = cur.next[index];
                    cur.pass++;
                }
                cur.end++;
            }

            public void delete(String str) {
                if (str == null && str.length() == 0) {
                    return;
                }
                char[] chars = str.toCharArray();
                Node cur = this.root;
                cur.pass--;
                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i] - 'a';
                    if (cur.next[index] == null) {
                        return;
                    }
                    cur.pass--;
                    cur = cur.next[index];
                }
                cur.end--;
            }

            //返回最后一个节点的pass
            public int getPreCount(String str) {
                if (str == null && str.length() == 0) {
                    return 0;
                }
                char[] chars = str.toCharArray();
                Node cur = this.root;
                for (int i = 0; i < chars.length; i++) {
                    int index = chars[i] - 'a';
                    if (cur.next[index] == null) {
                        return 0;
                    }
                    cur = cur.next[index];
                }
                return cur.pass;
            }
        }
    }
}
