import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        System.out.println(inorderTraversalIterative(root));
        System.out.println(inorderTraversalRecursive(root));
    }

    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || root != null){
            while (root != null){
                s.push(root);
                root = root.left;
            }
            
            root = s.pop();
            res.add(root.val);
            
            root = root.right;
            
        }
        
        return res;
    }
    
    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private static void inorder(TreeNode node, List<Integer> res){
        if (node == null)return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}