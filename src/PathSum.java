
 //Definition for a binary tree node.
   class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        int newSum = sum - root.val;

        if(root.left == null && root.right == null) return newSum == 0;

        return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
    }
}