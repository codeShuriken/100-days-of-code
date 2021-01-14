class SumRootToLeafNumbers {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return total;
    }
    
    public void dfs(TreeNode root, int curSum){
        if (root == null)return;
        curSum = (curSum * 10) + root.val;
        if (root.left == null && root.right == null){
            total += curSum;
            return;
        }
        dfs(root.left, curSum);
        dfs(root.right, curSum);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { 
        this.val = val; 
    }
}