class MaxDiffBetweenNodeAndAncestor {
    static int res;
    public static int maxAncestorDiff(TreeNode root) {
        res = 0;
        if (root == null)return 0;
        dfs(root, root.val, root.val);
        return res;
    }
    
    private static void dfs(TreeNode root, int min, int max){
       if (root == null)return;
        min = Math.min(root.val, min);
        max = Math.max(root.val , max);
        res = Math.max(res, max-min);
    
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val=val;
    }
}