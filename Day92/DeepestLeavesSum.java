import java.util.LinkedList;
import java.util.Queue;

class DeepestLeavesSum {
    public int deepestLeavesSumBFS(TreeNode root) {
        if (root == null)return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()){
            int size = q.size();
            sum=0 ;
            for (int i = 0; i < size; ++i){
                TreeNode node = q.poll();
                sum+=node.val;
                if (node.left!=null)q.offer(node.left);
                if (node.right!=null)q.offer(node.right);
            }
        }
       return sum;
    }
    
    public int deepestLeavesSumDFS(TreeNode root) {
        int depth = depth(root);
        return sum(root, depth);
    }
    
    public int sum(TreeNode root, int depth){
        if (root == null)return 0;
        else if (depth == 1)return root.val;
        else return sum(root.left, depth -1) + sum(root.right, depth - 1);
    }
    
    public int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        else return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val=val;
    }
}