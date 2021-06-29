import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode_BinaryTreeLevelOrderTraversal_102 {

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

    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> mQ = new ArrayDeque<>();
        Queue<TreeNode> hQ = new ArrayDeque<>();
        List<List<Integer>> finalRes = new ArrayList<>();

        mQ.add(root);

        ArrayList<Integer> res = new ArrayList<>();
        while (mQ.size() > 0) {
            TreeNode toq = mQ.poll();
            if (toq.left != null) hQ.add(toq.left);
            if (toq.right != null) hQ.add(toq.right);
            res.add(toq.val);

            if(mQ.size() == 0) {
                Queue<TreeNode> temp = mQ;
                mQ = hQ;
                hQ = temp;
                finalRes.add(res);
                res = new ArrayList<>();
            }
        }

        return finalRes;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> mQ = new ArrayDeque<>();
        List<List<Integer>> finalRes = new ArrayList<>();

        mQ.add(root);

        ArrayList<Integer> res = new ArrayList<>();
        while (mQ.size() > 0) {
            int size = mQ.size();
            while(size > 0) {
                TreeNode toq = mQ.poll();
                if (toq.left != null) mQ.add(toq.left);
                if (toq.right != null) mQ.add(toq.right);
                res.add(toq.val);
                size--;
            }

            finalRes.add(res);
            res = new ArrayList<>();
        }

        return finalRes;
    }
}
