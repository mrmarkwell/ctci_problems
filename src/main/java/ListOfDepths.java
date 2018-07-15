import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the
 * nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class ListOfDepths {

    public List<LinkedList<BinTreeNode>> ListOfDepths(BinTreeNode root) {
        List<LinkedList<BinTreeNode>> list = new ArrayList<>();
        int d = 0;
        if (root == null) return list;
        list.add(new LinkedList<>());
        list.get(d).add(root);
        while (list.size() >= d + 1) {
            for (BinTreeNode n : list.get(d)) {
                _addChildren(list, n, d);
            }
            d++;
        }
        return list;
    }


    private void _addChildren(List<LinkedList<BinTreeNode>> list, BinTreeNode n, int d) {
        if (n.left != null || n.right != null) {
            if (list.size() == d + 1) {
                list.add(new LinkedList<>());
            }
            if (n.left != null) {
                list.get(d + 1).add(n.left);
            }
            if (n.right != null) {
                list.get(d + 1).add(n.right);
            }
        }
    }

    public static void main(String[] args) {
        ListOfDepths sut = new ListOfDepths();

        // depth 0
        BinTreeNode root = new BinTreeNode(1);

        // depth 1
        root.left = new BinTreeNode(2);
        root.right = new BinTreeNode(3);

        // depth 1
        root.left.left = new BinTreeNode(4);
        root.left.right = new BinTreeNode(5);
        root.right.left = new BinTreeNode(6);
        root.right.right = new BinTreeNode(7);

        // depth 2
        root.left.right.left = new BinTreeNode(8);
        root.right.right.right = new BinTreeNode(9);
        root.left.right.right = new BinTreeNode(10);
        root.right.right.left = new BinTreeNode(11);


        // depth 3
        root.left.right.left.right = new BinTreeNode(12);

        // depth 4
        root.left.right.left.right.left = new BinTreeNode(13);

        List<LinkedList<BinTreeNode>> result = sut.ListOfDepths(root);

        _printLists(result);

    }

    private static void _printLists(List<LinkedList<BinTreeNode>> list) {
        int d = 0;
        for (List<BinTreeNode> l : list) {
            System.out.println("Depth " + d);
            StringBuilder stringBuilder = new StringBuilder();
            for (BinTreeNode n : l) {
                stringBuilder.append(n.value + " -> ");
            }
            System.out.println(stringBuilder.toString());
            d++;
        }
    }

}

