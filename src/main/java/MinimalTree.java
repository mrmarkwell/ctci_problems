import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class MinimalTree {

    public BinTreeNode createBinaryTreeFromSortedArray(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            return null;
            }
        int start = 0;
        int end = arr.size() - 1;
        int mid = end / 2;
        BinTreeNode root = new BinTreeNode(arr.get(mid));
        _addChildren(root, arr, start, mid, end);
        return root;
    }

    private void _addChildren(BinTreeNode parent, List<Integer> arr, int start, int par_idx, int end) {
        int left_idx = ((par_idx - start)/2) + start;
        int right_idx = (int) Math.ceil(((double)(end - par_idx))/2.0 + par_idx);
        if (left_idx != par_idx) {
            parent.left = new BinTreeNode(arr.get(left_idx));
            _addChildren(parent.left, arr, start, left_idx, par_idx - 1);
        }
        if (right_idx != par_idx) {
            parent.right = new BinTreeNode(arr.get(right_idx));
            _addChildren(parent.right, arr, par_idx + 1, right_idx, end);
        }
    }

    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        MinimalTree mt = new MinimalTree();

        BinTreeNode tree = mt.createBinaryTreeFromSortedArray(test1);

        System.out.println(tree);
        List<Integer> test2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        tree = mt.createBinaryTreeFromSortedArray(test2);
        System.out.println(tree);

        List<Integer> test3 = Arrays.asList(1);

        tree = mt.createBinaryTreeFromSortedArray(test3);
        System.out.println(tree);
    }

}

