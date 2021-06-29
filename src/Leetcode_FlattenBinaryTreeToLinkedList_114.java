public class Leetcode_FlattenBinaryTreeToLinkedList_114 {

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

    public static class Pair{
        TreeNode root;
        TreeNode leaf;

        Pair(){}

        Pair(TreeNode root, TreeNode leaf){
            this.leaf = leaf;
            this.root = root;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, new TreeNode(6)), new TreeNode(4, new TreeNode(10), null)), new TreeNode(5, null, new TreeNode(7)));
        traversePreOrder(root);

        while(root != null){
            System.out.println(root.val);
            System.out.println(root.left);
            root = root.right;
        }
    }

    public static Pair traversePreOrder(TreeNode node){
        if(node == null) return null;

        Pair leftSide = traversePreOrder(node.left);
        Pair rightSide = traversePreOrder(node.right);

        Pair p = new Pair();
        if(leftSide == null && rightSide == null){
            p.leaf = node;
        }
        else if(leftSide != null && rightSide != null){
            leftSide.leaf.right = rightSide.root;
            node.right = leftSide.root;
            p.leaf = rightSide.leaf;
        }
        else if(leftSide == null){
            node.right = rightSide.root;
            p.leaf = rightSide.leaf;
        }
        else{
            node.right = leftSide.root;
            p.leaf = leftSide.leaf;
        }

        node.left = null;
        p.root = node;
        return p;
    }
}
