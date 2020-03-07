import java.util.*;

class Node {
    int val;
    Node left;
    Node right;
    Node (int val) {
        this.val = val;
    }
}
public class MirrorTree {
    public static void main(String args[]) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(2);
        node.left.left = new Node(4);
        node.left.right = new Node(3);
        node.right.left = new Node(3);
        node.right.right = new Node(3);
        System.out.println("Printing Result");
        System.out.println(isSymmetric(node));
    }
    private static boolean isSymmetric(Node root){
        boolean res = true;
        Queue<Node> nodes = new LinkedList<>();

        if (root == null) {
            return false;
        }
        nodes.add(root);
        while(!nodes.isEmpty()) {
            int count = nodes.size();
            List<Integer> levelNodes = new ArrayList<>();
            while (count > 0) {
                Node tmp = nodes.remove();
                count --;
                if (tmp.left != null) {
                    nodes.add(tmp.left);
                    levelNodes.add(tmp.left.val);
                } else {
                    levelNodes.add(-111);
                }
                if (tmp.right != null) {
                    nodes.add(tmp.right);
                    levelNodes.add(tmp.right.val);
                } else {
                    levelNodes.add(-111);
                }
            }
            if(!symmetryAtLevel(levelNodes)){
                res = false;
                break;
            }
        }
        return res;
    }
    public static boolean symmetryAtLevel (List<Integer> levelNodes) {
        if (levelNodes.size() == 1) {
            return true;
        }
        for (int i = 0; i < levelNodes.size() / 2; i++) {
            if (!(levelNodes.get(i) == levelNodes.get(levelNodes.size() - i - 1))){
                return false;
            }
        }
        return true;
    }
}
