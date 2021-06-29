import java.util.ArrayList;
import java.util.List;

public class Leetcode_BinaryTreeRightSideView_199 {

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
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(5, new TreeNode(4, new TreeNode(3), null), new TreeNode(6))));
        List<Integer> right = rightSideView(root);
        System.out.println(right);
    }

    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        if (root.right != null) {
            right = rightSideView(root.right);
        }

        if (root.left != null) {
            left = rightSideView(root.left);
        }

        if (left.size() != 0 && right.size() != 0) {
            if (left.size() > right.size()) {
                //copy
                for (int i = right.size(); i < left.size(); i++)
                    right.add(left.get(i));

            }
            right.add(0, root.val);
            return right;
        } else if (left.size() == 0) {
            right.add(0, root.val);
            return right;
        } else {
            left.add(0, root.val);
            return left;
        }
    }
}
