package trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTreeTraverser {
	public List<List<Integer>> levelOrder(TreeNode root)
	{
		List<List<Integer>> levels = new ArrayList<>();
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		
		if(root == null) return null;
		nodeQueue.add(root);
		
		while(!nodeQueue.isEmpty())
		{
			ArrayList<Integer> queueLevel = new ArrayList<Integer>();
			int levelSize = nodeQueue.size();
			for(int i = 0; i < levelSize; i++)
			{
				TreeNode currentNode = nodeQueue.remove();
				queueLevel.add(currentNode.val);
				if(currentNode.left != null) nodeQueue.add(currentNode.left);
				if(currentNode.right != null) nodeQueue.add(currentNode.right);
			}
			
			levels.add(queueLevel);
			
			
		}
		
		return levels;
	}
	
	public static void main(String[] args)
	{
		LevelOrderTreeTraverser lot = new LevelOrderTreeTraverser();
		
		TreeNode root = new TreeNode(4);
		TreeNode threeNode = new TreeNode(3);
		root.left = threeNode;
		root.right = new TreeNode(8);
		TreeNode oneNode = new TreeNode(1);
		root.left.left = oneNode;
		TreeNode fiveNode = new TreeNode(5);
		root.right.left = fiveNode;
		root.right.right = new TreeNode(9);
		
		List<List<Integer>> test = lot.levelOrder(root);
		System.out.println(test);
		
		
		TreeNode nodeRoot = new TreeNode(1);
		TreeNode nodeTwo = new TreeNode(2);
		TreeNode nodeThree = new TreeNode(3);
		TreeNode nodeFour = new TreeNode(4);
		TreeNode nodeEight = new TreeNode(8);
		TreeNode nodeFive = new TreeNode(5);
		TreeNode nodeSix = new TreeNode(6);
		nodeRoot.left = nodeTwo;
		nodeRoot.right = nodeEight;
		nodeTwo.left = nodeThree;
		nodeTwo.right = nodeFour;
		nodeFour.left = nodeFive;
		nodeEight.right = nodeSix;
		test = lot.levelOrder(nodeRoot);
		System.out.println(test);
	}
}
