/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Pair {
        TreeNode node;
        int dist;

        Pair(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {


        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            map.put(curr.dist, curr.node.val);

            if (curr.node.left != null) {
                q.offer(new Pair(curr.node.left, curr.dist + 1));
            }

            if (curr.node.right != null) {
                q.offer(new Pair(curr.node.right, curr.dist + 1));
            }

        }

        for (int vals : map.values()) {
            ans.add(vals);
        }

        return ans;

    }
}
