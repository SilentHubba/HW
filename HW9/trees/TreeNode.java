package trees;

public class TreeNode {
	
	int val;
	TreeNode left;
	TreeNode right;
	
	TreeNode(){}
	
	TreeNode(int val)
	{
		this.val = val;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right)
	{
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	/*
	void insertNode(TreeNode nodeToInsert)
	{
		if(nodeToInsert.val >= val)
		{
			if(right == null)
			{
				right = nodeToInsert;
			}
			else
			{
				right.insertNode(nodeToInsert);
			}
		}
		else
		{
			if(left == null)
			{
				left = nodeToInsert;
			}
			else
			{
				left.insertNode(nodeToInsert);
			}
		}
	}*/
	
	
}
