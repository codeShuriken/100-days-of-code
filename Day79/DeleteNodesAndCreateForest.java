import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class DeleteNodesAndCreateForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i: to_delete){
            set.add(i);
        }
        helper(root, set, res);
        
        if (!set.contains(root.val)){
            res.add(root);
        }
        
        return res;
    }
    
    private TreeNode helper(TreeNode root, Set<Integer> set, List<TreeNode> res){
        if (root == null)return null;
        root.left = helper(root.left, set, res);
        root.right = helper(root.right, set, res);
        if (set.contains(root.val)){
            if (root.left != null)res.add(root.left);
            if (root.right != null) res.add(root.right);
            return null;
        }
        return root;
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }