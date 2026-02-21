class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        // Connect children
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = getNext(root.next);
            }
        }

        if (root.right != null) {
            root.right.next = getNext(root.next);
        }

        // IMPORTANT: right first
        connect(root.right);
        connect(root.left);

        return root;
    }

    private Node getNext(Node node) {
        while (node != null) {
            if (node.left != null) return node.left;
            if (node.right != null) return node.right;
            node = node.next;
        }
        return null;
    }
}