import java.util.*;
import java.lang.*;
import java.util.Scanner;
class node{
	int val;
	node left;
	node right;

	node(int val){
		this.val = val;
	}
}

class tree{
	node root;

	tree(){
		root = null;
	}

	void insert(int val){
		if(root == null){
			root = new node(val);
			return;
		}
		node cur = root;
		node prev = null;
		while(cur!=null){
			prev = cur;
			if(val <= cur.val)
				cur = cur.left;
			else
				cur = cur.right;
		}
		if(val<=prev.val)
			prev.left = new node(val);
		else
			prev.right = new node(val);
		return;
	}

	void build(int[] arr){
		int n = arr.length;
		if(n<=0) return;

		for(int i:arr)
			insert(i);
	}

	static node find_min(node nd){
		if(nd == null) return null;

		if(nd.left == null){
			return nd;
		} 

		node prev = null;
		node cur = nd.left;
		while(cur.left!=null){
			prev = cur;
			cur = cur.left;
		}
		cur.right = nd;
		prev.left = cur.right;
		return cur;
	}

	boolean delete(int val){
		if(root == null) return false;

		boolean left = true;
		node prev = null;
		node cur = root;

		while(cur!=null){
			if(val <cur.val){
				prev = cur;
				cur = cur.left;
				left = true;
			}else if(val > cur.val){
				prev = cur;
				cur = cur.right;
				left = false;
			}else{
				break;
			}
		}
		if(cur == null){
			return false;
		}

		if(cur == root)
			if(cur.left == null && cur.right == null)
				root = null;
			else if(cur.left == null || cur.right==null){
					root = (cur.left==null)?cur.right:cur.left;
			}else{
				node cand = find_min(cur.right);
				cand.left = cur.left;
				cand.right = cur.right;
			}
		else{
			if(cur.left == null && cur.right == null)
				if(left) prev.left = null;
				else cur.right = null;
			else if(cur.left == null || cur.right==null){
					node cand = (cur.left==null)?cur.right:cur.left;
					if(left) prev.left = cand;
					else	prev.right = cand;
			}else{
				node cand = find_min(cur.right);
				cand.left = cur.left;
				if(left) prev.left = cand;
				else	prev.right = cand;
			}

		}
		return true;
	}

	static void subInorder(node nd){
		if(nd == null) return;

		subInorder(nd.left);
		System.out.print(nd.val+", ");
		subInorder(nd.right);
	}

	void inorderRec(){
		subInorder(root);
		System.out.println();
	}


	static void subPreorder(node nd){
		if(nd == null) return;

		System.out.print(nd.val+", ");
		subPreorder(nd.left);
		subPreorder(nd.right);
	}

	void preorderRec(){
		subPreorder(root);
		System.out.println();
	}


	static void subPostorder(node nd){
		if(nd == null) return;

		subPostorder(nd.left);

		subPostorder(nd.right);
		System.out.print(nd.val+", ");

	}

	void postorderRec(){
		subPostorder(root);
		System.out.println();
	}

	void preordIter(){
		if(root == null) return;

		Stack<node> s = new Stack<node>();
		s.push(root);
		while(!s.isEmpty()){
			node nd = s.peek();
			s.pop();
			System.out.print(nd.val+" ");
			if(nd.right!=null)	s.push(nd.right);
			if(nd.left != null) s.push(nd.left);
		}
		System.out.println();
	}

	public void inOrderIter(){
		if(root == null) return;

		Stack<node>	s = new Stack<node>();
		node cur = root;

		while(cur!=null || !s.isEmpty()){
			if(cur!=null){
				s.push(cur);
				cur = cur.left;
			}else{
				cur = s.pop();
				System.out.print(cur.val+" ");
				cur = cur.right;
			}
		}	
		System.out.println();
	}

	public void postOrderIter(){
		if(root==null)  return;

		Stack<node> s = new Stack<node>();
		s.push(root);
		node prev = null;
		while(!s.isEmpty()){
			node cur = s.peek();
			if(prev == null || prev.left == cur || prev.right == cur){
				if(cur.left != null)	s.push(cur.left);
				else if (cur.right !=null)	s.push(cur.right);
			}
			else if(cur.left == prev){
				if(cur.right!= null)	s.push(cur.right);
			}else{
				System.out.print(cur.val + " ");
				s.pop();
			}
			prev = cur;
		}
	}

	public void printTreeShape(){}

	public void printByLevel(){
		if(root == null) return;

		LinkedList<node> q = new LinkedList<node>();
		q.addLast(root);
		int siz = 1;
		while(!q.isEmpty()){
			siz--;
			node cur = q.removeFirst();
			if(cur.left!=null) q.addLast(cur.left);
			if(cur.right!=null) q.addLast(cur.right);
			System.out.print(cur.val + " ");
			if(siz == 0){
				System.out.println();
				siz = q.size();
			}
		}
	}

	public void printZigZag(){
		if(root == null) return;

		ArrayList<node> q = new ArrayList<node>();
		q.add(root);
		int siz;
		boolean left = true;
		while(!q.isEmpty()){
			siz = q.size();
			for(int i = 0; i<siz; i++){
				if(q.get(i).left!=null) q.add(q.get(i).left);
				if(q.get(i).right!=null) q.add(q.get(i).right);
			}
			if(left){
				for(int i = 0; i<siz; i++){
					System.out.print(q.get(i).val + " ");
				}
			}
			else{
				for(int i = siz-1; i>=0; i--)
					System.out.print(q.get(i).val + " ");
			}
			for(int i = 0; i<siz; i++){
				q.remove(0);
			}
			left = !left;
			System.out.println();
		}
	}

	public void printEdge(){}

	public boolean rightRotate(node N){
		if(N==null || N.left == null) return false;

		node nd = N.left;
		N.left = nd.left;
		nd.left = nd.right;
		nd.right = N.right;
		N.right = nd;
		int t = N.val;
		N.val = nd.val;
		nd.val = t;
		return true;
	}

	public boolean leftRotate(node N){
		if(N==null || N.right == null) return false;

		node nd = N.right;
		N.right = nd.right;
		nd.right = nd.left;
		nd.left = N.left;
		N.left = nd;
		int t = N.val;
		N.val = nd.val;
		nd.val = t;
		return true;
	}

	public int BST2List(){
		node nd = root;
		int i=0;
		while(nd!=null){
			while(rightRotate(nd));
			nd = nd.right;
			i++;
		}
		nd = root;
		while(nd!=null){
			System.out.print(nd.val+" ");
			nd = nd.right;
		}
		System.out.println();
		return i;
	}

	public void List2BST(node N, int siz){
		if(N == null) return;

		node nd = N;
		node p;
		int j;
		for (int i=siz/2; i>0; i /=2){
			for(p = N,  j=0; j<i; j++, p=p.right)
				leftRotate(p);
		}
	}

	public void BalancingTree(){
		List2BST（root, BST2List()）；
	}

	public void reconstructBSTFromPreorder(int[] a){}

	public void reconstructBSTFromPostOrder(int[] a){}

	public void reconstructTreeFromPreInorder(int[] a, int[] b){}

	public void reconstructTreeFromPostInorder(int[] a, int[] b){}	

	public boolean checkBST(){return true;}


	public static void main(String[] args){
		String s = args[0];
		char[] ss = s.toCharArray();
		int[] arr = new int[ss.length];
		for(int i=0; i<ss.length; i++){
			arr[i] = Character.getNumericValue(ss[i]);
		}

		tree T = new tree();
		T.build(arr);
		//T.preorderRec();
		//T.preordIter();
		T.inorderRec();
		//T.inOrderIter();
		//T.postorderRec();
		//T.postOrderIter();
		//T.printByLevel();
		//T.printZigZag();
		int n = T.BST2List();
		T.List2BST(T.root, n);
		//System.out.println("Please input the int tp delete:");
		//Scanner in = new Scanner(System.in);
		//T.delete(in.nextInt());

		T.inorderRec();
	}


}