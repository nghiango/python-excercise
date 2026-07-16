import java.util.*;

public class FindHeight {

  static class Node {
    int id;
    Node left;
    Node right;
    Node parent;

    int leftSubtreeHeight = -1;
    int rightSubtreeHeight = -1;
    int treeHeightIfRootedHere = -1;

    Node(int id) {
      this.id = id;
    }
  }

  public static void main(String[] args) {
    // Build sample tree:
    //       0
    //      / \
    //     1   2
    //        / \
    //       3   4

    Node[] nodes = new Node[5];
    for (int i = 0; i < 5; i++) nodes[i] = new Node(i);

    nodes[0].left = nodes[1]; nodes[1].parent = nodes[0];
    nodes[0].right = nodes[2]; nodes[2].parent = nodes[0];
    nodes[2].left = nodes[3]; nodes[3].parent = nodes[2];
    nodes[2].right = nodes[4]; nodes[4].parent = nodes[2];

    Node root = nodes[0];

    // Step 1: Bottom-up - compute left/right subtree heights
    computeSubtreeHeights(root);

    // Step 2: Top-down - reroot and compute tree height at each node
    rerootAndComputeHeight(root, 0);

    // Output result
    for (Node node : nodes) {
      System.out.println("Node " + node.id + ":");
      System.out.println("  Left Subtree Height = " + node.leftSubtreeHeight);
      System.out.println("  Right Subtree Height = " + node.rightSubtreeHeight);
      System.out.println("  Tree Height if Rooted Here = " + node.treeHeightIfRootedHere);
    }
  }

  // Step 1: Compute height of subtree for each node
  static int computeSubtreeHeights(Node node) {
    if (node == null) return -1;

    node.leftSubtreeHeight = computeSubtreeHeights(node.left);
    node.rightSubtreeHeight = computeSubtreeHeights(node.right);

    return Math.max(node.leftSubtreeHeight, node.rightSubtreeHeight) + 1;
  }

  // Step 2: Reroot tree and compute height from each node's perspective
  static void rerootAndComputeHeight(Node node, int heightFromParent) {
    if (node == null) return;

    // Height of tree rooted at this node is max of:
    // - parent contribution
    // - max of child subtree heights + 1 (edge to child)
    node.treeHeightIfRootedHere = Math.max(
        heightFromParent,
        Math.max(node.leftSubtreeHeight + 1, node.rightSubtreeHeight + 1)
    );

    // Reroot to left child
    if (node.left != null) {
      int siblingHeight = node.rightSubtreeHeight >= 0 ? node.rightSubtreeHeight + 1 : 0;
      int newParentHeight = Math.max(heightFromParent, siblingHeight) + 1;
      rerootAndComputeHeight(node.left, newParentHeight);
    }

    // Reroot to right child
    if (node.right != null) {
      int siblingHeight = node.leftSubtreeHeight >= 0 ? node.leftSubtreeHeight + 1 : 0;
      int newParentHeight = Math.max(heightFromParent, siblingHeight) + 1;
      rerootAndComputeHeight(node.right, newParentHeight);
    }
  }
}
