package June_Challenge;

public class Leetcode_RangeSumQueryMutable {

    static class SegmentTreeNode {
        int start;
        int end;
        int data;
        SegmentTreeNode left;
        SegmentTreeNode right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            data = 0;
        }
    }

    public static SegmentTreeNode construct(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.data = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            root.left = construct(nums, start, mid);
            root.right = construct(nums, mid + 1, end);
            root.data = root.left.data + root.right.data;
        }

        return root;
    }

    public static void updateSegmentTree(SegmentTreeNode node, int pos, int val){
        if(node.start == node.end){
            node.data = val;
            return;
        }

        int mid = node.start + (node.end - node.start) / 2;

        if(pos <= mid){
            updateSegmentTree(node.left, pos, val);
        }else{
            updateSegmentTree(node.right, pos, val);
        }

        node.data = node.left.data + node.right.data;
    }

    public int sumRange(SegmentTreeNode node, int start, int end){
        if(node.start == start && node.end == end){
            return node.data;
        }

        int mid = node.start + (node.end - node.start) / 2;

        //both start and end are in left subtree - go left
        if(end <= mid){
            return sumRange(node.left, start, end);
        }
        ///both start and end are in right subtree -  go right
        else if(mid + 1<= start){
            return sumRange(node.right, start, end);
        }
        //start and end are in different subtrees - go in both directions
        else{
            return sumRange(node.left, start, mid) + sumRange(node.right, mid + 1, end);
        }
    }
}
