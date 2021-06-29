public class Leetcode_ConvertSortedArrayToBST_108 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
        int[] arr = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(arr);

        display(root);
    }

    private static void display(TreeNode root) {
        if(root == null) return;

        if(root.left != null) System.out.print(root.left.val);
        System.out.print(" <== " + root.val + " ==> ");
        if(root.right != null) System.out.print(root.right.val);
        System.out.println();
        display(root.left);
        display(root.right);

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        else return bstHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode bstHelper(int[] nums, int start, int end) {

        if(start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = bstHelper(nums, start, mid - 1);
        root.right = bstHelper(nums, mid + 1, end);

        return root;
    }
}
