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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        bfs.add(root);

        while(!bfs.isEmpty()){
            int layerSize = bfs.size();
            List<Integer> layer = new ArrayList<>();
            for(int i = 0; i < layerSize; i++){
                TreeNode tmpNode = bfs.poll();
                if(tmpNode != null){
                    layer.add(tmpNode.val);
                    bfs.add(tmpNode.left);
                    bfs.add(tmpNode.right);
                }
            }
            if(layer.size() > 0)
                res.add(layer);
        }
        return res;
    }
}
