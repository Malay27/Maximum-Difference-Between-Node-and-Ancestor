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
    public static int ans;
    public int maxAncestorDiff(TreeNode root) {
        ans=0;
        solve(root,0,Integer.MAX_VALUE);
        return ans;
    }
    public static void solve(TreeNode root,int max,int min){
        if(root==null) return;
        if(root.left==null && root.right==null){
            min=Math.min(min,root.val);
            max=Math.max(max,root.val);
            ans=Math.max(ans,Math.abs(min-max));
            return;
        }
        min=Math.min(min,root.val);
        max=Math.max(max,root.val);
        solve(root.left,max,min);
        solve(root.right,max,min);
    }
}
