package binary_tree;

import tree.NodeBT;
import utils.Common;

public class CheckLeavesLevel {
	public static void main(String[] args) {
		NodeBT root = BinaryTree.initialize();
		root.right.left = new NodeBT(15);

		int leftMostHeight = leftMostHeight(root);
		Common.println(leftMostHeight);

		Level level = new Level();
		boolean isLevelEqual = checkLeaveLevel(root, leftMostHeight, level);
		// Sum tree
	}

	class Level {
		int level;
	}

	private static int checkLeaveLevel(NodeBT root, int leftMostHeight, Level level) {
		if (root == null)
			return 0;

		if (root.left == null && root.right == null)
			return 1;
		
		checkLeaveLevel(root.left, leftMostHeight, level.level + 1);
		checkLeaveLevel(root.right, leftMostHeight, level.level + 1);
		
		return false;
	}

	
	static int leftMostHeight(NodeBT root) {
		if (root == null)
			return 0;
		if (root.left != null)
			return 1 + leftMostHeight(root.left);
		else// if (root.right == null)
			return 1 + leftMostHeight(root.right);

	}
}
