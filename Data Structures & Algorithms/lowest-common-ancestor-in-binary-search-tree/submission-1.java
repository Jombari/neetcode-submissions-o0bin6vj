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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode tmpNode = root;
        while((tmpNode.val < p.val && tmpNode.val < q.val) || (tmpNode.val > p.val && tmpNode.val > q.val)) {
            if(tmpNode.val < p.val && tmpNode.val < q.val)
                tmpNode = tmpNode.right;
            else if (tmpNode.val > p.val && tmpNode.val > q.val)
                tmpNode = tmpNode.left;
        }
            return tmpNode;
    }
}
