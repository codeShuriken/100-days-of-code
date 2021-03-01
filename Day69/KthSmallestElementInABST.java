import java.util.Stack;

class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if (root ==null)return 0;
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || root != null){
            while (root != null){
                s.push(root);
                root = root.left;
            }
            
            root = s.pop();
            if (--k == 0){
                return root.val;
            }
            
            root = root.right;
        }
        throw new IllegalArgumentException();
    }
}

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val=val;
    }
}