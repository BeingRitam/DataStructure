package tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import org.junit.jupiter.api.Test;

/**
 * BinaryTreeTraversal
 *
 * @author Ritam Das
 * @since 09/01/23
 **/
public class BinaryTreeTraversal {
  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  private static List<Integer> preorderTraversalUsingStack(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Stack<TreeNode> st = new Stack<>();
    st.push(root);

    while (!st.isEmpty()) {
      TreeNode current = st.pop();
      result.add(current.val);

      if (current.right != null) {
        st.push(current.right);
      }
      if (current.left != null) {
        st.push(current.left);
      }
    }
    return result;
  }

  private static List<Integer> inOrderTraversalUsingStack(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Stack<TreeNode> st = new Stack<>();
    TreeNode current = root;

    while (!st.isEmpty() || current != null) {
      while (current != null) {
        st.push(current);
        current = current.left;
      }
      current = st.pop();
      result.add(current.val);
      current = current.right;
    }
    return result;
  }

  private static int getTreeHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
  }

  private static List<Integer> breadthFirstTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    // Add the root node to the queue for processing
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      // dequeue node from processing queue ad add the node to result set
      TreeNode current = queue.poll();
      result.add(current.val);

      // Once parent node is processed, enqueue its left and right child to queue so it process
      // Once the same level nodes finished processing
      if (current.left != null) {
        queue.offer(current.left);
      }
      if (current.right != null) {
        queue.offer(current.right);
      }
    }
    return result;
  }


  @Test
  protected void testTreeTraversal() {
            /*   5
                / \
               3   -2
              / \  / \
             4   6 7  31
            /          \
           61          33
                       /
                      54   */
    // Preorder: 5, 3, 4, 61, 6, -2, 7, 31, 33, 54
    // Inorder: 61, 4, 3, 6, 5, 7, -2, 31, 54, 33
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(-2);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(31);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(6);
    root.left.left.left = new TreeNode(61);
    root.right.right.right = new TreeNode(33);
    root.right.right.right.left = new TreeNode(54);
    assertIterableEquals(Arrays.asList(5, 3, -2, 4, 6, 7, 31, 61, 33, 54),
        breadthFirstTraversal(root));
    assertIterableEquals(Arrays.asList(5, 3, 4, 61, 6, -2, 7, 31, 33, 54),
        preorderTraversalUsingStack(root));
    assertIterableEquals(Arrays.asList(61, 4, 3, 6, 5, 7, -2, 31, 54, 33),
        inOrderTraversalUsingStack(root));
    assertEquals(5, getTreeHeight(root));
  }
}
