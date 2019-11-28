import java.util.ArrayList;
import java.util.Stack;

public class TraverseBinaryTree {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        TreeNode node = root;

        while (node != null || stack2.size() > 0) {
            while (node != null) {
                stack1.push(node);
                stack2.push(node);
                node = node.right;
            }

            if (stack2.size() > 0) {
                node = stack2.pop();
                node = node.left;
            }
        }

        while (stack1.size() > 0) {
            result.add(stack1.pop().val);
        }

        return result;
    }

    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
        // 先序的“根-左-右”改为“根-右-左”再逆置
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> tempStack = new Stack<Integer>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            tempStack.push(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        while (!tempStack.isEmpty()) {
            result.add(tempStack.pop());
        }

        return result;
    }

    // 维护一个栈，因为入栈顺序按照根右左进行入栈，因此首先将根出栈，然后出栈左子节点
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

        }

        return result;
    }
}
