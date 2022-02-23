package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class binaryTreeImplementation {
	
	private treeNode root;
	
	private class treeNode{
		private treeNode left = null;
		private treeNode rigth = null;
		private int data;
		
		public treeNode(int data) {
			this.data = data;
		}
	}
	public void createBinaryTree() {
		treeNode first = new treeNode(10);
		treeNode second = new treeNode(20);
		treeNode third = new treeNode(30);
		treeNode forth = new treeNode(40);
		treeNode fifth = new treeNode(50);
		treeNode sixth = new treeNode(60);
		treeNode seventh = new treeNode(70);
		
		root = first;
		first.left = second;
		first.rigth = third;
		second.left = forth;
		second.rigth = fifth;
		third.left = sixth;
		third.rigth = seventh;
	}
	//recursive preorder
	public void preorder(treeNode root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.rigth);
	}
	//iterative preorder
	public void preOrder() {
		if(root == null) {
			return;
		}
		Stack<treeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			treeNode temp = stack.pop();
			System.out.print(temp.data + " ");
			if(temp.rigth != null) {
				stack.push(temp.rigth);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
	}
	//recursive inorder
	public void inorder(treeNode root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.rigth);
	}
	
	//itrative inorder
	public void inOrder() {
		if(root == null) {
			return;
		}
		Stack <treeNode> stack = new Stack<>();
		treeNode temp = root;
		while(!stack.isEmpty() || temp!=null) {
			if(temp!=null) {
				stack.push(temp);
				temp = temp.left;
			}
			else {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.rigth;
			}
		}
	}
	
	//recursive postorder
	public void postorder(treeNode root) {
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.rigth);
		System.out.print(root.data + " ");
		
	}
	
	//iterative postorder
	public void postOrder() {
		if(root == null) {
			return;
		}
		Stack <treeNode> stack = new Stack<>();
		treeNode current = root;
		while(current!=null || !stack.isEmpty()) {
			if(current!=null) {
			stack.push(current);
			current = current.left;
			}
			
		else {
			treeNode temp = stack.peek().rigth;;
			if(temp == null) {
				temp=stack.pop();
				System.out.print(temp.data + " ");
				while(!stack.isEmpty() && temp == stack.peek().rigth) {
					temp = stack.pop();
					System.out.print(temp.data + " ");
				}
			}
				else {
					current = temp;
				}
			}
		}
	}
	
	//level order
	public void levelorder(){
		if(root == null) {
			return;
		}
		Queue <treeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			treeNode temp = queue.poll();
			System.out.print(temp.data + " ");
			if(temp.left != null) {
				queue.offer(temp.left);
			}
			if(temp.rigth != null) {
				queue.offer(temp.rigth);
			}
		}
	}
	
	//find max
	
	public int findmax(treeNode root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}
		int result = root.data;
		int left = findmax(root.left);
		int right = findmax(root.rigth);
		
		if(left>result)
			result = left;
		if(right>result)
			result = right;
		
		return result;
	}
		public static void main(String[] args) {
			
		// TODO Auto-generated method stub
		binaryTreeImplementation bt = new binaryTreeImplementation();
		bt.createBinaryTree();
		System.out.println("The Preorder Traversing is through recursive - ");
		bt.preorder(bt.root);
		System.out.println();
		System.out.println("The Preorder Traversing is through iterative - ");
		bt.preOrder();
		System.out.println();
		System.out.println("The inorder Traversing is through recursive - ");
		bt.inorder(bt.root);
		System.out.println();
		System.out.println("The inorder Traversing is through iterative - ");
		bt.inOrder();
		System.out.println();
		System.out.println("The preorder Traversing is through recursive - ");
		bt.postorder(bt.root);
		System.out.println();
		System.out.println("The preorder Traversing is through iterative - ");
		bt.postOrder();
		System.out.println();
		System.out.println("The level order Traversing is through iterative - ");
		bt.levelorder();
		System.out.println();
		System.out.println("The Maximum value - " + bt.findmax(bt.root));
		
	}

}
