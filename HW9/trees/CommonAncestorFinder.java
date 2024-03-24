package trees;

public class CommonAncestorFinder {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		// If p and q are on the right of the root, recursively call the function to the right
		if(p.val > root.val && q.val > root.val)
		{
			return lowestCommonAncestor(root.right, p, q);
		}
		
		// If p and q are on the left of the root, recursively call the function on the lest
		if(p.val < root.val && q.val < root.val)
		{
			return lowestCommonAncestor(root.left, p, q);
		}
		
		// If neither are true, return the root. It must be the lowest common ancestor
		return root;
	}
	
	public static void main(String[] args)
	{
		/*
		 * 4
		 * 3 8
		 * 1   5 9
		 * 
		 * test 3,1 and 1,5
		 */
		CommonAncestorFinder finder = new CommonAncestorFinder();
		
		TreeNode root = new TreeNode(4);
		TreeNode threeNode = new TreeNode(3);
		root.left = threeNode;
		root.right = new TreeNode(8);
		TreeNode oneNode = new TreeNode(1);
		root.left.left = oneNode;
		TreeNode fiveNode = new TreeNode(5);
		root.right.left = fiveNode;
		root.right.right = new TreeNode(9);
		
		System.out.println(finder.lowestCommonAncestor(root, oneNode, threeNode).val);
		System.out.println(finder.lowestCommonAncestor(root, oneNode, fiveNode).val);
		System.out.println(finder.lowestCommonAncestor(root, root.right, root.right.right).val);

	}
}
