/**
 * 树节点类
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MinDepthOfBinaryTree {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    public int run(TreeNode root)
    {
        if (root == null) {
            return 1;
        }

        int leftMinDepth = run(root.left);
        int rightMinDepth = run(root.right);

        if (root.left == null) {
            return rightMinDepth + 1;
        }

        if (root.right == null) {
            return leftMinDepth + 1;
        }

        return leftMinDepth < rightMinDepth ? leftMinDepth + 1 : rightMinDepth + 1;
    }
}
