import java.util.Stack;

public class Tree {
    public static void main(String[] args) {
        //        5
        //       / \
        //      4   2
        //     / \   \
        //    1   6   3
        //           /
        //          7

        Node root = new Node(5,
                new Node(4,
                        new Node(1), new Node(6)),
                new Node(2,
                        null, new Node(3,
                        new Node(7), null)));

        System.out.println(sumLeaves(root));
    }

    public static class Node {
        int value;
        Node leftChild;
        Node rightChild;

        Node(int value, Node leftChild, Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        Node(int value) {
            this.value = value;
        }
    }

    public static int sumLeaves(Node root) {
        int sum = 0;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node.leftChild != null) {
                stack.push(node.leftChild);
            }

            if (node.rightChild != null) {
                stack.push(node.rightChild);
            }

            if (node.leftChild == null && node.rightChild == null) {
                sum += node.value;
            }
        }
        return sum;
    }

}
