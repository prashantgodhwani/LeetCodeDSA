package June_Challenge;

public class Leetcode_LowestCommonAncestor_30June {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode o = new TreeNode(1);
        TreeNode t = new TreeNode(2, o, null);
        TreeNode root = new TreeNode(3, t, null);
        TreeNode res = lowestCommonAncestor(root, t, o);
        System.out.println(res.val);
    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == p || root == q || root == null) return root;

        // search p and q from left and right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // from root's left & right we found both p and q, so root is the LCA
        if (left != null && right != null) return root;

        // left is not null means from left's left & right we found both q and q
        // so left is the LCA, otherwise, right is the answer
        else return left != null ? left : right;
    }
}
