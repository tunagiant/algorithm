package other;

public class tree_traversal {

	public static void main(String[] args) {
		
		LinkedTree tree = new LinkedTree();
		
		TreeNode n7 = tree.makeBT(null, 'D', null);
		TreeNode n6 = tree.makeBT(null, 'C', null);
		TreeNode n5 = tree.makeBT(null, 'B', null);
		TreeNode n4 = tree.makeBT(null, 'A', null);
		TreeNode n3 = tree.makeBT(n6, '/', n7);
		TreeNode n2 = tree.makeBT(n4, '*', n5);
		TreeNode n1 = tree.makeBT(n2, '-', n3);
		
		System.out.print("\nPreorder : ");
		tree.preorder(n1);
		
		System.out.print("\nInorder : ");
		tree.inorder(n1);
		
		System.out.print("\nPostorder : ");
		tree.postorder(n1);

	}

	private static class TreeNode {
		Object data;
		TreeNode left;
		TreeNode right;

		public TreeNode(Object data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}
	
	private static class LinkedTree {
		public TreeNode makeBT(TreeNode bt1, Object data, TreeNode bt2) {
			TreeNode root = new TreeNode(data);
			root.left = bt1;
			root.right = bt2;
			return root;
		}
		
		public void preorder(TreeNode root) {
			if (root != null) {
				System.out.print(root.data + " ");
				preorder(root.left);
				preorder(root.right);
			}
		}
		
		public void inorder(TreeNode root) {
			if (root != null) {
				inorder(root.left);
				System.out.print(root.data + " ");
				inorder(root.right);
			}
		}
		
		public void postorder(TreeNode root) {
			if (root != null) {
				postorder(root.left);
				postorder(root.right);
				System.out.print(root.data + " "); 
			}
		}
		
		
	}

}
